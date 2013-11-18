/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author unasp
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
            System.out.println("Iniciando servidor");
            ServerSocket serverSocket = new ServerSocket(9090);          
            while(true) {
            Socket cliente = serverSocket.accept();
            Atendente a = new Atendente(cliente);
            a.start();
            }
            
    }
    
    
}
