package src.bankServer.data;

// clase que contiene los datos proporcionados por la base de datos
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
    public int pinTarjeta;
    public int deudaTarjeta;

    // constructor normal
    public Cuenta(int nroCuenta, String direccion, String nombre,
            String apellido, int cedula, String telefono,
            int saldo, int tarjeta, int pin, String contrasena,
            int saldoTarjeta, int pin_tarjeta, int deuda_tarjeta) {

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
        this.pinTarjeta = pin_tarjeta;
        this.deudaTarjeta = deuda_tarjeta;
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
