package src.bankServer;

/**
 *
 * @author Admin
 */
import java.sql.*;

public class Conexion {
    public Connection conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conectar = DriverManager.getConnection("jdbc:sqlite:webanking.db");
        return conectar;
    }
}
