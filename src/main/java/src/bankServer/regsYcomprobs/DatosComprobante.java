package src.bankServer.regsYcomprobs;

import java.time.LocalDate;

public class DatosComprobante {

    public Integer idComprobante;
    public String concepto;
    public Integer monto;
    public LocalDate fecha;
    public int cuentaDestino;
    public int cuentaOrigen;
    public String metodo;
    public String tipo;
    public String idServicio;

    // constructor vacio
    public DatosComprobante() {
    }

    // constructor completo
    public DatosComprobante(Integer idComprobante, String concepto, Integer monto, String fecha,
            int cuentaDestino, int cuentaOrigen, String idServicio) {

        this.idComprobante = idComprobante;
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = LocalDate.parse(fecha);
        this.cuentaDestino = cuentaDestino;
        this.cuentaOrigen = cuentaOrigen;
        this.idServicio = idServicio;
    }

    // Transferencia a otra cuenta
    public DatosComprobante(Transferencia t) {
        this.cuentaDestino = t.cuentaDestino;
        this.cuentaOrigen = t.cuentaOrigen;
        this.monto = t.monto;
        this.concepto = "Transferencia de dinero";
        this.fecha = LocalDate.now();
    }

    // deposito de dinero
    public DatosComprobante(Deposito d) {
        this.cuentaOrigen = d.cuentaOrigen;
        this.cuentaDestino = d.cuentaOrigen;
        this.monto = d.monto;
        this.concepto = "Deposito de dinero";
        this.fecha = LocalDate.now();
    }

    // pago de servicio externo
    public DatosComprobante(PagoServicio p) {
        this.cuentaOrigen = p.cuentaOrigen;
        this.monto = p.monto;
        this.concepto = "Pago de serivicio: " + p.servicio;
        this.idServicio = p.servicio;
        this.fecha = LocalDate.now();
    }

    // pago de deuda de tarjeta
    public DatosComprobante(int c, int monto, String metodo) {
        this.cuentaOrigen = c;
        this.monto = monto;
        this.concepto = "Pago de deuda Tarjeta de credito.";
        this.metodo = metodo;
        this.fecha = LocalDate.now();
    }
}
