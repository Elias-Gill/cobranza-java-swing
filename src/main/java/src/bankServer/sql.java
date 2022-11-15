/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bankServer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class sql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection cn = new Conexion().conectar();
            if (cn != null) {
                System.out.println("Conectado a la BD");
            } else {
                System.out.println("\nNO FUE POSIBLE CONECTAR\n\n");
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
