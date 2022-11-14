package src.mediador;

import src.bankServer.data.Cuenta;
import src.bankServer.regsYcomprobs.DatosComprobante;
import src.gui.formularios.DatosFormulario;

public class Mediador {
<<<<<<< HEAD
    Cuenta cuentaActiva;
=======

    CuentaLogueo cuentaActiva;
>>>>>>> origin/master

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
