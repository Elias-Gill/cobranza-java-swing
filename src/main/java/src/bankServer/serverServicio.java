package src.bankServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.bankServer.data.ServicioExterno;

public class serverServicio {

    private Connection cn;

    serverServicio(Connection c) {
        cn = c;
    }

    // buscar un servicio por su descripcion
    ServicioExterno getServicioNombre(String id) throws SQLException {
        String query = String.format("SELECT * FROM servicios WHERE id_Servicio=%s", id);
        ResultSet rs = cn.createStatement().executeQuery(query);
        if (rs.next()) {
            ServicioExterno res
                    = new ServicioExterno(rs.getString("id_Servicio"), rs.getInt("deuda"));
            return res;
        }
        throw new SQLException("Unable to find service");
    }
}
