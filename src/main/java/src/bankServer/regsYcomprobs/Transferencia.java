package src.bankServer.regsYcomprobs;

public class Transferencia {
    public int cuentaOrigen;
    public int cuentaDestino;
    public int monto;
    public int pin;

    public Transferencia(int cuentaOrigen, int cuentaDestino, int monto, int pin) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.pin = pin;
    }
}
