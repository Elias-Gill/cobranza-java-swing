package src.bankServer;

import src.bankServer.regsYcomprobs.Transferencia;

public class bankServer {

    public static void main(String[] args) throws Exception {
        BankServer b = new BankServer();
        System.out.println(b.IniciarSesion("buIKyNvMaS", 48271).toString());
        b.NuevaTransferencia(new Transferencia(182605794, 48271, 1613698564, 477198999));
        // deberia cerarse
        System.out.println("\n\n" + b.IniciarSesion("buIKyNvMaS", 48271).toString());
    }

}
