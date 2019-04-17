
package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Mess {
    int num=0;
    public Mess(){}
    public synchronized void More()
    {
        num++;
    }
    public int getNum()
    {
        return num;
    }
}
