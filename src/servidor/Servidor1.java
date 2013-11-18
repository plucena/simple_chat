/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author unasp
 */
public class Servidor1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
            System.out.println("Iniciando servidor 2" + new Date());
            ServerSocket serverSocket = new ServerSocket(8080);          
            while(true) {
            Socket cliente = serverSocket.accept();            
            BufferedReader in;
            in= new BufferedReader(new InputStreamReader(cliente.getInputStream()));       
            String entrada =  in.readLine();            
            entrada = "/home/unasp/www/" + entrada.substring(5, entrada.length()-9);
            System.out.println("Cliente quer " + entrada);            
            BufferedReader br = new BufferedReader(new FileReader(entrada));
            String arquivo="", linha ="";
            while ((linha = br.readLine()) != null) 
		arquivo = arquivo+linha;
            System.out.println(arquivo.length()+1);
            PrintWriter out =  new PrintWriter(cliente.getOutputStream(), true);
            //out.write("HTTP/1.0 200 OK\r\n");            
            //out.write("Server: UNASP SERVERe/0.8.4\r\n");
            //out.write("Content-Type: text/html\r\n");
            //out.write("Content-Length: " + arquivo.length()+1 + "\r\n");            
            //out.write("\r\n");
            out.write("Ola");
            in.close(); 
            out.close();
            }
            
            
    }
    
    
    
    
}
