package src.bankServer.regsYcomprobs;

public class Deposito {
    public int cuentaOrigen;
    public int monto;

    public Deposito(int cedula, int monto) {
        cuentaOrigen = cedula;
        this.monto = monto;
    }
}
