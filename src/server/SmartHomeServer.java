/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author user
 */
public class SmartHomeServer extends Thread{
    
    Socket socket;
    
    SmartHomeServer (Socket socket){
        this.socket = socket;
    }
   public void run(){
       try {
           String m1 = null;
           PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           System.out.println("Das Haus: " + bufferedReader.readLine() + "ist jetzt mit dem Server verbunden");
           while ((m1 = bufferedReader.readLine()) != null) {
               System.out.println("Das Haus schickt jetzt einen Nachricht: " + m1);
               printWriter.println("Der Server hallt den Nachricht wider: " + m1);
           }
           socket.close();
       }
       catch (IOException e){
           System.out.println(e);
       }
   }
    
    
}
