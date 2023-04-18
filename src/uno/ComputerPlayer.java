
package uno;

import java.util.List;

public class ComputerPlayer implements UnoInterface {

    public int play(List<Card> cardsInHand, Card cardOnTop, Color color, GameState state) {

        int i = 0;

        //Returns card for Wild calledColors
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardOnTop.getColor ( ) == Color.NONE )
            {
                if ( cardsInHand.get ( i ).getColor ( ) == color && cardsInHand.get ( i ).getValue ( ) > 5 )
                {
                    return i;
                }
                if ( cardsInHand.get ( i ).getColor ( ) == color && cardsInHand.get ( i ).getValue ( ) <= 5 )
                {
                    return i;
                }
            }
        }
        //Returns Reverse, Skip, or Draw Two
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardsInHand.get ( i ).getType ( ) == cardOnTop.getType ( ) && cardOnTop.getType ( ) != Type.VALUE &&
                 cardOnTop.getColor ( ) != Color.NONE )
            {
                return i;
            }
        }
        //Returns higher number than upCard.getNumber ( )
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardsInHand.get ( i ).getColor ( ) == cardOnTop.getColor ( ) && cardsInHand.get ( i ).getValue ( ) >
                 cardOnTop.getValue ( ) )
            {
                return i;
            }
        }
        //Returns same number than upCard.getNumber ( )
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardsInHand.get ( i ).getValue ( ) == cardOnTop.getValue ( ) && cardsInHand.get ( i ).getValue ( ) != -1 )
            {
                return i;
            }
        }
        //Returns same color as upCard.getColor ( )
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardsInHand.get ( i ).getColor ( ) == cardOnTop.getColor ( ) && cardsInHand.get ( i ).getValue ( ) > 5 )
            {
                return i;
            }
            if ( cardsInHand.get ( i ).getColor ( ) == cardOnTop.getColor ( ) && cardsInHand.get ( i ).getValue ( ) <= 5 )
            {
                return i;
            }
        }
        //Returns Wild
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardsInHand.get ( i ).getColor ( ) == Color.NONE )
            {
                return i;
            }
        }

        return -1;
    }


   
    public Color addColor(List<Card> cardsInHand) {

        int i = 0;
        int numColor [ ] = new int [ 4 ];
        int highestColor = 0;
        Color calledColor = Color.RED;

        //Counts number of reds
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardsInHand.get ( i ).getColor ( ) == Color.RED )
            {
                numColor [ 0 ]++;
            }
        }
        //Counts number of blues
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardsInHand.get ( i ).getColor ( ) == Color.BLUE )
            {
                numColor [ 1 ]++;
            }
        }
        //Counts number of greens
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardsInHand.get ( i ).getColor ( ) == Color.GREEN )
            {
                numColor [ 2 ]++;
            }
        }
        //Counts number of yellows
        for ( i = 0; i < cardsInHand.size ( ); i++ )
        {
            if ( cardsInHand.get ( i ).getColor ( ) == Color.YELLOW )
            {
                numColor [ 3 ]++;
            }
        }
        //Finds color with highest number of cards
        for ( i = 0; i < numColor.length; i++ )
        {
            if ( numColor [ i ] > highestColor )
            {
                highestColor = numColor [ i ];
            }
        }
        //Calls color with highest number of cards
        if ( highestColor == numColor [ 0 ] )
        {
            calledColor = Color.RED;
        }
        else if ( highestColor == numColor [ 1 ] )
        {
            calledColor = Color.BLUE;
        }
        else if ( highestColor == numColor [ 2 ] )
        {
            calledColor = Color.GREEN;
        }
        else if ( highestColor == numColor [ 3 ] )
        {
            calledColor = Color.YELLOW;
        }

        return calledColor;
    }
 
}