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
        PersisteDadosPessoa per = new PersisteDadosPessoa();
        String msg = "";

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
                System.out.println("Dados = "+dadosStr);
                //           qtdBytesLidos = in.read(dadosBrutos);
                //         qtdBytesLidos-=1;
                //    }

                String[] textoSeparado = dadosStr.split(";");
                String comando = textoSeparado[0].toLowerCase();
                switch (comando) {
                    case "insertsetor":
                       msg = per.criaSetor(dadosStr);
                        break;
                    case "updatesetor":
                        msg = per.criaSetor(dadosStr);
                        break;
                    case "getsetor":
                        msg = per.criaSetor(dadosStr);
                        break;
                    case "deletesetor":
                        msg = per.criaSetor(dadosStr);
                        break;
                    case "listsetor":
                        msg = per.criaSetor(dadosStr);
                        break;
                    case "insertpessoa":
                        msg = per.criaPessoa(dadosStr);
                        break;
                    case "updatepessoa":
                        msg = per.criaPessoa(dadosStr);
                        break;
                    case "getpessoa":
                        msg = per.criaPessoa(dadosStr);
                        break;
                    case "deletepessoa":
                        msg = per.criaPessoa(dadosStr);
                        break;
                    case "listpessoa":
                        msg = per.criaPessoa(dadosStr);
                        break;
                    default:

                }
                OutputStream out = conn.getOutputStream();
                out.write(msg.getBytes());
                System.out.println("Saiu");
            }
        }

    }
}
