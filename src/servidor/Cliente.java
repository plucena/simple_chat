/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;

import java.applet.Applet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Applet{

    Button enviar;
    TextField mensagem;
    TextArea chat;
    Mensageiro messanger = new Mensageiro(); 
    
    public void init() {        
     try {     
          setLayout(null);
          mensagem = new TextField("", 100);
          enviar = new Button("Enviar");
          chat = new TextArea(20, 80);
          mensagem.setBounds(20,20, 300,40);
          enviar.setBounds(20,70,300,40);
          chat.setBounds(20,120,600,200);
          add(mensagem); add(enviar); add(chat);
          messanger.start();
    
     }
     catch(Exception e) {};
    }
    
    public boolean action(Event e, Object o) 
    { 
         if(e.target instanceof Button)  {
             try {
                 chat.append("\nEu disse - " + mensagem.getText());
                 String resposta= messanger.enviar(mensagem.getText());
                 mensagem.setText("");
                 chat.append("\nServidor disse " + resposta);
             } catch (Exception ex) {
                ex.printStackTrace();
             }   
         } 
         return true;
    }    
    
}
