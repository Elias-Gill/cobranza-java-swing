package src.bankServer.regsYcomprobs;

import java.time.LocalDate;

public class DatosComprobante {

    public Integer id;
    public String concepto;
    public Integer monto;
    public LocalDate fecha;
    public int cuentaOrigen;
    public int cuentaDestino;
    public String metodo;
    public String tipo;

    // constructor vacio
    public DatosComprobante() { }

    // Transferencia a otra cuenta
    public DatosComprobante(Transferencia t) {
        this.cuentaDestino = t.cuentaDestino;
        this.cuentaOrigen = t.cuentaOrigen;
        this.monto = t.monto;
        this.concepto = "Transferencia de dinero"; 
    }

    // deposito de dinero
    public DatosComprobante(Deposito d) {
        this.cuentaDestino = d.cuentaDestino;
        this.monto = d.monto;
        this.concepto = "Deposito de dinero"; 
    }

    // pago de servicio externo
    public DatosComprobante(PagoServicio p) {
        this.cuentaOrigen = p.cuentaOrigen;
        this.monto = p.monto;
        this.concepto = "Pago de serivicio: " + p.servicio + " con " + p.metodo;
    }

    // pago de deuda de tarjeta
    public DatosComprobante(int c, int monto) {
        this.cuentaOrigen = c;
        this.monto = monto;
        this.concepto = "Pago de deuda Tarjeta de credito.";
    }
}
