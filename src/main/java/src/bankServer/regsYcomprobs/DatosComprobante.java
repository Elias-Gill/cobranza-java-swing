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
}
