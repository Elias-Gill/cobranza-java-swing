package src.bankServer.data;

// clase uitlizada para el pago de serivcios externos
public class ServicioExterno {

    public String idServicio;
    public int deuda;

    public ServicioExterno(String idServicio, int deuda) {
        this.idServicio = idServicio;
        this.deuda = deuda;
    }
}
