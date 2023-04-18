/* 
* HandTest Class
* @author Nishu Rani
*/
package uno;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static uno.GameTest.pList;
import static uno.GameTest.scoreboard;

/**
 *
 * @author hp
 */
public class HandTest {
    
    public HandTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of addCard method, of class Hand.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card c = new Card(UnoInterface.Color.GREEN, UnoInterface.Type.VALUE, 5);;
        Hand instance = new Hand("uno.human_UnoPlayer","Ami");
        instance.addCard(c);
        fail("The test failed.");
    }

    /**
     * Test of size method, of class Hand.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Hand instance = new Hand("uno.human_UnoPlayer","Ami");
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of isHuman method, of class Hand.
     */
    @Test
    public void testIsHuman() {
        System.out.println("isHuman");
        Hand instance = new Hand("uno.human_UnoPlayer","Ami");
        boolean expResult = true;
        boolean result = instance.isHuman();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of play method, of class Hand.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Game game = new Game(scoreboard,pList);
        Hand instance = new Hand("uno.human_UnoPlayer","Ami");
        Card expResult = null;
        Card result = instance.play(game);
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of addColor method, of class Hand.
     */
    @Test
    public void testAddColor() {
        System.out.println("addColor");
        Game game = new Game(scoreboard,pList);
        Hand instance = new Hand("uno.human_UnoPlayer","Ami");
        UnoInterface.Color expResult = UnoInterface.Color.GREEN;
        UnoInterface.Color result = instance.addColor(game);
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of isEmpty method, of class Hand.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Hand instance = new Hand("uno.human_UnoPlayer","Ami");
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of toString method, of class Hand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Hand instance = new Hand("uno.human_UnoPlayer","Ami");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of countCards method, of class Hand.
     */
    @Test
    public void testCountCards() {
        System.out.println("countCards");
        Hand instance = new Hand("uno.human_UnoPlayer","Ami");
        int expResult = 0;
        int result = instance.countCards();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of getPlayerName method, of class Hand.
     */
    @Test
    public void testGetPlayerName() {
        System.out.println("getPlayerName");
        Hand instance = new Hand("uno.human_UnoPlayer","Ami");
        String expResult = "Ami";
        String result = instance.getPlayerName();
        assertEquals(expResult, result);
        fail("The test failed.");
    }
    
}
