package src.bankServer;

import java.sql.SQLException;

import src.bankServer.data.Cuenta;
import src.bankServer.regsYcomprobs.DatosComprobante;
import src.bankServer.regsYcomprobs.Deposito;
import src.bankServer.regsYcomprobs.PagoServicio;
import src.bankServer.regsYcomprobs.Transferencia;

import java.sql.DriverManager;
import java.sql.Connection;

public class BankServer {
    private static Connection cn = iniciarBaseDeDatos();
    private static operacionesSQL sql = new operacionesSQL(cn);
    private static generadorRegistro gr = new generadorRegistro(cn);

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

    public DatosComprobante NuevaTransferencia(Transferencia t) throws Exception {
        Cuenta origen = sql.obtenerCuenta(t.cuentaOrigen);
        Cuenta destino = sql.obtenerCuenta(t.cuentaDestino);
        // revisar pin de transaccion
        if (origen.pin != t.pin) {
            throw new Exception("PIN proporcionado invalido");
        }
        // comprobar que la cuenta tenga saldo suficiente
        if (origen.saldo < t.monto) {
            throw new Exception("Saldo insuficiente");
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
            throw new Exception("Problema de base de datos: " + e.toString());
        }

        DatosComprobante dc = new DatosComprobante(t);
        gr.nuevoRegistro(dc);
        return dc;
    }

    public DatosComprobante NuevoDeposito(Deposito d) throws ClassNotFoundException, SQLException {
        Cuenta destino = sql.obtenerCuenta(d.cuentaOrigen);
        sql.setSaldo(d.monto + destino.saldo, d.cuentaOrigen);

        DatosComprobante dc = new DatosComprobante(d);
        gr.nuevoRegistro(dc);
        return dc;
    }

    public Cuenta IniciarSesion(String contrasena, int cedula) throws Exception {
        Cuenta c = sql.obtenerCuenta(cedula);
        if (c.contrasena.compareTo(contrasena) == 0) {
            return c;
        }
        throw new Exception("Credenciales invalidas");
    }

    public DatosComprobante PagarServicio(PagoServicio p) throws Exception {
        // comprobar pin de transaccion
        Cuenta c = sql.obtenerCuenta(p.cuentaOrigen);
        if (c.pin != p.pin) {
            throw new Exception("Pin de transaccion incorrecto");
        }

        if (p.metodo == "tarjeta") {
            if (c.saldoTarjeta < p.monto) {
                throw new Exception("Fondos insuficientes");
            }
            pagarServicio(p.monto, p.servicio);
            sql.setSaldoTarjeta(c.saldoTarjeta - p.monto, c.cedula);

        } else {
            if (c.saldo < p.monto) {
                throw new Exception("Fondos insuficientes");
            }
            pagarServicio(p.monto, p.servicio);
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

    // no hay servicios para pagar
    private void pagarServicio(int m, String servicio) throws Exception {
        throw new Exception("No se puede conectar con el servicio. \nDebe de ser cosa del gobierno o algo");
    }
}
