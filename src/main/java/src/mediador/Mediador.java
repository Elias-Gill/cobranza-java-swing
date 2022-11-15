package src.mediador;

import src.Banco;
import src.bankServer.data.Cuenta;
import src.bankServer.regsYcomprobs.DatosComprobante;
import src.gui.formulario.DatosFormulario;

public class Mediador {
    Banco b = new Banco();
    Cuenta cuentaActiva;

    public DatosComprobante NuevaTransferencia(DatosFormulario d) {
        return new DatosComprobante();
    }

    public DatosComprobante NuevoDeposito(DatosFormulario d) {
        return new DatosComprobante();
    }

    public Cuenta iniciarSesion(String contrasena, int cedula) throws Exception {
        cuentaActiva = b.iniciarSesion(contrasena, cedula);
        return new Cuenta();
    }

    public DatosComprobante PagarServicio(DatosFormulario d) {
        return new DatosComprobante();
    }

    public DatosComprobante PagarTarjeta(DatosFormulario d) {
        return new DatosComprobante();
    }
}
