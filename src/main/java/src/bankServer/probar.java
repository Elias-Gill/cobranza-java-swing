package src.bankServer;

import java.sql.SQLException;

public class probar {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        consultasSQL consultas = new consultasSQL();
        consultas.obtenerCuenta(1);
    }

}
