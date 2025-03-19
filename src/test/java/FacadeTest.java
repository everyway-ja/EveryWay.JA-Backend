import org.junit.jupiter.api.Test;

import packet.services.Facade;

import static org.junit.jupiter.api.Assertions.assertEquals;

//DeFÆCAzione test
public class FacadeTest {

    private Facade facade = new Facade(); // or use dependency injection

    @Test
    void testCiaoMethod() {
        assertEquals("ciao", facade.ciao());
    }
}