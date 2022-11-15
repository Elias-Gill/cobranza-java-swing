package src.bankServer.data;

public class Cuenta {
    int nroCuenta;
    String direccion;
    String nombre;
    String apellido;
    int cedula;
    int telefono;
    int saldo;
    Tarjeta tarjeta;

    public Cuenta(
            int nroCuenta,
            String direccion,
            String nombre,
            String apellido,
            int cedula,
            int telefono,
            int saldo,
            Tarjeta tarjeta) {

        this.nroCuenta = nroCuenta;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.saldo = saldo;
        this.tarjeta = tarjeta;
    }

    public Cuenta() {}
}
