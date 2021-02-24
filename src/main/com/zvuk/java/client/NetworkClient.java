package main.com.zvuk.java.client;

import main.com.zvuk.java.shared.HandleCommands;
import main.com.zvuk.java.server.Command;
import main.com.zvuk.java.server.Packet;
import main.com.zvuk.java.util.queue.NodeQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class NetworkClient {

    private final NodeQueue<Command> commands;

    public NetworkClient(){
        commands = new NodeQueue<>();
    }

    public void addToCommands(Command c) {
        commands.enqueue(c);
    }

    public void loop() throws IOException{


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

    private void communicate(Socket s1, BufferedReader br, BufferedReader is, PrintWriter os) {
        String line;
        String response;
        try (s1; br; is; os) {
            if (commands.size() != 0) {
                createPacketAndReadResponse(is, os);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Socket read Error");
        } finally {

            System.out.println("Connection Closed");

        }
    }

    private void createPacketAndReadResponse(BufferedReader is, PrintWriter os) throws IOException, ClassNotFoundException {
        String line;
        String response;
        Packet p = new Packet(commands.dequeue());
        line = Packet.toString(p);
        os.println(line);
        os.flush();
        response = is.readLine();
        if (!response.equals(".")) {
            Packet np = (Packet) Packet.fromString(response);
            HandleCommands.handleCommand(np);
            System.out.println("Server Response : " + response);
        }
    }
}