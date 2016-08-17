/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.videollamadacliente;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kvin2
 */
public class Cliente {
   
    
    
    
    public void enviar(String usuario){
        try {
            
            Socket soc = new Socket("localhost", 45000);
            PrintStream user= new PrintStream(soc.getOutputStream());
            user.println(usuario);
            
            
            
            BufferedReader ip= new BufferedReader(new InputStreamReader(soc.getInputStream()));
            
            if(!ip.readLine().equals("")){
                DatagramSocket udpsoc = new DatagramSocket(); 
                //crear el paquete
                String mensaje = "hola mundo";
                DatagramPacket pkt = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, InetAddress.getByName("10.1.3.169"), 45000);
                
                udpsoc.send(pkt);
            
            }else{
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
