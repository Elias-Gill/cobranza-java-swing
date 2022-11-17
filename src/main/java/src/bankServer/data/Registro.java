package src.bankServer.data;

import java.time.LocalDate;

public class Registro {

    int id_registro;
    int cuenta_destino;
    int monto;
    LocalDate fecha_transaccion;
    int forma_pago;
    String concepto;
    ServicioExterno servicio;
    int cuenta_origen;

    public Registro(int id_registro, int cuenta_destino, int monto, LocalDate fecha_transaccion, int forma_pago, String concepto, ServicioExterno servicio, int cuenta_origen) {
        this.concepto = concepto;
        this.id_registro = id_registro;
        this.cuenta_destino = cuenta_destino;
        this.monto = monto;
        this.fecha_transaccion = fecha_transaccion;
        this.forma_pago = forma_pago;
        this.servicio = servicio;
        this.cuenta_origen = cuenta_origen;
    }
}
