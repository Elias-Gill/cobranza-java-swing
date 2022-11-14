package bankServer.regsYcomprobs;

import java.time.*;

import bankServer.data.Cuenta;

public class DatosComprobante {
    public LocalDate fecha;
    public Integer id;
    public Integer monto;
    public Cuenta cuentaDestino;
    public String metodo;
    public String concepto;
}
