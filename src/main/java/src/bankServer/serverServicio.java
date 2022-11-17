package src.bankServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.bankServer.data.ServicioExterno;

public class serverServicio {

    private Connection cn;

    ServicioExterno getServicioNombre(String nombre) throws SQLException {
        iniciarBaseDeDatos();
        String query = String.format("SELECT * FROM Servicios WHERE nombre=%s", nombre);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            cn.close();
            return new ServicioExterno(rs.getInt("idServicio"), rs.getString("nombreServicio"));
        }
        cn.close();
        throw new SQLException("Unable to find account");
    }

    ServicioExterno getServicioID(int id) throws SQLException {
        iniciarBaseDeDatos();
        String query = String.format("SELECT * FROM Servicios WHERE nombre=%s", id);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            cn.close();
            return new ServicioExterno(rs.getInt("idServicio"), rs.getString("nombreServicio"));
        }
        cn.close();
        throw new SQLException("Unable to find account");
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
