/* 
* Game Class
* @author Nishu Rani
*/
package uno;

import java.util.ArrayList;


public class Game {

    static final int INIT_HAND_SIZE = 7;

    public enum Direction { FORWARD, BACKWARD };

    //private GameState state;

   
    GroupOfCards deck;
    Hand h[];
    Card CardOnTop;
    Direction direction;
    int currentPlayer;
    UnoInterface.Color color;
    Scoreboard scoreBoard;
    UnoInterface.Color mostRecentColorCalled[];

    
    public Game(Scoreboard scoreboard, ArrayList<String> playerClassList) {
        this.scoreBoard = scoreboard;
        deck = new GroupOfCards();
        h = new Hand[scoreboard.getNumPlayers()];
        mostRecentColorCalled =
            new UnoInterface.Color[scoreboard.getNumPlayers()];
        try {
            for (int i=0; i<scoreboard.getNumPlayers(); i++) {
                h[i] = new Hand(playerClassList.get(i),
                    scoreboard.getPlayerList()[i]);
                for (int j=0; j<INIT_HAND_SIZE; j++) {
                    h[i].addCard(deck.draw());
                }
            }
            CardOnTop = deck.draw();
            while (CardOnTop.followedByCall()) {
                deck.discard(CardOnTop);
                CardOnTop = deck.draw();
            }
        }
        catch (Exception e) {
            System.out.println("Can't deal initial hands!");
            System.exit(1);
        }
        direction = Direction.FORWARD;
        currentPlayer =
            new java.util.Random().nextInt(scoreboard.getNumPlayers());
        color = UnoInterface.Color.NONE;
    }

    private void printState() {
        for (int i=0; i<scoreBoard.getNumPlayers(); i++) {
            System.out.println("Hand #" + i + ": " + h[i]);
        }
    }

   
    public int getNextPlayer() {
        if (direction == Direction.FORWARD) {
            return (currentPlayer + 1) % scoreBoard.getNumPlayers();
        }
        else {
            if (currentPlayer == 0) {
                return scoreBoard.getNumPlayers() - 1;
            }
            else {
                return currentPlayer - 1;
            }
        }
    }

    /**
     * Go ahead and advance to the next player.
     */
    void nextPlayerMove() {
        currentPlayer = getNextPlayer();
    }

    /**
     * Change the direction of the game from clockwise to counterclockwise
     * (or vice versa.)
     */
    void reverseMove() {
        if (direction == Direction.FORWARD) {
            direction = Direction.BACKWARD;
        }
        else {
            direction = Direction.FORWARD;
        }
    }

   
    public void Play() {
        println("Initial upcard is " + CardOnTop + ".");
        try {
            while (true) {
                //print("Hand #" + currPlayer + " (" + h[currPlayer] + ")");
                print(h[currentPlayer].getPlayerName() +
                    " (" + h[currentPlayer] + ")");
                Card playedCard = h[currentPlayer].play(this);
                if (playedCard == null) {
                    Card drawnCard;
                    try {
                        drawnCard = deck.draw();
                    }
                    catch (Exception e) {
                        print("...deck exhausted, remixing...");
                        deck.Shuffle_Mix();
                        drawnCard = deck.draw();
                    }
                    h[currentPlayer].addCard(drawnCard);
                    if (h[currentPlayer].isHuman())
                    	print(h[currentPlayer].getPlayerName());
                    print(" has to draw (" + drawnCard + ").");
                    playedCard = h[currentPlayer].play(this);
                }
                if (playedCard != null) {
                    if (h[currentPlayer].isHuman())
                    	print(h[currentPlayer].getPlayerName());
                    print(" plays " + playedCard + " on " + CardOnTop + ".");
                    deck.discard(CardOnTop);
                    CardOnTop = playedCard;
                    if (CardOnTop.followedByCall()) {
                        color = h[currentPlayer].addColor(this);
                        mostRecentColorCalled[currentPlayer] = color;
                        print(" (and calls " + color +
                            ").");
                    }
                    else {
                        color = UnoInterface.Color.NONE;
                    }
                }
                if (h[currentPlayer].isEmpty()) {
                    int roundPoints = 0;
                    for (int j=0; j<scoreBoard.getNumPlayers(); j++) {
                        roundPoints += h[j].countCards();
                    }
                    println("\n" + h[currentPlayer].getPlayerName() +
                        " wins! (and collects " + roundPoints + " points.)");
                    scoreBoard.addToScore(currentPlayer,roundPoints);
                    println("---------------\n" + scoreBoard);
                    return;
                }
                if (h[currentPlayer].size() == 1) {
                    print(" UNO!");
                }
                println("");
                if (playedCard != null) {
                    playedCard.Card_Effect(this);
                }
                else {
                    nextPlayerMove();
                }
            }
        }
        catch (DeckEmptyException e) {
            System.out.println("Deck exhausted! This game is a draw.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void print(String s) {
        if (StartUNO.DISPLAY) {
            System.out.print(s);
        }
    }

    void println(String s) {
        if (StartUNO.DISPLAY) {
            System.out.println(s);
        }
    }

    /**
     * Return the GameState object, through which the state of the game can
     * be accessed and safely manipulated.
     */
    public GameState getGameState() {

        return new GameState(this);
    }

    /**
     * Return the Card that is currently the "up card" in the game.
     */
    public Card getTopCard() {
        return CardOnTop;
    }
}
