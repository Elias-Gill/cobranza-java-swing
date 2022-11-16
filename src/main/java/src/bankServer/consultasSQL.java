package src.bankServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.bankServer.data.Cuenta;
import src.bankServer.data.Tarjeta;

public class consultasSQL {

    private Connection cn;

    public Cuenta obtenerCuenta(int nro_cuenta) throws ClassNotFoundException, SQLException {
        iniciarBaseDeDatos();
        //String query = String.format("SELECT * FROM Cuenta WHERE nro_cuenta=%d", nro_cuenta);
        String query = String.format("SELECT * from Cuenta");
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            int nroCuenta = rs.getInt("nro_cuenta");
            String direccion = rs.getString("direccion");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int cedula = rs.getInt("cedula");
            String telefono = rs.getString("telefono");
            int saldo = rs.getInt("saldo");
            int tarjetaID = rs.getInt("id_tarjeta");
            // retorna la cuenta encontrada
            cn.close();
            return new Cuenta(nroCuenta, direccion, nombre, apellido, cedula, telefono, saldo,
                    obtenerTarjeta(tarjetaID));
        }
        cn.close();
        throw new SQLException("Unable to find account");
    }

    // TODO terminar consulta sql
    public Tarjeta obtenerTarjeta(int tarjetaID) throws SQLException {
        iniciarBaseDeDatos();
        String query = String.format("SELECT * FROM Cuenta WHERE id_tarjeta=%d", tarjetaID);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            /*
             * int nroCuenta = rs.getInt("nro_cuenta");
             * String direccion = rs.getString("direccion");
             * String nombre = rs.getString("nombre");
             * String apellido = rs.getString("apellido");
             * int cedula = rs.getInt("cedula");
             * String telefono = rs.getString("telefono");
             * int saldo = rs.getInt("saldo");
             */
            // retorna la tarjeta encontrada
            cn.close();
            return new Tarjeta();
        }
        cn.close();
        throw new SQLException("Unable to find Credit card");
    }

    // funcion para sumar saldo al saldo actual de la cuenta
    public void sumarSaldo(int numCuenta, int monto) throws SQLException {
        iniciarBaseDeDatos();
        String query = String.format("SELECT * FROM Cuenta WHERE nro_cuenta=%d", numCuenta);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            // saldo actualizado
            int saldo = rs.getInt("saldo") + monto;
            // set nuevo saldo
            query = String.format("UPDATE warehouses SET saldo = ? WHERE nro_cuenta=%d", numCuenta);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, saldo);
            pstmt.executeUpdate();
            cn.close();
            return; // terminar con exito
        }
        cn.close(); // si no se encuentra la cuenta
        throw new SQLException("Unable to set update saldo");
    }

    // funcion para restar saldo al saldo actual de la cuenta
    public void restarSaldo(int numCuenta, int monto) throws SQLException {
        iniciarBaseDeDatos();
        String query = String.format("SELECT * FROM Cuenta WHERE nro_cuenta=%d", numCuenta);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            // calcular el saldo final
            int saldo = rs.getInt("saldo") - monto;
            // actualizar el saldo
            query = String.format("UPDATE warehouses SET saldo = ? WHERE nro_cuenta=%d", numCuenta);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, saldo);
            pstmt.executeUpdate();
            cn.close();
            return; // terminar con exito
        }
        cn.close(); // si no se encuentra la cuenta
        throw new SQLException("Unable to set update saldo");
    }

    // setea un saldo especifico, se usa para recuperacion de errores de transaccion ja'e chupe
    public void setSaldoEspecifico(int monto, int numCuenta) {
        iniciarBaseDeDatos();
        try {
            String query = String.format("UPDATE warehouses SET saldo = ? WHERE nro_cuenta=%d", numCuenta);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, monto);
            pstmt.executeUpdate();
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // iniciar la base de datos
    public void iniciarBaseDeDatos() {
        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:webanking.db");
        } catch (Exception e) {
            System.out.println("No se pudo conectar con la base de datos");
            System.exit(0);
        }
    }
}
