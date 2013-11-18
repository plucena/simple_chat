/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author unasp
 */
public class Atendente extends Thread {
    
    Socket cliente = null;
    String mensagem;
    
    public Atendente(Socket conexao) {
        cliente = conexao;
    }
    
    public void run() {
        try {
            System.out.println("Nova Conexao de: " + cliente.getInetAddress());
            PrintWriter out =  new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader in;
            in= new BufferedReader(new InputStreamReader(cliente.getInputStream()));       
            out.println("Bem vindo ao server");
            mensagem =  in.readLine();
            out.println(mensagem + " disse o cliente");
            while(mensagem != null) {
                System.out.println( cliente.getInetAddress() + " Disse: " +mensagem);                
                out.println(mensagem + " pra vc tambem");
                System.out.println(mensagem + " pra vc tambem");
                mensagem =  in.readLine();
            }
            out.println("Adeus");
        }
        catch(Exception e){ e.printStackTrace();}
    }
}
