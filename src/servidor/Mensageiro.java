/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author plucena
 */
public class Mensageiro extends Thread {
    
    Socket socket;
    PrintWriter out;
    BufferedReader in;
   
    
    public void run(){

        try {
          socket = new Socket("localhost", 9090);
          out = new PrintWriter(socket.getOutputStream(), true);
          out.write("Inciando conexao");
          in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    
        }
        catch(Exception e) {
         e.printStackTrace();
        }    
    }
    
    public String enviar(String mensagem) {
        try {
         out.write(mensagem);
         return in.readLine();
        }
        catch (Exception e) {
           return " erro na mensagem " + mensagem + " - " + e;
        }
    }
    
}
