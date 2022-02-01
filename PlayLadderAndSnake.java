package assignment_249.assignment_1;
import java.util.Scanner;
import java.util.ArrayList;
/*
 Written by: Anh Tu Chau 40207791
 COMP249
 Assignment 1
 Due date: February 4 2022
 ***********************************
 This program simulates the game Ladder and Snake.
 */


 /**
  * @author Anh Tu Chau
  * @version 1
  */
public class PlayLadderAndSnake {
    public static void main(String[] args) {

        //Welcome message
        System.out.println("Welcome to the Ladder and Snake program made by Anh Tu Chau\n");

        //asking how many players
        int nbPlayers;
        Scanner keyboard = new Scanner(System.in);
       
        System.out.println("Enter the # of players for your game (2 to 4 players): ");
        nbPlayers = keyboard.nextInt();
        
        boolean valid = nbPlayers >= 2 && nbPlayers <= 4;


        int attempts = 1;

        while (!valid) {
            if (attempts == 4) {
                System.out.println("Bad Attempt 4! You have exhausted all your chances. Program will terminate!");
                System.exit(0);
            }

            System.out.println("Bad attempt "+ attempts +" -Invalid # of players. # between 2 and 4 inclusively.");
            if (attempts ==3) {
                System.out.println("This is your last attempt!");
            }
            nbPlayers = keyboard.nextInt();
            attempts++;
            valid = nbPlayers >= 2 && nbPlayers <= 4;
        }

        //creating the board
        LadderAndSnake board = new LadderAndSnake(nbPlayers);

        //initializing players ArrayList
        ArrayList<Player> players = new ArrayList<Player>();

        //creating the players and asking for name
        System.out.println("\nWhat is player1's name? (single word)");
        String P1name = keyboard.next();
        Player player1 = new Player(P1name);
        players.add(player1);

        System.out.println("What is player2's name? (single word)");
        String P2name = keyboard.next();
        Player player2 = new Player(P2name);
        players.add(player2);

        if (nbPlayers >= 3) {
            System.out.println("What is player3's name? (single word)");
            String P3name = keyboard.next();
            Player player3 = new Player(P3name);
            players.add(player3);
        }

        if (nbPlayers == 4) {
            System.out.println("What is player4's name? (single word)");
            String P4name = keyboard.next();
            Player player4 = new Player(P4name);
            players.add(player4);
        }

        //choosing order

        //1. roll dice + adding to array list
        System.out.println("\nNow deciding the order that the players will play in:");

        ArrayList<Integer> order = new ArrayList<Integer>();
        for(int i = 0; i < players.size(); i++)
        {
            int roll = board.flipDice();
            players.get(i).setStartingRoll(roll);
            order.add(roll);
            System.out.println(players.get(i).getName()+ " rolled a " + roll);
        }

        //2. sort from large to small + changing positon in players arraylist
        int temp;
        Player tempPlayer;
        
        for(int i = 0; i < order.size(); i++)
            for(int j = i; j < order.size(); j++)
            {
                if(order.get(i) < order.get(j))
                {
                    temp = order.get(i);
                    order.set(i, order.get(j));
                    order.set(j, temp);

                    tempPlayer = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, tempPlayer);
                }
            }
        
        //3. check if 2 values are equal and reroll + changing positon in players arraylist
        int tempRoll1;
        int tempRoll2;

        for(int i = 0; i < order.size(); i++)
            for(int j = i + 1; j < order.size(); j++)
            {
                if(order.get(i) == order.get(j))
                {
                    do 
                    {   
                            System.out.println("A tie was achieved between "+ players.get(i).getName() + " and " + players.get(j).getName());
                            System.out.println("Rerolling to break tie.");
        
                            tempRoll1 = board.flipDice();
                            System.out.println(players.get(i).getName() +" rolled a "+ tempRoll1);
                            tempRoll2 = board.flipDice();
                            System.out.println(players.get(j).getName() +" rolled a "+ tempRoll2);
        
                            if(tempRoll1 < tempRoll2)
                            {
                                tempPlayer = players.get(i);
                                players.set(i, players.get(j));
                                players.set(j, tempPlayer); 
                            }
                    } while (tempRoll1 == tempRoll2);
                }
            }

        //printing the order
        System.out.println("The order of play is: ");
        for (Player i : players) {
            System.out.println(i.getName());
        } 
        

        //initializing game
        board.play();

        // playing the game until someone wins
        boolean done = false;
        int playerIndex = 0;

        while (!done) {
            done = board.movePlayer(players.get(playerIndex));

            if (done) {
                System.out.println(players.get(playerIndex).getName() +" has won the game!!!");
            }


            //setting up for next player
            playerIndex++;
            if(playerIndex == nbPlayers && !done)
            {
                playerIndex = 0;
                board.printBoard(players);
                System.out.println("------------------------------------------");
            }
                

            System.out.println();    

        }



        //Closing message
        System.out.println("Thank you for using the Ladder and Snake program!");
        
        keyboard.close();
    }
    
}