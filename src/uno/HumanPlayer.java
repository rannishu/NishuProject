package uno;

import java.util.List;

import java.util.Scanner;

public class HumanPlayer implements UnoInterface {

    public int play(List<Card> hand, Card upCard, Color calledColor,
        GameState state) {
    	
    	Scanner keyboard = new Scanner(System.in);
		int j = -1;
		
    	do {
        	System.out.print("\nEnter the card you'd like to play (or \"draw\" to draw a card) : ");
        	
        	String cardName = keyboard.nextLine();
        	if (cardName.equalsIgnoreCase("draw"))
        		return -1;
        	
        	Card card = cardName2Card(cardName);

    		for (int i=0; i<hand.size(); i++) {
    			if (hand.get(i).isTheSameCard(card))
    				j = i;
    		}
    		if (j==-1) {
    			System.out.println("This card does not appear in your hand!");
    		}
    		else if (canPlayOn(hand.get(j), upCard, calledColor)) {
        		return j;
        	}
        	else {
        		System.out.println("This card is not valid!");
        		j = -1;
        	}
    	} while (j == -1);
    				
        return -1;
    }

    public Color addColor(List<Card> hand) {
    	Scanner keyboard = new Scanner(System.in);

    	do {
    		System.out.print("Choose the color (R Y G B) : ");
    		String color = keyboard.nextLine();
    		
    		switch (color.charAt(0)) {
    		case 'R':
    			return UnoInterface.Color.RED;
    		case 'Y':
    			return UnoInterface.Color.YELLOW;
    		case 'G':
    			return UnoInterface.Color.GREEN;
    		case 'B':
    			return UnoInterface.Color.BLUE;
    		default:
    			System.out.println("Invalid color!");
    		}
    	} while (true);
    	
    }
    
    public Card cardName2Card(String cardName) {
    	UnoInterface.Color color = UnoInterface.Color.NONE;
    	UnoInterface.Type type = UnoInterface.Type.VALUE;
    	int	number = -1;
    	
    	char ch = cardName.charAt(0);
    	switch (ch) {
    		case 'R' :
    			color = UnoInterface.Color.RED;
    			break;
    		case 'Y' :
    			color = UnoInterface.Color.YELLOW;
    			break;
    		case 'G' :
    			color = UnoInterface.Color.GREEN;
    			break;
    		case 'B' :
    			color = UnoInterface.Color.BLUE;
    			break;
    		case 'W' :
    			color = UnoInterface.Color.NONE;
    			number = -1;
    			if (cardName.length() == 2)
    				type = UnoInterface.Type.WILD_D4;
    			else
    				type = UnoInterface.Type.WILD;
    			break;
    	}
    	if (color != UnoInterface.Color.NONE) {
    		ch = cardName.charAt(1);
    		if (Character.isDigit(ch)) {
    			type = UnoInterface.Type.VALUE;
    			number = ch - '0';
    		}
    		else if (ch == 'R') {
    			type = UnoInterface.Type.REVERSE;
    			number = -1;
    		}
    		else if (ch == 'S') {
    			type = UnoInterface.Type.SKIP;
    			number = -1;
    		}
    		else if (ch == '+' && cardName.charAt(2) == '2') {
    			type = UnoInterface.Type.DRAW_TWO;
    			number = -1;
    		}
    	}
    	
    	return ((number == -1) ? new Card(color, type) : new Card(color, number));
    }
    
    public boolean canPlayOn(Card card, Card upCard, Color calledColor) {

        if (card.getType() == Type.WILD ||
            card.getType() == Type.WILD_D4 ||
            card.getColor() == upCard.getColor() ||
            card.getColor() == calledColor ||
            (card.getType() == upCard.getType() &&
                card.getType() != Type.VALUE) ||
            card.getValue() == upCard.getValue() &&
                card.getType() == Type.VALUE &&
                upCard.getType() == Type.VALUE) {
            return true;
        }
        return false;
    }

}
