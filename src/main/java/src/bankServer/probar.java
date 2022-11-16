package src.bankServer;

import java.sql.SQLException;

import src.bankServer.regsYcomprobs.Transferencia;

public class probar {

    public static void main(String[] args) throws Exception {
        BankServer b = new BankServer();
        System.out.println(b.IniciarSesion("buIKyNvMaS", 48271).toString());
        b.NuevaTransferencia(new Transferencia(48271, 182605794, 123, 477198999));
        // deberia cerarse
        System.out.println(b.IniciarSesion("buIKyNvMaS", 48271).toString());
    }

}
