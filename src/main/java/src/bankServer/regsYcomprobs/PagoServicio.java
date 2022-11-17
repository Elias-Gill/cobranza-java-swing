package src.bankServer.regsYcomprobs;

public class PagoServicio {
    public int monto;
    public String servicio;
    public int cuentaOrigen;
    public int pin;
    public String metodo;

    public PagoServicio(int monto, String servicio, int cuentaOrigen, int pin, String metodo) {
        this.monto = monto;
        this.idServicio = idServicio;
        this.cuentaOrigen = cuentaOrigen;
        this.pin = pin;
        this.metodo = metodo;
    }
}
