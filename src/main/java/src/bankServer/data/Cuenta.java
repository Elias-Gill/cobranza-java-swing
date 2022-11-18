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

    public Cuenta(int nroCuenta, String direccion, String nombre, String apellido,
            int cedula, String telefono, int saldo, int tarjeta, int pin, String contrasena, int saldoTarjeta) {

        this.cedula = cedula;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.saldo = saldo;
        this.tarjeta = tarjeta;
        this.pin = pin;
        this.contrasena = contrasena;
        this.saldoTarjeta = saldoTarjeta;
    }

    @Override
    public String toString() {
        String res = String.format(
                "Nro: %d \nNombre: %s\n Apellido: %s \nDireccion: %s \nCedula: %d \nTelefono: %s \nSaldo: %d",
                this.cedula,
                this.nombre,
                this.apellido,
                this.direccion,
                this.cedula,
                this.telefono,
                this.saldo);
        return res;
    }

    public Cuenta() {}
}
