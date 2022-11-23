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

    /**
     * Funcion para iniciar y establecer la conexion con la base de datos.
     * Solo se utiliza durante el inicio.
     * 
     * @return
     */
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

    /**
     * Realiza una nueva transferencia de dinero entre dos cuentas. Realiza
     * las comprobaciones y la actualizacion del los saldos de ambas cuentas.
     * 
     * @param t
     * @return
     *         DatosComprobante
     * @throws RuntimeException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
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
            sql.setSaldoCuenta(origen.saldo - t.monto, t.cuentaOrigen);
            // sumar dinero al destino
            sql.setSaldoCuenta(destino.saldo + t.monto, t.cuentaDestino);
        } catch (SQLException e) {
            // si ocurre un error entonces restaurar el saldo de las cuentas
            sql.setSaldoCuenta(origen.saldo, t.cuentaOrigen);
            sql.setSaldoCuenta(destino.saldo, t.cuentaDestino);
            throw new SQLException("Problema de base de datos: " + e.toString());
        }

        DatosComprobante dc = new DatosComprobante(t);
        gr.nuevoRegistro(dc);
        return dc;
    }

    /**
     * Realiza un nuevo deposito de dinero a una cuenta. Realiza la
     * comprobacion y la actualizacion del saldo correspondiente.
     * 
     * @param d
     * @return
     *         DatosComprobante
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public DatosComprobante NuevoDeposito(Deposito d) throws ClassNotFoundException, SQLException {
        Cuenta destino = sql.obtenerCuentaCedula(d.cuentaOrigen);
        sql.setSaldoCuenta(d.monto + destino.saldo, d.cuentaOrigen);

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

    /**
     * Funcion que solo retorna la deuda de un determinado servicio. No requiere de
     * parametros especiales, solo el ID del servicio.
     * 
     * @param idServicio
     * @return
     *         int: deuda de servicio
     * @throws SQLException
     */
    public int getDeudaServicio(String idServicio) throws SQLException {
        return servicios.getServicioNombre(idServicio).deuda;
    }

    /**
     * Funcion que realiza el pago de un determinado servicio. Se encarga de
     * "conectarse" al servicio, realizar las comprobaciones necesarias y generar un
     * descuento del saldo de la cuenta o aumentar la deuda de la tarjeta de
     * credito, dependiendo del metodo de pago escogido.
     * 
     * @param p
     * @return
     *         DatosComprobante
     * @throws Exception
     */
    public DatosComprobante PagarServicio(PagoServicio p) throws Exception {
        // conectarse con el servicio a pagar
        ServicioExterno servicio = servicios.getServicioNombre(p.servicio);
        if (p.monto > servicio.deuda) {
            throw new Exception("El monto a pagar es superior a la deuda");
        }

        // comprobar pin de transaccion o pin de tarjeta.
        Cuenta c = sql.obtenerCuentaCedula(p.cuentaOrigen);
        if (c.pin != p.pin && c.pinTarjeta != p.pin) {
            throw new Exception("Pin incorrecto");
        }

        // determinar el metodo de transaccion.
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
            sql.setSaldoCuenta(c.saldo - p.monto, c.cedula);
        }

        DatosComprobante dc = new DatosComprobante(p);
        gr.nuevoRegistro(dc);
        return dc;
    }

    /**
     * Funcion para realizar el pago de la deuda de alguna tarjeta asociada
     * a una cuenta. La dueda se descuenta de la tarjeta, el saldo aumenta y se
     * resta del saldo de la cuenta del cliente.
     * 
     * @param c
     * @param monto
     * @return
     *         DatosComprobante
     * @throws SQLException
     */
    public DatosComprobante PagarTarjeta(Cuenta c, int monto) throws SQLException {
        sql.pagarTarjeta(monto, c.cedula);
        sql.setSaldoCuenta(c.saldo - monto, c.cedula);

        DatosComprobante dc = new DatosComprobante(c.cedula, monto);
        gr.nuevoRegistro(dc);
        return dc;
    }
}
