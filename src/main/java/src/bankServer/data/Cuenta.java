package src.bankServer.data;

public class Cuenta {
    public int nroCuenta;
    public String direccion;
    public String nombre;
    public String apellido;
    public int cedula;
    public String telefono;
    public int saldo;
    public Tarjeta tarjeta;
    public int pin;

    public Cuenta(int nroCuenta, String direccion, String nombre, String apellido,
            int cedula, String telefono, int saldo, Tarjeta tarjeta) {

        this.nroCuenta = nroCuenta;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.saldo = saldo;
        this.tarjeta = tarjeta;
    }

    public Cuenta() {

    }

    @Override
    public String toString() {
        String res = String.format(
                "Nro: %d \nNombre: %s\n Apellido: %s \nDireccion: %s \nCedula: %d \nTelefono: %s \nSaldo: %d",
                this.nroCuenta,
                this.nombre,
                this.apellido,
                this.direccion,
                this.cedula,
                this.telefono,
                this.saldo);
        return res;
    }
}
