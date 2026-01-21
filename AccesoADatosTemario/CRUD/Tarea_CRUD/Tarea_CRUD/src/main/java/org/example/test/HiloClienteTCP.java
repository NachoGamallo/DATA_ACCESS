/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author igngamlaf
 */
public class HiloClienteTCP implements Runnable{
    
    private Socket socket;
    
    public HiloClienteTCP(Socket socket){
    
        this.socket = socket;
        
    }
    
    @Override
    public void run() {
        
        try{
        
            BufferedReader entry = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
            
            PrintWriter exit = new PrintWriter(socket.getOutputStream(),true);
            
            String line;
            
            while ((line = entry.readLine()) != null){
            
                switch(line.toUpperCase()){
                
                    case "HOLA": exit.append(LocalTime.now());
                    case "FECHA": exit(LocalDate.now()) ;
                    case "SALIR": {
                        
                        exit.println("Desconectando...");
                        System.out.println("Desconectando cliente " + Thread.currentThread().getName());
                        return;
                        
                    }
                    default: System.out.println("Comando no reconocido.");
                    
                }
                
            }
        }catch(IOException e){e.getMessage();}
    
    }
    
    
    
}
