
package uno;

import java.util.List;


public interface UnoInterface {
     public enum Color { RED, YELLOW, GREEN, BLUE, NONE }
    public enum Type { VALUE, SKIP, REVERSE, DRAW_TWO, WILD, WILD_D4 }

    
    public int play(List<Card> cardsInHand, Card cardOnTop, Color color,
        GameState state);

    public Color addColor(List<Card> cardsInHand);
}
