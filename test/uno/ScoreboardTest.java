/* 
* ScoreboardTest Class
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
public class ScoreboardTest {
    static String playerList[];
    
    public ScoreboardTest() {
        playerList=new String[] { "Sam", "Joe", "Ani"};
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of addToScore method, of class Scoreboard.
     */
    @Test
    public void testAddToScore() {
        System.out.println("addToScore");
        int player = 0;
        int points = 10;
        Scoreboard instance = new Scoreboard(playerList);
        instance.addToScore(player, points);
        fail("Failed to add score.");
    }

    /**
     * Test of getScore method, of class Scoreboard.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        int player = 0;
        int points = 10;
        Scoreboard instance = new Scoreboard(playerList);
        instance.addToScore(player, points);
        int expResult = 10;
        int result = instance.getScore(player);
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of getPlayerList method, of class Scoreboard.
     */
    @Test
    public void testGetPlayerList() {
        System.out.println("getPlayerList");
        Scoreboard instance = new Scoreboard(playerList);
        String[] expResult = playerList;
        String[] result = instance.getPlayerList();
        assertArrayEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of getNumPlayers method, of class Scoreboard.
     */
    @Test
    public void testGetNumPlayers() {
        System.out.println("getNumPlayers");
        Scoreboard instance = new Scoreboard(playerList);
        int expResult = 3;
        int result = instance.getNumPlayers();
        assertEquals(expResult, result);
        fail("The test failed.");
    }

    /**
     * Test of getWinner method, of class Scoreboard.
     */
    @Test
    public void testGetWinner() {
        System.out.println("getWinner");
        Scoreboard instance = new Scoreboard(playerList);
        int expResult = 0;
        int result = instance.getWinner();
        assertEquals(expResult, result);
        fail("The test failed.");
    }
    
}
