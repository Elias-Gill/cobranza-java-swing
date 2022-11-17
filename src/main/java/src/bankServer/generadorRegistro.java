package src.bankServer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import src.bankServer.regsYcomprobs.DatosComprobante;

public class generadorRegistro {

    private Connection cn;

    public void nuevoRegistro(DatosComprobante datos) throws SQLException {
        iniciarBaseDeDatos();
        datos.idComprobante = datos.hashCode();
        PreparedStatement ps = cn.prepareStatement("INSERT INTO Registro VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

        ps.setInt(1, datos.idComprobante);
        ps.setInt(2, datos.cuentaDestino);
        ps.setInt(3, datos.monto);
        ps.setDate(4, new Date(datos.fecha.getYear(), datos.fecha.getMonthValue(), datos.fecha.getDayOfMonth()));
        ps.setString(5, datos.metodo); // forma pago
        ps.setString(6, datos.concepto);
        ps.setString(7, datos.idServicio);
        ps.setInt(8, datos.cuentaOrigen);
        ps.executeUpdate();
        cn.close();
    }

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
}
