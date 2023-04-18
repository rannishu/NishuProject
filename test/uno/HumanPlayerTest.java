/* 
* HumanPlayerTest Class
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
public class HumanPlayerTest {
    static List<Card> hand;
    
    public HumanPlayerTest() {
        Card c = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        hand.add(c);
        c = new Card(UnoInterface.Color.BLUE, UnoInterface.Type.VALUE, 7);
        hand.add(c);
        c = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.DRAW_TWO);
        hand.add(c);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of play method, of class HumanPlayer.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Card upCard = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        UnoInterface.Color calledColor = UnoInterface.Color.GREEN;
        GameState state = null;
        HumanPlayer instance = new HumanPlayer();
        int expResult = 0;
        int result = instance.play(hand, upCard, calledColor, state);
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of addColor method, of class HumanPlayer.
     */
    @Test
    public void testAddColor() {
        System.out.println("addColor");
        HumanPlayer instance = new HumanPlayer();
        UnoInterface.Color expResult = UnoInterface.Color.GREEN;
        UnoInterface.Color result = instance.addColor(hand);
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of cardName2Card method, of class HumanPlayer.
     */
    @Test
    public void testCardName2Card() {
        System.out.println("cardName2Card");
        String cardName = "";
        HumanPlayer instance = new HumanPlayer();
        Card expResult = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        Card result = instance.cardName2Card(cardName);
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of canPlayOn method, of class HumanPlayer.
     */
    @Test
    public void testCanPlayOn() {
        System.out.println("canPlayOn");
        Card card = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);
        Card upCard = new Card(UnoInterface.Color.BLUE, UnoInterface.Type.VALUE, 5);
        UnoInterface.Color calledColor = UnoInterface.Color.RED;
        HumanPlayer instance = new HumanPlayer();
        boolean expResult = false;
        boolean result = instance.canPlayOn(card, upCard, calledColor);
        assertEquals(expResult, result);
        fail("The test failed.");
    }
    
}
