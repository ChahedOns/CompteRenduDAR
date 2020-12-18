import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        System.out.println("connection request");

        try ( //Create a client socket
                Socket socket = new Socket("127.0.0.1", port)) {
            System.out.println("Connection established");
            PrintWriter outClient;
            try ( // create in / out
                    BufferedReader inClient = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                outClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                int x ;
                Scanner clavier = new Scanner(System.in);
                System.out.print("Saisir un nombre : ");
                x = clavier.nextInt();
                outClient.println(x);
                //close in / out
            }
            outClient.close();
            // close client socket
        }
    }
}



