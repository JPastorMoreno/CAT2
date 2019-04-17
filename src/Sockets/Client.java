package Sockets;

import java.io.*;
import java.net.*;
public class Client {
    public static void main(String args[]) {
        Socket client;
        DataInputStream  input;
        DataOutputStream output;
        String message, response;
        for(int i=0; i<5; i++)
        try {
            //Create socket to t"he server (local host) and port
            
            client = new Socket("192.168.1.41",5001); 
            
            
            //Create input/output channels
            
            input = new DataInputStream(client.getInputStream());  
            output = new DataOutputStream(client.getOutputStream());
            message="HELLO THERE "+i;
            output.writeUTF(message);      // Send message to server
            response = input.readUTF();                  // Read response
            System.out.println("My message: "+message);
            System.out.println("Sever response: "+response);
            client.close();                                // Close connection
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
