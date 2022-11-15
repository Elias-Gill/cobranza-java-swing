package src;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import src.bankServer.data.Cuenta;

/**
 * @author elias
 */
public class Banco {
    public Cuenta iniciarSesion(String contrasena, int cedula) throws Exception {
        if (1 == Integer.parseInt("1")) {
            return new Cuenta();
        } else {
            throw new Exception("erro de iniciio de sesion");
        }
    }
}
