package src.bankServer.regsYcomprobs;

public class Deposito {
    public int cuentaDestino;
    public int monto;

    public Deposito(int cedula, int monto) {
        cuentaDestino = cedula;
        this.monto = monto;
    }
}
