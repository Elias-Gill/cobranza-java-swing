package src.mediador;

import src.Banco;
import src.bankServer.data.Cuenta;
import src.bankServer.regsYcomprobs.DatosComprobante;
import src.gui.comprobante.Comprobante;
import src.gui.formulario.DatosFormulario;

public class Mediador {

    private Banco b = new Banco();
    public Cuenta cuentaActiva;

    public DatosComprobante NuevaTransferencia(DatosFormulario d) {
        return new DatosComprobante();
    }

    /*public void NuevoDeposito(Integer d) throws RuntimeException{
        // hacer la transaccion backend
        DatosComprobante c = new DatosComprobante();
        cuentaActiva.saldo += d;
        Comprobante comprobante = new Comprobante(c);
        comprobante.mostrarComprobante();
    }*/
    public Cuenta iniciarSesion(String contrasena, int cedula) throws Exception {
        cuentaActiva = b.iniciarSesion(contrasena, cedula);
        return new Cuenta();
    }

    /*public DatosComprobante PagarServicio(pin int, string servicio, int monto, metodo string) {
        // TODO  bank server
        return new DatosComprobante();
    }*/
    public DatosComprobante PagarTarjeta(DatosFormulario d) {
        return new DatosComprobante();
    }
}
