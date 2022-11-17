package src.bankServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.bankServer.data.ServicioExterno;

public class serverServicio {
    private Connection cn;

    // buscar un servicio por su descripcion
    ServicioExterno getServicioNombre(String id) throws SQLException {
        iniciarBaseDeDatos();
        String query = String.format("SELECT * FROM Servicios WHERE id_Servicio=%s", id);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            ServicioExterno res = new ServicioExterno(rs.getInt("id_Servicio"), rs.getString("descripcion"));
            cn.close();
            return res;
        }
        cn.close();
        throw new SQLException("Unable to find account");
    }

    // buscar un servicio por su id
    ServicioExterno getServicioID(String descripcion) throws SQLException {
        iniciarBaseDeDatos();
        String query = String.format("SELECT * FROM Servicios WHERE descripcion=%s", descripcion);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            ServicioExterno res = new ServicioExterno(rs.getInt("id_Servicio"), rs.getString("descripcion"));
            cn.close();
            return res;
        }
        cn.close();
        throw new SQLException("Unable to find account");
    }

    // iniciar la conexion con la base de datos
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
