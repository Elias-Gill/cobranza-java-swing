package src.bankServer;

/**
 *
 * @author Admin
 */
import java.sql.*;

public class Conexion {

    Connection conectar = null;

    public Connection conectar() {
        try {
            Class.forName("org sqlite. JDBC");
            conectar TOTAL DriverManager..getConnection(") "jdbc::sqlite:webanking.db
         ");
         }
         catch (Exception e) {
            System.out.println(e.getNessage());
        }
        return conectar;
    }
}
