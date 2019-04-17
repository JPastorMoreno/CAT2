package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
public class IPAddresses {
    public static void main(String[] args) {
        byte[] localHost = {127, 0, 0, 1}; //IP - localhost
        //{172, 22, 6, 231};
        InetAddress computer;
        try {
            // Static methods from InetAddress
            // Create InetAddress object
            computer = InetAddress.getLocalHost();  
            System.out.println("My computer is: "+computer);
            System.out.println("IP address: "+computer.getHostAddress());
            System.out.println("Name: "+computer.getHostName());
            System.out.println("Canonical Name: "+computer.getCanonicalHostName());
            System.out.println();

            // Obtain computer info from its name
            computer = InetAddress.getByName("www.google.com");
            System.out.println("www.google.com computer is: "+computer);
            System.out.println("IP address: "+computer.getHostAddress());
            System.out.println("Name: "+computer.getHostName());
            System.out.println("Canonical Name: "+computer.getCanonicalHostName());
            System.out.println();

            // Obtain computer info from its IP address
            computer = InetAddress.getByAddress(localHost);
            System.out.println("My computer is: "+computer);
            System.out.println("IP address: "+computer.getHostAddress());
            System.out.println();

            // Obtain all IP addresses of a computer
            InetAddress[] ids;
            computer = InetAddress.getLocalHost();
            ids = InetAddress.getAllByName(computer.getHostName());
            for (int i=0; i<ids.length; i++) System.out.println("Id "+i+": "+ids[i]);
            System.out.println();

        } catch (UnknownHostException e) {
            System.out.println("Connection Error");
            System.out.println(e.toString());
        }
    }
}
