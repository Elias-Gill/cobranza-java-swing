package src.bankServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.bankServer.data.Cuenta;
import src.bankServer.data.Tarjeta;

public class consultasSQL {

    public void obtenerCuenta(int nro_cuenta) throws ClassNotFoundException {
        try {
            Conexion CC = new Conexion();
            Connection cn = CC.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELCT * FROM Cuenta");
            while (rs.next()) {
                if (nro_cuenta == rs.getInt(1)) {
                    Cuenta retornar = new Cuenta();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
