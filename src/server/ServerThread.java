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
 * @author Schueler
 */
public class ServerThread extends Thread {
    Socket socket;
    
    ServerThread(Socket socket){
        this.socket = socket;
    }
   public void run(){
       try {
           String m = null;
           PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           System.out.println("Der Benutzer: " + bufferedReader.readLine() + "ist jetzt mit dem Server verbunden");
           while ((m = bufferedReader.readLine()) != null) {
               System.out.println("Der Client schickt jetzt einen Nachricht: " + m);
               printWriter.println("Der Server hallt den Nachricht wider: " + m);
           }
           socket.close();
       }
       catch (IOException e){
           System.out.println(e);
       }
   }
           
 }

