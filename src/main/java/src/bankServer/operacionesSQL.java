package src.bankServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sqlite.SQLiteException;

import src.bankServer.data.Cuenta;

public class operacionesSQL {
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

    // setea un saldo especifico, se usa para recuperacion de errores de transaccion
    // ja'e chupe
    public void setSaldo(int monto, int cedula) throws SQLException {
        iniciarBaseDeDatos();
        try {
            String query = String.format("UPDATE Cuentas SET saldo = ? WHERE cedula=%d", cedula);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, monto);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(("Error al actualizar el saldo de cuenta" + e.toString()));
        } finally {
            cn.close(); // si no se encuentra la cuenta
        }
    }

    public void setSaldoTarjeta(int monto, int cedula) throws SQLException {
        iniciarBaseDeDatos();
        try {
            String query = String.format("UPDATE Cuentas SET saldo_Tarjeta = ? WHERE cedula=%d", cedula);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, monto);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(("Error al actualizar saldo de tarjeta" + e.toString()));
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
            System.out.println(("Error al iniciar servidor: " + e.toString()));
            System.exit(0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void pagarTarjeta(int monto, int cedula) throws SQLException {
        iniciarBaseDeDatos();
        String query = String.format("SELECT * FROM Cuentas WHERE cedula=%d", cedula);
        ResultSet rs = cn.createStatement().executeQuery(query);
        int deudaTarjeta;
        if (rs.next()) {
            deudaTarjeta = rs.getInt("deuda_Tarjeta");

            if (deudaTarjeta < monto) {
                throw new RuntimeException("Monto invalido");
            }
        } else {
            throw new RuntimeException("No se encontro la cuenta");
        }

        try {
            query = String.format("UPDATE Cuentas SET deuda_Tarjeta = ? WHERE cedula=%d", cedula);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, deudaTarjeta - monto);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(("Error al actualizar saldo de tarjeta" + e.toString()));
        } finally {
            cn.close(); // si no se encuentra la cuenta
        }
    }
}
