package src.bankServer.data;

public class Cuenta {
    public int cedula;
    public String direccion;
    public String nombre;
    public String apellido;
    public int nroCuenta;
    public String telefono;
    public int saldo;
    public int tarjeta;
    public int saldoTarjeta;
    public int pin;
    public String contrasena;
    public int pin_tarjeta;

    // constructor normal
    public Cuenta(int nroCuenta, String direccion, String nombre,
            String apellido, int cedula, String telefono,
            int saldo, int tarjeta, int pin, String contrasena,
            int saldoTarjeta, int pin_tarjeta) {

        this.cedula = cedula;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroCuenta = nroCuenta;
        this.telefono = telefono;
        this.saldo = saldo;
        this.tarjeta = tarjeta;
        this.saldoTarjeta = saldoTarjeta;
        this.pin = pin;
        this.contrasena = contrasena;
        this.pin_tarjeta = pin_tarjeta;
    }

    @Override
    public String toString() {
        String res = String.format(
                "Nro: %d \n"
                        + "Nombre: %s\n"
                        + " Apellido: %s \n"
                        + "Direccion: %s \n"
                        + "Cedula: %d \n"
                        + "Telefono: %s \n"
                        + "Saldo: %d",
                this.cedula,
                this.nombre,
                this.apellido,
                this.direccion,
                this.cedula,
                this.telefono,
                this.saldo);
        return res;
    }

    // constructor vacio
    public Cuenta() {
    }
}
