/* 
* UNO Card Class
* @author Nishu Rani
*/
package uno;

public class Card {

    public static final boolean PRINT = false;

    private UnoInterface.Color color;
    private UnoInterface.Type type;
    private int value;

   
    public Card(UnoInterface.Color color, UnoInterface.Type type) {
        this.color = color;
        this.type = type;
        this.value = -1;
    }

   
    public Card(UnoInterface.Color color, int number) {
        this.color = color;
        this.type = UnoInterface.Type.VALUE;
        this.value = number;
    }

    
    public Card(UnoInterface.Color color, UnoInterface.Type type, int value) {
        this.color = color;
        this.type = type;
        this.value = value;
    }

    public UnoInterface.Color getColor() {
        return color;
    }

    
    public UnoInterface.Type getType() {
        return type;
    }

    
    public int getValue() {
        return value;
    }
    
    public int forfeit() {
        if (type == UnoInterface.Type.SKIP || type == UnoInterface.Type.REVERSE ||
            type == UnoInterface.Type.DRAW_TWO) {
            return 20;
        }
        if (type == UnoInterface.Type.WILD || type == UnoInterface.Type.WILD_D4) {
            return 50;
        }
        if (type == UnoInterface.Type.VALUE) {
            return value;
        }
        System.out.println("Illegal card!!");
        return -10000;
    }

    
    public boolean PlayOn(Card c, UnoInterface.Color col) {
        if (type == UnoInterface.Type.WILD ||
            type == UnoInterface.Type.WILD_D4 ||
            color == c.color ||
            color == col ||
            (type == c.type && type != UnoInterface.Type.VALUE) ||
            value == c.value && type == UnoInterface.Type.VALUE && c.type == UnoInterface.Type.VALUE)
        {
            return true;
        }
        return false;
    }

    
    public boolean followedByCall() {
        return type == UnoInterface.Type.WILD || type == UnoInterface.Type.WILD_D4;
    }

    
    void Card_Effect(Game game) throws DeckEmptyException {
        switch (type) {
            case SKIP:
                game.nextPlayerMove();
                game.nextPlayerMove();
                break;
            case REVERSE:
                game.reverseMove();
                game.nextPlayerMove();
                break;
            case DRAW_TWO:
                nextDraw(game);
                nextDraw(game);
                game.nextPlayerMove();
                game.nextPlayerMove();
                break;
            case WILD_D4:
                nextDraw(game);
                nextDraw(game);
                nextDraw(game);
                nextDraw(game);
                game.nextPlayerMove();
                game.nextPlayerMove();
                break;
            default:
                game.nextPlayerMove();
                break;
        }
    }

    private void nextDraw(Game game) throws DeckEmptyException {
        int nextPlayer = game.getNextPlayer();
        Card drawn;
        try {
            drawn = game.deck.draw();
        }
        catch (DeckEmptyException e) {
            game.print("...deck exhausted, remixing...");
            game.deck.Shuffle_Mix();
            drawn = game.deck.draw();
        }
        game.h[nextPlayer].addCard(drawn);
        //game.println("  Player #" + nextPlayer + " draws " + drawnCard + ".");
        game.println("  " + game.h[nextPlayer].getPlayerName() + " draws " +
            drawn + ".");
    }

  
    
    public boolean isTheSameCard(Card card) {
    	return (color == card.getColor() &&
    			type == card.getType() &&
    			value == card.getValue());
    }
    
    public String toString() {
        String val = "";
        if (PRINT) {
            switch (color) {
                case RED:
                    val += "\033[31m";
                    break;
                case YELLOW:
                    val += "\033[33m";
                    break;
                case GREEN:
                    val += "\033[32m";
                    break;
                case BLUE:
                    val += "\033[34m";
                    break;
                case NONE:
                    val += "\033[1m";
                    break;
            }
        }
        else {
            switch (color) {
                case RED:
                    val += "R";
                    break;
                case YELLOW:
                    val += "Y";
                    break;
                case GREEN:
                    val += "G";
                    break;
                case BLUE:
                    val += "B";
                    break;
                case NONE:
                    val += "";
                    break;
            }
        }
        switch (type) {
            case VALUE:
                val += value;
                break;
            case SKIP:
                val += "S";
                break;
            case REVERSE:
                val += "R";
                break;
            case WILD:
                val += "W";
                break;
            case DRAW_TWO:
                val += "+2";
                break;
            case WILD_D4:
                val += "W4";
                break;
        }
        if (PRINT) {
            val += "\033[37m\033[0m";
        }
        return val;
    }

}
