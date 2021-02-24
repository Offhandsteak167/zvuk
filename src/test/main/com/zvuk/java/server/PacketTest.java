package test.main.com.zvuk.java.server; 

import main.com.zvuk.java.server.Packet;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Packet Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 24, 2021</pre> 
* @version 1.0 
*/ 
public class PacketTest {
    Packet p;
    String test = "Test";
    String test_text = "rO0ABXQABFRlc3Q=";
@Before
public void before() throws Exception {
     p = new Packet(test);
} 

@After
public void after() throws Exception {
     p = new Packet(test);
} 

/** 
* 
* Method: fromString(String s) 
* 
*/ 
@Test
public void testFromString() throws Exception {
    assert(Packet.fromString(test_text).equals(test));
}

/** 
* 
* Method: toString(Serializable o) 
* 
*/ 
@Test
public void testToString() throws Exception {
    assert(Packet.toString(test).equals(test_text));
}

/** 
* 
* Method: decode() 
* 
*/ 
@Test
public void testDecode() throws Exception {
    assert(p.decode().equals(test));
}


} 
