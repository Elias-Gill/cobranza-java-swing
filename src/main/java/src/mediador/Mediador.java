package src.mediador;

import java.sql.SQLException;
import src.bankServer.BankServer;
import src.bankServer.data.Cuenta;
import src.bankServer.regsYcomprobs.DatosComprobante;
import src.bankServer.regsYcomprobs.Deposito;
import src.bankServer.regsYcomprobs.PagoServicio;
import src.bankServer.regsYcomprobs.Transferencia;
import src.gui.comprobante.Comprobante;

public class Mediador {

    private BankServer server = new BankServer();
    public Cuenta cuentaActiva;

    // metodo para realizar una nueva transferencia
    public Comprobante NuevaTransferencia(int cuentaDestino, int monto, int pin) throws Exception {
        DatosComprobante d = server
            .NuevaTransferencia(new Transferencia(cuentaActiva.cedula, cuentaDestino, monto, pin));
        return new Comprobante(d);
    }

    // metodo para realizar un nuevo deposito
    public Comprobante NuevoDeposito(int monto) throws RuntimeException, ClassNotFoundException, SQLException {
        // por si acaso
        if (cuentaActiva == null) {
            throw new RuntimeException("Aun no se ha iniciado sesion");
        }
        DatosComprobante d = server.NuevoDeposito(new Deposito(cuentaActiva.cedula, monto));
        return new Comprobante(d);
    }

    // metodo para iniciar sesion
    public Cuenta IniciarSesion(String contrasena, int cedula) throws Exception {
        this.cuentaActiva = server.IniciarSesion(contrasena, cedula);
        return cuentaActiva;
    }

    // pagar un servicion externo (copaco, ANDE)
    public Comprobante PagarServicio(int pin, String servicio, int monto, String metodo) throws Exception {
        DatosComprobante d = server.PagarServicio(new PagoServicio(monto, servicio, cuentaActiva.cedula, pin, metodo));
        return new Comprobante(d);
    }

    public Comprobante PagarTarjeta(int monto) throws SQLException {
        DatosComprobante d = server.PagarTarjeta(cuentaActiva, monto);
        return new Comprobante(d);
    }

    private void comprobarPin() {

    }
}
