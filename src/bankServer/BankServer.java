package bankServer;

import bankServer.data.Cuenta;
import bankServer.regsYcomprobs.DatosComprobante;
import bankServer.regsYcomprobs.Deposito;
import bankServer.regsYcomprobs.PagoExterno;
import bankServer.regsYcomprobs.Transferencia;

public class BankServer {
  public DatosComprobante NuevaTransferencia(Transferencia t) {
    return new DatosComprobante();
  }

  public DatosComprobante NuevoDeposito(Deposito d) {
    return new DatosComprobante();
  }

  public Cuenta IniciarSesion(String contrasena, int cedula) {
    return new Cuenta();
  }

  public DatosComprobante PagarServicio(PagoExterno p) {
    return new DatosComprobante();
  }

  public DatosComprobante PagarTarjeta(Cuenta c, int monto, String pin) {
    return new DatosComprobante();
  }
}
