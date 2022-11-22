package src.bankServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.bankServer.data.Cuenta;

public class operacionesSQL {

	private Connection cn;

	public operacionesSQL(Connection c) {
		cn = c;
	}

	public Cuenta obtenerCuenta(int documentoIdentidad) throws ClassNotFoundException, SQLException {
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
			int tarjetaID = rs.getInt("nro_Tarjeta");
			int pin = rs.getInt("pin_transaccion");
			String contrasena = rs.getString("contrasena");
			int saldo_Tarjeta = rs.getInt("saldo_Tarjeta");
			// retorna la cuenta encontrada
			return new Cuenta(nroCuenta, direccion, nombre, apellido, cedula, telefono, saldo,
			    tarjetaID, pin, contrasena, saldo_Tarjeta);
		}
		throw new SQLException("Unable to find account");
	}

	// setea un saldo especifico, se usa para recuperacion de errores de transaccion
	// ja'e chupe
	public void setSaldo(int monto, int cedula) throws SQLException {
		try {
			String query = String.format("UPDATE Cuentas SET saldo = ? WHERE cedula=%d", cedula);
			PreparedStatement pstmt = cn.prepareStatement(query);
			pstmt.setInt(1, monto);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(("Error al actualizar el saldo de cuenta" + e.toString()));
		}
	}

	public void setSaldoTarjeta(int monto, int cedula) throws SQLException {
		String query = String.format("UPDATE Cuentas SET saldo_Tarjeta = ? WHERE cedula=%d", cedula);
		PreparedStatement pstmt = cn.prepareStatement(query);
		pstmt.setInt(1, monto);
		pstmt.executeUpdate();
	}

	public void pagarTarjeta(int monto, int cedula) throws SQLException {
		String query = String.format("SELECT * FROM Cuentas WHERE cedula=%d", cedula);
		ResultSet rs = cn.createStatement().executeQuery(query);
		int deudaTarjeta;
		if (rs.next()) {
			// comprobar que el monto no supere la deuda
			deudaTarjeta = rs.getInt("deuda_Tarjeta");
			if (deudaTarjeta < monto) {
				throw new RuntimeException("Monto invalido");
			}
		} else {
			throw new RuntimeException("No se encontro la tarjeta");
		}

		query = String.format("UPDATE Cuentas SET deuda_Tarjeta = ? WHERE cedula=%d", cedula);
		PreparedStatement pstmt = cn.prepareStatement(query);
		pstmt.setInt(1, deudaTarjeta - monto);
		pstmt.executeUpdate();
	}
}
