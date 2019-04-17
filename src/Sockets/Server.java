package Sockets;

import java.io.*;
import java.net.*;
public class Server {
    public static void main(String args[]) {
        ServerSocket server;
        Socket connection;
        DataOutputStream output;
        DataInputStream  input;
        Mess mens=new Mess();
        try {
            server = new ServerSocket(5001); // Create socket Port 5000
            System.out.println("Starting server...");
            while (true) {
                // Wait for a connection
                connection = server.accept();     
                NewClass thread=new NewClass(connection, mens);                     
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
