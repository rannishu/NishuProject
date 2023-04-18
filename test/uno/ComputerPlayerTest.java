/* 
* ComputerPlayerTest Class
* @author Nishu Rani
*/
package uno;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hp
 */
public class ComputerPlayerTest {
    static List<Card> cardsInHand;
    public ComputerPlayerTest() {
        Card c = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        cardsInHand.add(c);
        c = new Card(UnoInterface.Color.BLUE, UnoInterface.Type.VALUE, 7);
        cardsInHand.add(c);
        c = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.DRAW_TWO);
        cardsInHand.add(c);
     }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of play method, of class ComputerPlayer.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Card cardOnTop = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        UnoInterface.Color color = UnoInterface.Color.GREEN;
        GameState state = null;
        ComputerPlayer instance = new ComputerPlayer();
        int expResult = 2;
        int result = instance.play(cardsInHand, cardOnTop, color, state);
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of addColor method, of class ComputerPlayer.
     */
    @Test
    public void testAddColor() {
        System.out.println("addColor");
        ComputerPlayer instance = new ComputerPlayer();
        UnoInterface.Color expResult = UnoInterface.Color.GREEN;
        UnoInterface.Color result = instance.addColor(cardsInHand);
        assertEquals(expResult, result);
        fail("The test failed.");
    }
    
}
