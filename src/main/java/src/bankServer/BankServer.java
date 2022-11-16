package src.bankServer;

import src.bankServer.data.Cuenta;
import src.bankServer.regsYcomprobs.DatosComprobante;
import src.bankServer.regsYcomprobs.Deposito;
import src.bankServer.regsYcomprobs.PagoExterno;
import src.bankServer.regsYcomprobs.Transferencia;

import java.sql.SQLException;

import src.bankServer.consultasSQL;

public class BankServer {
    consultasSQL consulta = new consultasSQL();

    public DatosComprobante NuevaTransferencia(Transferencia t) throws Exception {
        Cuenta origen = consulta.obtenerCuenta(t.cuentaOrigen);
        Cuenta destino = consulta.obtenerCuenta(t.cuentaDestino);
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
            consulta.sumarSaldo(t.cuentaDestino, t.monto);
            consulta.restarSaldo(t.cuentaOrigen, t.monto);
        } catch (SQLException e) { 
            // si ocurre un error entonces devolver el dinero
            consulta.setSaldoEspecifico(origen.saldo, t.cuentaOrigen);
            consulta.setSaldoEspecifico(destino.saldo, t.cuentaDestino);
            throw new Exception("Problema de base de datos: " + e.toString());
        }

        // TODO  agregar comprobante
        return new DatosComprobante();
    }

    public DatosComprobante NuevoDeposito(Deposito d) throws ClassNotFoundException, SQLException {
        consulta.sumarSaldo(d.cuentaOrigen, d.monto);
        return new DatosComprobante();
    }

    public Cuenta IniciarSesion(String contrasena, int cedula) throws Exception {
        Cuenta c = consulta.obtenerCuenta(cedula);
        if (c.contrasena.compareTo(contrasena) == 0) {
            return c;
        }
        throw new Exception("Credenciales invalidas");
    }

    public DatosComprobante PagarServicio(PagoExterno p) {
        return new DatosComprobante();
    }

    public DatosComprobante PagarTarjeta(Cuenta c, int monto, String pin) {
        return new DatosComprobante();
    }
}
