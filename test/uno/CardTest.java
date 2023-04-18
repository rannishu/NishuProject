/* 
* CardTest Class
* @author Nishu Rani
*/
package uno;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hp
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getColor method, of class Card.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Card instance = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        UnoInterface.Color expResult = UnoInterface.Color.GREEN;
        UnoInterface.Color result = instance.getColor();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of getType method, of class Card.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Card instance = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        UnoInterface.Type expResult = UnoInterface.Type.VALUE;
        UnoInterface.Type result = instance.getType();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Card instance = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        int expResult = 5;
        int result = instance.getValue();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of forfeit method, of class Card.
     */
    @Test
    public void testForfeit() {
        System.out.println("forfeit");
        Card instance = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        int expResult = 5;
        int result = instance.forfeit();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of PlayOn method, of class Card.
     */
    @Test
    public void testPlayOn() {
        System.out.println("PlayOn");
        Card instance = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        UnoInterface.Color col = UnoInterface.Color.RED;
        boolean expResult = false;
        boolean result = instance.PlayOn(instance, col);
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of followedByCall method, of class Card.
     */
    @Test
    public void testFollowedByCall() {
        System.out.println("followedByCall");
        Card instance = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.WILD);
        boolean expResult = true;
        boolean result = instance.followedByCall();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of isTheSameCard method, of class Card.
     */
    @Test
    public void testIsTheSameCard() {
        System.out.println("isTheSameCard");
        Card card = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        Card instance = new Card(UnoInterface.Color.BLUE, UnoInterface.Type.VALUE, 5);
        boolean expResult = false;
        boolean result = instance.isTheSameCard(card);
        assertEquals(expResult, result);
        fail("The test failed.");
    }
    
}
