package main.server;

import java.io.*;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Packet implements Serializable {
    private int len;
    private InetAddress address = null;
    private int port;
    private String buf;

    public Packet(Object o, int port, InetAddress address) throws IOException {
        buf = toString((Serializable) o);
        len = buf.length();
        this.port = port;
        this.address = address;

    }
    public Packet(Object o) throws IOException {
        buf = toString((Serializable) o);
        len = buf.length();
        this.port = 0;
        this.address = null;

    }

    /** Read the object from Base64 string. */
    public static Object fromString( String s ) throws IOException,
            ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }

    /** Write the object to a Base64 string. */
    public static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    void encode(Object data) throws IOException {
        buf = toString((Serializable) data);
    }

    public Object decode() throws IOException, ClassNotFoundException {
        return fromString(buf);
    }

}
