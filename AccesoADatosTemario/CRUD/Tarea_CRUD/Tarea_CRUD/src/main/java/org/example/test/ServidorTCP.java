/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1301;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author igngamlaf
 */
public class ServidorTCP {
    
    private static ServerSocket ss = null;
    private static final int PORT = 5000;
    
    public static void main (String [] args) throws Exception {
    
        try {
        
            ss = new ServerSocket(PORT);
            System.out.println("Servidor iniciado en puerto: " + ss.getLocalPort());
            
            while (true){
            
                Socket client = ss.accept();
                System.out.println("Cliente conectado: " + client.getInetAddress());
            
                new Thread (new HiloClienteTCP(client)).start();
            }
            
        }catch(IOException e){ e.toString(); }
          
    }
   
}
