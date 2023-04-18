/* 
* GroupOfCardsTest Class
* @author Nishu Rani
*/
package uno;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hp
 */
public class GroupOfCardsTest {
    
    public GroupOfCardsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of shuffle method, of class GroupOfCards.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        GroupOfCards instance = new GroupOfCards();
        instance.shuffle();
        fail("The test failed.");
    }

    /**
     * Test of isEmpty method, of class GroupOfCards.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        GroupOfCards instance = new GroupOfCards();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of draw method, of class GroupOfCards.
     */
    @Test
    public void testDraw() throws Exception {
        System.out.println("draw");
        GroupOfCards instance = new GroupOfCards();
        Card expResult = instance.draw();
        Card result = instance.draw();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of discard method, of class GroupOfCards.
     */
    @Test
    public void testDiscard() {
        System.out.println("discard");
        Card c = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);;
        GroupOfCards instance = new GroupOfCards();
        instance.discard(c);
        fail("The test failed.");
    }

    /**
     * Test of Shuffle_Mix method, of class GroupOfCards.
     */
    @Test
    public void testShuffle_Mix() {
        System.out.println("Shuffle_Mix");
        GroupOfCards instance = new GroupOfCards();
        instance.Shuffle_Mix();
        fail("The test failed.");
    }

    /**
     * Test of getDiscardedCards method, of class GroupOfCards.
     */
    @Test
    public void testGetDiscardedCards() {
        System.out.println("getDiscardedCards");
        GroupOfCards instance = new GroupOfCards();
        ArrayList<Card> expResult = instance.getDiscardedCards();;
        ArrayList<Card> result = instance.getDiscardedCards();
        assertEquals(expResult, result);
        fail("The test failed.");
    }
    
}
