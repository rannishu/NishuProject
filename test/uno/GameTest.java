/* 
* GameTest Class
* @author Nishu Rani
*/
package uno;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/* 
* GameTest Class
* @author Nishu Rani
*/
public class GameTest {
    static String playerList[];
    static ArrayList<String> pList;
    static Scoreboard scoreboard;
    
    public GameTest() {
        playerList=new String[] { "Sam", "Joe", "Ani"};
          
        pList=new ArrayList<>();
        pList.add("Sam");
        pList.add("Joe");
        pList.add("Ani");
        scoreboard = new Scoreboard(playerList);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getNextPlayer method, of class Game.
     */
    @Test
    public void testGetNextPlayer() {
        System.out.println("getNextPlayer");
        
        Game instance = new Game(scoreboard,pList);
        int expResult = 2;
        int result = instance.getNextPlayer();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of nextPlayerMove method, of class Game.
     */
    @Test
    public void testNextPlayerMove() {
        System.out.println("nextPlayerMove");
        Game instance = new Game(scoreboard,pList);
        instance.nextPlayerMove();
        fail("The test failed.");
    }

    /**
     * Test of reverseMove method, of class Game.
     */
    @Test
    public void testReverseMove() {
        System.out.println("reverseMove");
        Game instance = new Game(scoreboard,pList);
        instance.reverseMove();
        fail("The test failed.");
    }

    /**
     * Test of Play method, of class Game.
     */
    @Test
    public void testPlay() {
        System.out.println("Play");
        Game instance = new Game(scoreboard,pList);
        instance.Play();
        fail("The test failed.");
    }

    /**
     * Test of print method, of class Game.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        String s = "";
        Game instance = new Game(scoreboard,pList);
        instance.print(s);
        fail("The test failed.");
    }

    /**
     * Test of println method, of class Game.
     */
    @Test
    public void testPrintln() {
        System.out.println("println");
        String s = "";
        Game instance = new Game(scoreboard,pList);
        instance.println(s);
        fail("The test failed.");
    }

    /**
     * Test of getGameState method, of class Game.
     */
    @Test
    public void testGetGameState() {
        System.out.println("getGameState");
        Game instance = new Game(scoreboard,pList);
        GameState expResult = null;
        GameState result = instance.getGameState();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of getTopCard method, of class Game.
     */
    @Test
    public void testGetTopCard() {
        System.out.println("getTopCard");
        Game instance = new Game(scoreboard,pList);
        Card expResult = null;
        Card result = instance.getTopCard();
        assertEquals(expResult, result);
        fail("The test failed.");
    }
    
}
