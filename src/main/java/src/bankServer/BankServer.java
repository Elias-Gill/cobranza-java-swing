package src.bankServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import src.bankServer.data.Cuenta;
import src.bankServer.data.ServicioExterno;
import src.bankServer.regsYcomprobs.DatosComprobante;
import src.bankServer.regsYcomprobs.Deposito;
import src.bankServer.regsYcomprobs.PagoServicio;
import src.bankServer.regsYcomprobs.Transferencia;

public class BankServer {

    private static Connection cn = iniciarBaseDeDatos();
    private static operacionesSQL sql = new operacionesSQL(cn);
    private static generadorRegistro gr = new generadorRegistro(cn);
    private static serverServicio servicios = new serverServicio(cn);

    // iniciar la base de datos
    private static Connection iniciarBaseDeDatos() {
        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:webanking.db");
            return cn;
        } catch (SQLException e) {
            System.out.println(("Error al iniciar servidor: " + e.toString()));
            System.exit(0);
        } catch (ClassNotFoundException e) {
            System.out.println(("Error al iniciar servidor: " + e.toString()));
            System.exit(0);
        }
        return cn;
    }

    public DatosComprobante NuevaTransferencia(Transferencia t)
            throws RuntimeException, ClassNotFoundException, SQLException {
        Cuenta origen = sql.obtenerCuentaCedula(t.cuentaOrigen);
        Cuenta destino = sql.obtenerCuentaNro(t.cuentaDestino);
        // revisar pin de transaccion
        if (origen.pin != t.pin) {
            throw new RuntimeException("PIN proporcionado invalido");
        }
        // comprobar que la cuenta tenga saldo suficiente
        if (origen.saldo < t.monto) {
            throw new RuntimeException("Saldo insuficiente");
        }

        // realizar la transaccion
        try {
            // restar dinero al origen
            sql.setSaldo(origen.saldo - t.monto, t.cuentaOrigen);
            // sumar dinero al destino
            sql.setSaldo(destino.saldo + t.monto, t.cuentaDestino);
        } catch (SQLException e) {
            // si ocurre un error entonces restaurar el saldo de las cuentas
            sql.setSaldo(origen.saldo, t.cuentaOrigen);
            sql.setSaldo(destino.saldo, t.cuentaDestino);
            throw new SQLException("Problema de base de datos: " + e.toString());
        }

        DatosComprobante dc = new DatosComprobante(t);
        gr.nuevoRegistro(dc);
        return dc;
    }

    public DatosComprobante NuevoDeposito(Deposito d) throws ClassNotFoundException, SQLException {
        Cuenta destino = sql.obtenerCuentaCedula(d.cuentaOrigen);
        sql.setSaldo(d.monto + destino.saldo, d.cuentaOrigen);

        DatosComprobante dc = new DatosComprobante(d);
        gr.nuevoRegistro(dc);
        return dc;
    }

    public Cuenta IniciarSesion(String contrasena, int cedula)
            throws RuntimeException, ClassNotFoundException, SQLException {
        Cuenta c = sql.obtenerCuentaCedula(cedula);
        if (c.contrasena.compareTo(contrasena) == 0) {
            return c;
        }
        throw new RuntimeException("Credenciales invalidas");
    }

    // retorna solo la deuda de un servicio
    public int getDeudaServicio(String idServicio) throws SQLException {
        return servicios.getServicioNombre(idServicio).deuda;
    }

    // funcion para realizar el pago de un servicio
    public DatosComprobante PagarServicio(PagoServicio p) throws Exception {
        // conectarse con el servicio a pagar
        ServicioExterno servicio = servicios.getServicioNombre(p.servicio);
        if (p.monto > servicio.deuda) {
            throw new Exception("El monto a pagar es superior a la deuda");
        }

        // comprobar pin de transaccion o pin de tarjeta
        Cuenta c = sql.obtenerCuentaCedula(p.cuentaOrigen);
        if (c.pin != p.pin && c.pinTarjeta != p.pin) {
            throw new Exception("Pin incorrecto");
        }

        // determinar el metodo de transaccion
        if (p.metodo == "Tarjeta") {
            if (c.saldoTarjeta < p.monto) {
                throw new Exception("Fondos insuficientes");
            }
            sql.setSaldoTarjeta(c.saldoTarjeta - p.monto, c.cedula);
            sql.setDeudaTarjeta(c.saldoTarjeta + p.monto, c.cedula);

        } else {
            if (c.saldo < p.monto) {
                throw new Exception("Fondos insuficientes");
            }
            sql.setSaldo(c.saldo - p.monto, c.cedula);
        }

        DatosComprobante dc = new DatosComprobante(p);
        gr.nuevoRegistro(dc);
        return dc;
    }

    public DatosComprobante PagarTarjeta(Cuenta c, int monto) throws SQLException {
        sql.pagarTarjeta(monto, c.cedula);
        sql.setSaldo(c.saldo - monto, c.cedula);

        DatosComprobante dc = new DatosComprobante(c.cedula, monto);
        gr.nuevoRegistro(dc);
        return dc;
    }
}
