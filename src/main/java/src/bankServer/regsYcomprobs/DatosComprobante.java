package src.bankServer.regsYcomprobs;

import java.time.LocalDate;

import src.bankServer.data.Cuenta;

public class DatosComprobante {

    public Integer id;
    public String concepto;
    public Integer monto;
    public LocalDate fecha;
    public Cuenta cuentaOrigen;
    public Cuenta cuentaDestino;
    public String metodo;
    public String tipos;

    public DatosComprobante(
            Integer id,
            String concepto,
            Integer monto,
            LocalDate fecha,
            Cuenta cuentaOrigen,
            Cuenta cuentaDestino,
            String metodo,
            String tipos) {
        this.id = id;
        this.concepto = concepto;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.metodo = metodo;
        this.tipos = tipos;
        this.fecha = fecha;
    }
}
