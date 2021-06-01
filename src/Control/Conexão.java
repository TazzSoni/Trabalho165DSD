/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rodrigo
 */
public class Conexão {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        while (true) {
            System.out.println("Aguardando conexão...");

            try (Socket conn = server.accept()) {

                System.out.println("Conectado com: "
                        + conn.getInetAddress().getHostAddress());

                InputStream in = conn.getInputStream();

                byte[] dadosBrutos = new byte[1024];
                int qtdBytesLidos = in.read(dadosBrutos);
             //   while (qtdBytesLidos >= 0) { //enquanto bytes forem lidos...
                    String dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
                    System.out.println(dadosStr);
         //           qtdBytesLidos = in.read(dadosBrutos);
           //         qtdBytesLidos-=1;
            //    }

                OutputStream out = conn.getOutputStream();
                String msg = "Tá chofento aí??? Aqui tá";
                out.write(msg.getBytes());
            }
        }

    }
}
