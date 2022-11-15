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

        Conexion CC = new Conexion();
        Connection cn = CC.conectar();
        if (cn != null) {
            System.out.println("Conectado a la BD");
        }
    }
}
