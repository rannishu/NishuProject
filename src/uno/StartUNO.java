
package uno;

import java.util.ArrayList;
import java.util.Scanner;

public class StartUNO {

    static boolean DISPLAY = true;

    private static ArrayList<String> playerNames = new ArrayList<String>();
    private static ArrayList<String> playerClasses = new ArrayList<String>();
    private static int gameType;
        
    /** 
     * Run an Uno game simulation 
     */
    public static void main(String args[]) {
        System.out.println("***********************************************");
        System.out.println("          AUTHOR : NISHU RANI");
        System.out.println("         STUDENT ID: 991606922");
        System.out.println("***********************************************\n\n\n");
        
        System.out.println("***********Welcome to the game of UNO**********");
        Scanner sc=new Scanner(System.in);
        boolean proceed=false;
        while(proceed==false){
            System.out.println("Choose the game type:\n1.Single Player\n2.Multiplayer\n");
            gameType=sc.nextInt();
            if(gameType==1 || gameType==2){
                proceed=true;
            }
            else{
                proceed=false;
                System.out.println("Invalid input. Try again.");
            }
        }
        System.out.println("Enter the number of rounds: ");
        int numGames=sc.nextInt();
        try {
            inputPlayerDetails();
            Scoreboard s = new Scoreboard(playerNames.toArray(new String[0]));
            for (int i=0; i<numGames; i++) {
                Game g = new Game(s,playerClasses);
                g.Play();
            }
            System.out.println(s);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void inputPlayerDetails() {
        Scanner sc;
        sc=new Scanner(System.in);
        String name;
        if(gameType==2){
            System.out.println("Enter the number of players: ");
            int numPlayers= sc.nextInt();
            if(numPlayers>1)
                for (int i=0; i<numPlayers; i++) {
                    sc=new Scanner(System.in);
                    System.out.println("Enter the name of player "+(i+1)+": ");
                    name=sc.nextLine();
                    playerNames.add(name);
                    playerClasses.add("uno.HumanPlayer");
                }
            }
        else{
            System.out.println("Enter your name: ");
            name=sc.nextLine();
            playerNames.add("Computer");
            playerClasses.add("uno.ComputerPlayer");
            playerNames.add(name);
            playerClasses.add("uno.HumanPlayer");
            }
      
        }
    }


