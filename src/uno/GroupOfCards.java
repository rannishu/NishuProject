
package uno;
import java.util.ArrayList;
import java.util.Random;


public class GroupOfCards {

    
    public static final int DUPLICATE_REGULAR_CARDS = 2;

    public static final int DUPLICATE_ZERO_CARDS = 1;

    public static final int DUPLICATE_SPECIAL_CARDS = 2;

    public static final int WILD_CARDS = 4;

    public static final int WILD_D4_CARDS = 4;

    public static final int SHUFFLE = 1;

    private ArrayList<Card> cardsList = new ArrayList<Card>();
    private ArrayList<Card> discardedCards = new ArrayList<Card>();
    private Random rand;

    /**
     * Constructor for a new, full, shuffled Deck.
     */
    public GroupOfCards() {
        rand = new Random();
        fillDeck();
        shuffle();
    }

    private void fillDeck() {
        for (int i=1; i<=9; i++) {
            for (int j=0; j<DUPLICATE_REGULAR_CARDS; j++) {
                cardsList.add(new Card(UnoInterface.Color.RED,i));
                cardsList.add(new Card(UnoInterface.Color.YELLOW,i));
                cardsList.add(new Card(UnoInterface.Color.BLUE,i));
                cardsList.add(new Card(UnoInterface.Color.GREEN,i));
            }
        }
        
        for (int j=0; j<DUPLICATE_ZERO_CARDS; j++) {
            cardsList.add(new Card(UnoInterface.Color.RED,0));
            cardsList.add(new Card(UnoInterface.Color.YELLOW,0));
            cardsList.add(new Card(UnoInterface.Color.BLUE,0));
            cardsList.add(new Card(UnoInterface.Color.GREEN,0));
        }
        for (int j=0; j<DUPLICATE_SPECIAL_CARDS; j++) {
            cardsList.add(new Card(UnoInterface.Color.RED,UnoInterface.Type.SKIP));
            cardsList.add(new Card(UnoInterface.Color.YELLOW,UnoInterface.Type.SKIP));
            cardsList.add(new Card(UnoInterface.Color.GREEN,UnoInterface.Type.SKIP));
            cardsList.add(new Card(UnoInterface.Color.BLUE,UnoInterface.Type.SKIP));
            cardsList.add(new Card(UnoInterface.Color.RED,UnoInterface.Type.REVERSE));
            cardsList.add(new Card(UnoInterface.Color.YELLOW,UnoInterface.Type.REVERSE));
            cardsList.add(new Card(UnoInterface.Color.GREEN,UnoInterface.Type.REVERSE));
            cardsList.add(new Card(UnoInterface.Color.BLUE,UnoInterface.Type.REVERSE));
            cardsList.add(new Card(UnoInterface.Color.RED,UnoInterface.Type.DRAW_TWO));
            cardsList.add(new Card(UnoInterface.Color.YELLOW,UnoInterface.Type.DRAW_TWO));
            cardsList.add(new Card(UnoInterface.Color.GREEN,UnoInterface.Type.DRAW_TWO));
            cardsList.add(new Card(UnoInterface.Color.BLUE,UnoInterface.Type.DRAW_TWO));
        }
        for (int i=0; i<WILD_CARDS; i++) {
            cardsList.add(new Card(UnoInterface.Color.NONE,UnoInterface.Type.WILD));
        }
        for (int i=0; i<WILD_D4_CARDS; i++) {
            cardsList.add(new Card(UnoInterface.Color.NONE,UnoInterface.Type.WILD_D4));
        }
    }

    public void shuffle() {
        for (int i=0; i<SHUFFLE * cardsList.size(); i++) {
            int x = rand.nextInt(cardsList.size());
            int y = rand.nextInt(cardsList.size());
            Card temp = cardsList.get(x);
            cardsList.set(x,cardsList.get(y));
            cardsList.set(y,temp);
        }
    }

    
    public boolean isEmpty() {
        return cardsList.size() == 0;
    }

    public Card draw() throws DeckEmptyException {
        if (cardsList.size() == 0) {
            throw new DeckEmptyException();
        }
        return cardsList.remove(0);
    }

    
    public void discard(Card c) { 
        discardedCards.add(c);
    }

    public void Shuffle_Mix() {
        cardsList.addAll(discardedCards);
        discardedCards.clear();
        shuffle();
    }

    ArrayList<Card> getDiscardedCards() {
        return discardedCards;
    }

}
