import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        int x = Integer.parseInt(inServer.readLine());
        int y=2 ;  
            while (y <= x)
            {
               int i=2; 
               boolean ok=true;
                    while ( (ok == true) && (i < (y / 2)))
                    {
                        if ( y % i == 0)
                            ok=false ; 
                        else 
                            i=i+2;
                    }
                      if (ok == false)
                          System.out.println(y);
                      else 
                          y=y+1; 
            
            }

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}