
package uno;

import java.util.ArrayList;

/**
 * <p>A Hand of Uno cards, held by a particular player. 
 */
public class Hand {

    private ArrayList<Card> cards;
    private UnoInterface player;
    private String playerName;
    private boolean isHuman = false;

    
    public Hand(String unoPlayerClassName, String playerName) {
        try {
            player = (UnoInterface)
                Class.forName(unoPlayerClassName).newInstance();
        }
        catch (Exception e) {
            System.out.println("Problem with " + unoPlayerClassName + ".");
            e.printStackTrace();
            System.exit(1);
        }
        if (unoPlayerClassName.equalsIgnoreCase("uno.human_UnoPlayer"))
        	isHuman = true;
        this.playerName = playerName;
        cards = new ArrayList<Card>();
    }

    /**
     * Add (draw) a card to the hand.
     */
    void addCard(Card c) {
        cards.add(c);
    }

    /**
     * Return the number of cards in the hand.
     */
    public int size() {
        return cards.size();
    }
    
    /**
     * Return this hand is a human.
     */
    public boolean isHuman() {
    	return isHuman;
    }
 

    Card play(Game game) {
        int playedCard;
        playedCard = player.play(cards, game.getTopCard(), game.color,
            game.getGameState());
        if (playedCard == -1) {
            return null;
        }
        else {
            Card toPlay = cards.remove(playedCard);
            return toPlay;
        }
    }

    
    UnoInterface.Color addColor(Game game) {
        return player.addColor(cards);
    }

   
    public boolean isEmpty() {
        return cards.size() == 0;
    }

    
    public String toString() {
        String val = "";
        for (int i=0; i<cards.size(); i++) {
            val += cards.get(i);
            if (i<cards.size()-1) {
                val += ",";
            }
        }
        return val;
    }

    /**
     * Return the total value of this Hand, as it now stands (in other
     * words, the sum of all the forfeit values of cards in hand.)
     */
    public int countCards() {
        int total = 0;
        for (int i=0; i<cards.size(); i++) {
            total += cards.get(i).forfeit();
        }
        return total;
    }

    /**
     * Return the name of the contestant.
     */
    public String getPlayerName() {
        return playerName;
    }
}
