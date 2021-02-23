package main.com.zvuk.java.server;

import main.com.zvuk.java.shared.HandleCommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Represents a main.com.zvuk.java.server
 *
 * @author Jake D
 */
public class EchoServer extends Thread {

    /**
     * runs/starts the main.com.zvuk.java.server
     */
    public void run() {
        Socket s;
        ServerSocket ss2 = null;
        System.out.println("Server Listening......");
        try {
            ss2 = new ServerSocket(4445); // can also use static final PORT_NUM , when defined

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server error");

        }

        while (true) {
            try {
                assert ss2 != null;
                s = ss2.accept();
                System.out.println("connection Established");
                ServerThread st = new ServerThread(s);
                st.start();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Connection Error");

            }
        }

    }

}

/**
 * Thread for the main.com.zvuk.java.server
 */
class ServerThread extends Thread {

    String line = null;
    BufferedReader is = null;
    PrintWriter os = null;
    Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            createInputAndOutput();

        } catch (IOException e) {
            System.out.println("IO error in main.com.zvuk.java.server thread");
        }

        try {
            line = is.readLine();

            while (line.compareTo("QUIT") != 0) {
                handleInput();
            }
        } catch (IOException e) {

            line = this.getName(); //reused String line for getting thread name
            System.out.println("IO Error/ Client " + line + " terminated abruptly");
        } catch (NullPointerException e) {
            line = this.getName(); //reused String line for getting thread name
            System.out.println("Client " + line + " Closed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("Connection Closing..");
                if (is != null) {
                    is.close();
                    System.out.println(" Socket Input Stream Closed");
                }

                if (os != null) {
                    os.close();
                    System.out.println("Socket Out Closed");
                }
                if (s != null) {
                    s.close();
                    System.out.println("Socket Closed");
                }

            } catch (IOException ie) {
                System.out.println("Socket Close Error");
            }
        }//end finally
    }

    private void createInputAndOutput() throws IOException {
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        os = new PrintWriter(s.getOutputStream());
    }

    private void handleInput() throws IOException, ClassNotFoundException {
        os.println(line);
        os.flush();
        if (!line.equals(".")) {
            Packet p = (Packet) Packet.fromString(line);
            Packet response = new Packet(HandleCommands.handleCommand(p));
            System.out.println("Response to Client  :  " + line);
        }
        line = is.readLine();
    }
}