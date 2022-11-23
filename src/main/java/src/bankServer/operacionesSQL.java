package src.bankServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.bankServer.data.Cuenta;

public class operacionesSQL {

    private Connection cn;

    // constructor
    public operacionesSQL(Connection c) {
        cn = c;
    }

    // Obtener una cuenta en base al numero de cedula del cliente
    public Cuenta obtenerCuentaCedula(int documentoIdentidad)
            throws ClassNotFoundException, SQLException {
        String query = String.format("SELECT * FROM Cuentas WHERE cedula=%d", documentoIdentidad);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            // cargar los datos de la cuenta
            int nroCuenta = rs.getInt("nro_cuenta");
            String direccion = rs.getString("direccion");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int cedula = rs.getInt("cedula");
            String telefono = rs.getString("telefono");
            int saldo = rs.getInt("saldo");
            int tarjetaID = rs.getInt("nro_Tarjeta");
            int pin = rs.getInt("pin_transaccion");
            String contrasena = rs.getString("contrasena");
            int saldo_Tarjeta = rs.getInt("saldo_Tarjeta");
            int pin_tarjeta = rs.getInt("pin_Tarjeta");
            int deudaTarjeta = rs.getInt("deuda_Tarjeta");
            // retorna la cuenta encontrada
            return new Cuenta(nroCuenta, direccion, nombre, apellido,
                    cedula, telefono, saldo, tarjetaID, pin,
                    contrasena, saldo_Tarjeta, pin_tarjeta, deudaTarjeta);
        }
        throw new SQLException("Unable to find account");
    }

    // Obtener una cuenta en base al numero de cuenta
    public Cuenta obtenerCuentaNro(int nroCuenta) throws ClassNotFoundException, SQLException {
        String query = String.format("SELECT * FROM Cuentas WHERE nro_cuenta=%d", nroCuenta);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            String direccion = rs.getString("direccion");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int cedula = rs.getInt("cedula");
            String telefono = rs.getString("telefono");
            int saldo = rs.getInt("saldo");
            int tarjetaID = rs.getInt("nro_Tarjeta");
            int pin = rs.getInt("pin_transaccion");
            String contrasena = rs.getString("contrasena");
            int saldo_Tarjeta = rs.getInt("saldo_Tarjeta");
            int pin_tarjeta = rs.getInt("saldo_Tarjeta");
            int deudaTarjeta = rs.getInt("deuda_Tarjeta");
            // retorna la cuenta encontrada
            return new Cuenta(nroCuenta, direccion, nombre, apellido,
                    cedula, telefono, saldo, tarjetaID, pin,
                    contrasena, saldo_Tarjeta, pin_tarjeta, deudaTarjeta);
        }
        throw new SQLException("Unable to find account");
    }

    // Establece un valor especifico al saldo de la cuenta dentro de la base de datos
    public void setSaldoCuenta(int monto, int cedula) throws SQLException {
        try {
            String query = String.format("UPDATE Cuentas SET saldo = ? WHERE cedula=%d", cedula);
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, monto);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(("Error al actualizar el saldo de cuenta" + e.toString()));
        }
    }

    // Establece un valor especifico al saldo de la tarjeta dentro de la base de datos
    public void setSaldoTarjeta(int monto, int cedula) throws SQLException {
        String query = String.format("UPDATE Cuentas SET saldo_Tarjeta = ? WHERE cedula=%d", cedula);
        PreparedStatement pstmt = cn.prepareStatement(query);
        pstmt.setInt(1, monto);
        pstmt.executeUpdate();
    }

    // realiza el proceso de pago de tarjeta
    public void pagarTarjeta(int monto, int cedula) throws SQLException {
        String query = String.format("SELECT * FROM Cuentas WHERE cedula=%d", cedula);
        ResultSet rs = cn.createStatement().executeQuery(query);
        int deudaTarjeta;
        int saldoActual;
        // comprobaciones
        if (rs.next()) {
            // comprobar que el monto no supere la deuda
            deudaTarjeta = rs.getInt("deuda_Tarjeta");
            saldoActual = rs.getInt("saldo_Tarjeta");
            if (deudaTarjeta < monto) {
                throw new RuntimeException("Monto no puede ser superior a la deuda");
            }
        } else {
            throw new RuntimeException("No se encontro la tarjeta");
        }

        // retornar al saldo disponible
        setSaldoTarjeta(saldoActual + monto, cedula);
        // restar de la deuda pendiente
        query = String.format("UPDATE Cuentas SET deudaTarjeta = ? WHERE cedula=%d", cedula);
        PreparedStatement pstmt = cn.prepareStatement(query);
        pstmt.setInt(1, deudaTarjeta - monto);
        pstmt.executeUpdate();
    }

    void setDeudaTarjeta(int monto, int cedula) throws SQLException {
        String query = String.format("UPDATE Cuentas SET deuda_Tarjeta = ? WHERE cedula=%d", cedula);
        PreparedStatement pstmt = cn.prepareStatement(query);
        pstmt.setInt(1, monto);
        pstmt.executeUpdate();
    }
}
