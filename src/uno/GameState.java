/* 
* GameState Class
* @author Nishu Rani
*/
package uno;

import java.util.List;

public class GameState {

    private Game theGame;
    private int[] numCardsInHandsOfNextPlayers;
    private UnoInterface.Color[] mostRecentColor;
    private int[] totalScoreofPlayers;

    
    GameState() {
        numCardsInHandsOfNextPlayers = new int[4];
        mostRecentColor = new UnoInterface.Color[4];
        totalScoreofPlayers = new int[4];
    }

    
    GameState(Game game) {

        numCardsInHandsOfNextPlayers =
            new int[game.scoreBoard.getNumPlayers()];
        mostRecentColor =
            new UnoInterface.Color[game.scoreBoard.getNumPlayers()];
        totalScoreofPlayers =
            new int[game.scoreBoard.getNumPlayers()];

        if (game.direction == Game.Direction.FORWARD) {
            for (int i=0; i<game.h.length; i++) {
                numCardsInHandsOfNextPlayers[i] =
                    game.h[(game.currentPlayer + i + 1) %
                        game.scoreBoard.getNumPlayers()].size();
                totalScoreofPlayers[i] =
                    game.scoreBoard.getScore((game.currentPlayer + i + 1) %
                        game.scoreBoard.getNumPlayers());
                mostRecentColor[i] =
                    game.mostRecentColorCalled[(game.currentPlayer + i + 1) %
                        game.scoreBoard.getNumPlayers()];
            }
        }
        else {
            for (int i=0; i<game.h.length; i++) { // FIXTHIS
                numCardsInHandsOfNextPlayers[i] =
                    game.h[(game.currentPlayer - i - 1 +
                        game.scoreBoard.getNumPlayers()) %
                        game.scoreBoard.getNumPlayers()].size();
                totalScoreofPlayers[i] =
                    game.scoreBoard.getScore((game.currentPlayer - i - 1 +
                        game.scoreBoard.getNumPlayers()) %
                        game.scoreBoard.getNumPlayers());
                mostRecentColor[i] =
                    game.mostRecentColorCalled[(game.currentPlayer - i - 1 +
                        game.scoreBoard.getNumPlayers()) %
                        game.scoreBoard.getNumPlayers()];
            }
        }
        theGame = game;
    }

    
    public int[] getNumCardsInHandsOfUpcomingPlayers() {
        return numCardsInHandsOfNextPlayers;
    }

    public int[] getTotalScoreOfUpcomingPlayers() {
        return numCardsInHandsOfNextPlayers;
    }

    
    public UnoInterface.Color[] getMostRecentColorCalledByUpcomingPlayers() {
        return mostRecentColor;
    }

    
    public List<Card> getPlayedCards() {
        if (theGame != null) {
            return theGame.deck.getDiscardedCards();
        }
        else {
            // testing only
            return new java.util.ArrayList<Card>();
        }
    }
}
