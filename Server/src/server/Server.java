/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Schueler
 */
public class Server {
 public static final int PORT = 119;
 public static final int PORT1 = 134;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Server().runServer();
        
    }
    public void runServer() throws IOException{
        ServerSocket serverSocket = new ServerSocket(PORT);
        ServerSocket serverSocket1 = new ServerSocket(PORT1);
        System.out.println("Der Server ist eingeschaltet und bereit für Verbindungen...");
     while(true){
        Socket socket = serverSocket.accept();
        new ServerThread(socket).start(); 
        Socket socket1 = serverSocket1.accept();
        new ServerThread(socket1).start();
     }
    }
    
}
