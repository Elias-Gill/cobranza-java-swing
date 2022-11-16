package src.bankServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.bankServer.data.Cuenta;

public class consultasSQL {
    private Connection cn;

    public Cuenta obtenerCuenta(int documentoIdentidad) throws ClassNotFoundException, SQLException {
        iniciarBaseDeDatos();
        String query = String.format("SELECT * FROM Cuentas WHERE cedula=%d", documentoIdentidad);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            int nroCuenta = rs.getInt("nro_cuenta");
            String direccion = rs.getString("direccion");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int cedula = rs.getInt("cedula");
            String telefono = rs.getString("telefono");
            int saldo = rs.getInt("saldo");
            int tarjetaID = rs.getInt("numero_Tarjeta");
            int pin = rs.getInt("pin_transaccion");
            String contrasena = rs.getString("contrasena");
            // retorna la cuenta encontrada
            cn.close();
            return new Cuenta(nroCuenta, direccion, nombre, apellido, cedula, telefono, saldo,
                    tarjetaID, pin, contrasena);
        }
        cn.close();
        throw new SQLException("Unable to find account");
    }

    // funcion para sumar saldo al saldo actual de la cuenta
    public void sumarSaldo(int cedula, int monto) throws SQLException {
        iniciarBaseDeDatos();
        Cuenta c;
        try {
            c = obtenerCuenta(cedula);
            int saldo = c.saldo + monto;
            // set nuevo saldo
            String query = String.format("UPDATE warehouses SET saldo = ? WHERE cedula=%d", cedula);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, saldo);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new SQLException("Unable to update saldo");
        } finally {
            cn.close(); // si no se encuentra la cuenta
        }
    }

    // funcion para restar saldo al saldo actual de la cuenta
    public void restarSaldo(int cedula, int monto) throws SQLException {
        iniciarBaseDeDatos();
        Cuenta c;
        try {
            c = obtenerCuenta(cedula);
            int saldo = c.saldo - monto;
            // set nuevo saldo
            String query = String.format("UPDATE warehouses SET saldo = ? WHERE cedula=%d", cedula);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, saldo);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new SQLException("Unable to update saldo");
        } finally {
            cn.close(); // si no se encuentra la cuenta
        }
    }

    // setea un saldo especifico, se usa para recuperacion de errores de transaccion
    // ja'e chupe
    public void setSaldoEspecifico(int monto, int cedula) throws SQLException {
        iniciarBaseDeDatos();
        try {
            String query = String.format("UPDATE warehouses SET saldo = ? WHERE cedula=%d", cedula);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, monto);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cn.close(); // si no se encuentra la cuenta
        }
    }

    // iniciar la base de datos
    public void iniciarBaseDeDatos() {
        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:webanking.db");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
