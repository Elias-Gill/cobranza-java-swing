package src.bankServer;

import java.sql.SQLException;

import src.bankServer.data.Cuenta;
import src.bankServer.regsYcomprobs.DatosComprobante;
import src.bankServer.regsYcomprobs.Deposito;
import src.bankServer.regsYcomprobs.PagoServicio;
import src.bankServer.regsYcomprobs.Transferencia;

public class BankServer {
    operacionesSQL sql = new operacionesSQL();

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

        return new DatosComprobante(t);
    }

    public DatosComprobante NuevoDeposito(Deposito d) throws ClassNotFoundException, SQLException {
        Cuenta destino = sql.obtenerCuenta(d.cuentaDestino);
        sql.setSaldo(d.monto + destino.saldo, d.cuentaDestino);
        return new DatosComprobante(d);
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
        pagarServicio(p.monto, p.servicio);
        if (p.metodo == "tarjeta") {
            sql.setSaldoTarjeta(c.saldo - p.monto, c.cedula);
        } else {
            sql.setSaldo(c.saldo - p.monto, c.cedula);
        }
        return new DatosComprobante(p);
    }

    public DatosComprobante PagarTarjeta(Cuenta c, int monto, String pin) {
        try {
            sql.pagarTarjeta(monto, c.cedula);
            sql.setSaldo(monto - c.saldo, c.cedula);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DatosComprobante(c.cedula, monto);
    }

    // no hay servicios para pagar
    private void pagarServicio(int m, String servicio) throws Exception {
        throw new Exception("No se puede conectar con el servicio. Debe de ser del gobierno o algo");
    }
}
