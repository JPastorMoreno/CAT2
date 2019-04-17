/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dcc
 */
public class NewClass extends Thread {
        Socket connection;
        DataOutputStream output;
        DataInputStream  input;
        Mess mens=new Mess();
        public NewClass(Socket connection, Mess mens)
        {
            this.connection=connection;
            this.mens=mens;
            start();
        }
    public void run()
    {
            try {
                mens.More();
                System.out.println("Connection no. "+mens.getNum()+" from: "+
                        connection.getInetAddress().getHostName());
                //Open input-output channels
                input = new DataInputStream(connection.getInputStream());  
                output  = new DataOutputStream(connection.getOutputStream());
                
                //Read message from the client
                String mensaje = input.readUTF();    
                System.out.println("Connection no. "+mens.getNum()+". Message: "+mensaje);
                
                //Answer
                output.writeUTF("GENERAL KENOBI"+ "!"); 
                
                //Close connection
                connection.close();       
            } catch (IOException ex) {
                Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
