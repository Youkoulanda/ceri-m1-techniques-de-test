package TP1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestJunit {

    @Test
    public void testHello_de(){
        assertEquals("Hallo Welt !", Main.hello_de());
    }
}
