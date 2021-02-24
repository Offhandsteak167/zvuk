package main.com.zvuk.java.server;

import main.com.zvuk.java.shared.HandleCommands;
import main.com.zvuk.java.util.logger.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;


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
        Database.logger.addEvent(new Event("INFO","Server Listening......"));
        try {
            ss2 = new ServerSocket(4445); // can also use static final PORT_NUM , when defined

        } catch (IOException e) {
            Database.logger.addEvent(new Event("ERROR","Server Error"));
            Database.logger.addEvent(new Event("ERROR", Arrays.toString(e.getStackTrace())));
        }

        while (true) {
            try {
                assert ss2 != null;
                s = ss2.accept();
                Database.logger.addEvent(new Event("INFO","Connection Established"));
                ServerThread st = new ServerThread(s);
                st.start();

            } catch (Exception e) {
                Database.logger.addEvent(new Event("ERROR","Connection Error"));
                Database.logger.addEvent(new Event("ERROR", Arrays.toString(e.getStackTrace())));
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
            Database.logger.addEvent(new Event("ERROR", "IO error in main.com.zvuk.java.server thread"));
            Database.logger.addEvent(new Event("ERROR", Arrays.toString(e.getStackTrace())));
        }

        try {
            line = is.readLine();

            while (line.compareTo("QUIT") != 0) {
                handleInput();
            }
        } catch (IOException e) {

            line = this.getName(); //reused String line for getting thread name
            Database.logger.addEvent(new Event("WARN", "IO Error/ Client " + line + " terminated abruptly"));
        } catch (NullPointerException e) {
            line = this.getName(); //reused String line for getting thread name
            Database.logger.addEvent(new Event("WARN", "Client " + line + " Closed"));
        } catch (ClassNotFoundException e) {
            Database.logger.addEvent(new Event("ERROR", "ClassNotFoundException"));
            Database.logger.addEvent(new Event("ERROR", Arrays.toString(e.getStackTrace())));
        } finally {
            try {
                Database.logger.addEvent(new Event("INFO","Connection Closing.."));
                if (is != null) {
                    is.close();
                    Database.logger.addEvent(new Event("INFO","Socket Input Stream Closed"));
                }

                if (os != null) {
                    os.close();
                    Database.logger.addEvent(new Event("INFO","Socket Out Closed"));
                }
                if (s != null) {
                    s.close();
                    Database.logger.addEvent(new Event("INFO","Socket Closed"));
                }

            } catch (IOException ie) {
                Database.logger.addEvent(new Event("ERROR","Socket Error"));
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
            Database.logger.addEvent(new Event("INFO",("Response to Client  :  " + line)));

        }
        line = is.readLine();
    }
}