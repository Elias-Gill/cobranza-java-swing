package src.bankServer.regsYcomprobs;

import java.time.LocalDate;
import src.bankServer.data.ServicioExterno;

public class DatosComprobante {

    public Integer idComprobante;
    public String concepto;
    public Integer monto;
    public LocalDate fecha;
    public int cuentaOrigen;
    public int cuentaDestino;
    public String metodo;
    public String tipo;
    public String idServicio;

    // constructor vacio
    public DatosComprobante() {
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
        this.cuentaDestino = d.cuentaDestino;
        this.monto = d.monto;
        this.concepto = "Deposito de dinero";
        this.fecha = LocalDate.now();
    }

    // pago de servicio externo
    public DatosComprobante(PagoServicio p) {
        this.cuentaOrigen = p.cuentaOrigen;
        this.monto = p.monto;
        this.concepto = "Pago de serivicio: " + p.servicio + " con " + p.metodo;
        this.idServicio = p.servicio;
        this.fecha = LocalDate.now();
    }

    // pago de deuda de tarjeta
    public DatosComprobante(int c, int monto) {
        this.cuentaOrigen = c;
        this.monto = monto;
        this.concepto = "Pago de deuda Tarjeta de credito.";
        this.fecha = LocalDate.now();
    }
}
