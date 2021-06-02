/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Rodrigo
 */
public class CriaConexao {
    
     public void criaConexao(String dados) throws IOException {

        try (Socket conn = new Socket("127.0.0.1", 80);) {

            OutputStream out = conn.getOutputStream();
            out.write(dados.getBytes());

            InputStream in = conn.getInputStream();

            byte[] dadosBrutos = new byte[1024];
            int qtdBytesLidos = in.read(dadosBrutos);
          while (qtdBytesLidos >= 0) { //enquanto bytes forem lidos...
                String dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
                System.out.println(dadosStr);
                qtdBytesLidos = in.read(dadosBrutos);
            }

        } catch (UnknownHostException e) {
            System.out.println("Host não encontrado");
            e.printStackTrace();
        }
    }
    
}
