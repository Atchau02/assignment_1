package assignment_249.assignment_1;
import java.util.Scanner;
import java.util.ArrayList;

public class LadderAndSnake {


    private int dice;
    
    private int nbPlayers;
    ArrayList<Player> players;
    
    private int[][] gameBoard;
    private int[][] snakes;
    private int[][] ladders;

    Scanner keyboard = new Scanner(System.in);

    //constructor
    public LadderAndSnake(int nbOfPlayers){

        //number of players
        this.nbPlayers = nbOfPlayers;

       

        //setting up the board
        gameBoard = new int[10][10];
        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                if(row % 2 == 0)
                    gameBoard[row][col] = row*10 + col + 1;
                else if(row % 2 != 0)
                    gameBoard[row][col] = row*10 + 10 - col;

            }
                
        }

        // setting up the snakes and ladders
        snakes = new int[8][2];
        snakes[0][0] = 16;
        snakes[0][1] = 6;
        snakes[1][0] = 48;
        snakes[1][1] = 30;
        snakes[2][0] = 62;
        snakes[2][1] = 19;
        snakes[3][0] = 64;
        snakes[3][1] = 60;
        snakes[4][0] = 93;
        snakes[4][1] = 68;
        snakes[5][0] = 95;
        snakes[5][1] = 24;
        snakes[6][0] = 97;
        snakes[6][1] = 76;
        snakes[7][0] = 98;
        snakes[7][1] = 78;

        ladders = new int[9][2];
        ladders[0][0] = 1;
        ladders[0][1] = 38;
        ladders[1][0] = 4;
        ladders[1][1] = 14;
        ladders[2][0] = 9;
        ladders[2][1] = 31;
        ladders[3][0] = 21;
        ladders[3][1] = 42;
        ladders[4][0] = 28;
        ladders[4][1] = 84;
        ladders[5][0] = 36;
        ladders[5][1] = 44;
        ladders[6][0] = 51;
        ladders[6][1] = 67;
        ladders[7][0] = 71;
        ladders[7][1] = 91;
        ladders[8][0] = 80;
        ladders[8][1] = 100;
    }
    
    //method to flip the dice
    public int flipDice(){
        return dice = ((int)(Math.random()*6+1));
    }

    public int getDice() {
        return dice;
    }


    //initiate the game 
    public void play() {
        /*
         create the players and ask for name
         roll to chose order
         play the game
        */

        //initializing players ArrayList
        players = new ArrayList<Player>();

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
            int roll = flipDice();
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
        
                            tempRoll1 = flipDice();
                            System.out.println(players.get(i).getName() +" rolled a "+ tempRoll1);
                            tempRoll2 = flipDice();
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

        /* printing array lists
        for (Integer i : order) {
            System.out.println(i);
        } 
        
        System.out.println();

        for (Player i : players) {
            System.out.println(i.getName());
        } 
        */
    }

    public boolean movePlayer(Player player){
        
        //calculate new position
        int newPosition = player.getPosition() + flipDice();

        //if new position is 100 (won)
        if(newPosition == 100)
        {
            player.setPosition(100);
            return true;
        }

        else
        {
            if(newPosition > 100)
            {   //player goes over 100
                newPosition = 100 - (newPosition-100);
                player.setPosition(newPosition);
                return false;
            }

            //check if positionis head of snake
            for(int i = 0; i < 8; i++)
            {
                if (snakes[i][0] == newPosition) {
                    newPosition = snakes[i][1];
                    player.setPosition(newPosition);
                    System.out.println(player.getName() +" takes snake from +"+ snakes[i][0] + " to " + snakes[i][1] );
                    return false;
                }
            }
                
            //check if position is bottom of ladder
            for(int i = 0; i < 9; i++)
            {
                if (ladders[i][0] == newPosition) {
                    newPosition = ladders[i][1];
                    player.setPosition(newPosition);
                    System.out.println(player.getName() +" takes ladder from +"+ ladders[i][0] + " to " + ladders[i][1] );
                    return false;
                }
            }
            
            //regular move
            player.setPosition(newPosition);
            return false;
            
        }
    }
     

}
