package main.client;

// A simple Client Server Protocol .. Client for Echo Server

import main.shared.HandleCommands;
import main.server.Command;
import main.server.Packet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class NetworkClient {

    private static Command currentCommand = null;

    public static void setCurrentCommand(Command c) {
        currentCommand = c;
    }

    public static void main(String args[]) throws IOException{


        InetAddress address=InetAddress.getLocalHost();
        Socket s1=null;
        String line=null;
        BufferedReader br=null;
        BufferedReader is=null;
        PrintWriter os=null;

        try {
            s1=new Socket(address, 4445); // You can use static final constant PORT_NUM
            br= new BufferedReader(new InputStreamReader(System.in));
            is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
            os= new PrintWriter(s1.getOutputStream());
        }
        catch (IOException e){
            e.printStackTrace();
            System.err.print("IO Exception");
        }

        System.out.println("Client Address : "+address);
        System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

        String response=null;
        communicate(s1, br, is, os);

    }

    private static void communicate(Socket s1, BufferedReader br, BufferedReader is, PrintWriter os) throws IOException {
        String line;
        String response;
        try {
            if ( currentCommand != null){
                Packet p = new Packet(currentCommand);
                currentCommand = null;
                line = Packet.toString(p);
            } else {
                line = ".";
            }
            while(line.compareTo("QUIT")!=0){
                os.println(line);
                os.flush();
                response= is.readLine();
                Packet p = (Packet) Packet.fromString(response);
                currentCommand = HandleCommands.handleCommand(p);
                System.out.println("Server Response : "+response);
                line= br.readLine();

            }



        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Socket read Error");
        }
        finally{

            is.close();
            os.close();
            br.close();
            s1.close();
            System.out.println("Connection Closed");

        }
    }
}