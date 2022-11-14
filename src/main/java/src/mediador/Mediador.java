package src.mediador;

import bankServer.CuentaLogueo;
import bankServer.DatosComprobante;
import gui.DatosFormulario;

public class Mediador {

    CuentaLogueo cuentaActiva;

    public DatosComprobante NuevaTransferencia(DatosFormulario d) {
        return new DatosComprobante();
    }

    public DatosComprobante NuevoDeposito(DatosFormulario d) {
        return new DatosComprobante();
    }

    public DatosComprobante IniciarSesion(String contrasena, int cedula) {
        return new DatosComprobante();
    }

    public DatosComprobante PagarServicio(DatosFormulario d) {
        return new DatosComprobante();
    }

    public DatosComprobante PagarTarjeta(DatosFormulario d) {
        return new DatosComprobante();
    }
}
