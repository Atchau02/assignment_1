package assignment_249.assignment_1;
import java.util.Scanner;

public class LadderAndSnake {


    
    
    private int nbPlayers;
    private int dice;
    
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
        
        //printing the board
        System.out.println("This is your gameboard");
        for(int row = gameBoard.length-1; row >= 0; row--)
        {
            for(int col = 0; col < gameBoard[row].length; col++)
            {
                System.out.print("\t" + gameBoard[row][col]);
            }
            System.out.println();
        }

        System.out.println("\nThe snakes are located at: (16 -> 6), (48 -> 30), (62 -> 19), (64 -> 60), (93 -> 68), (95 -> 24), (97 -> 76), (98 -> 78).");
        System.out.println("The ladders are located at: (1 -> 38), (4 -> 14), (9 -> 31), (21 -> 42), (28 -> 84), (36 -> 44), (51 -> 67), (71 -> 91), (80 -> 100).");

        System.out.println("\n\nLet the game begin!\n\n");
        
    }

    //moving players
    public boolean movePlayer(Player player){
        
        //calculate new position
        int theRoll = flipDice();
        int newPosition = player.getPosition() + theRoll;
        System.out.println(player + " and rolled a " + theRoll);

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
                System.out.println(player.getName() +" went to far and goes back down to " + newPosition);
                return false;
            }

            //check if positionis head of snake
            for(int i = 0; i < 8; i++)
            {
                if (snakes[i][0] == newPosition) {
                    newPosition = snakes[i][1];
                    player.setPosition(newPosition);
                    System.out.println(player.getName() +" takes snake from "+ snakes[i][0] + " to " + snakes[i][1] );
                    return false;
                }
            }
                
            //check if position is bottom of ladder
            for(int i = 0; i < 9; i++)
            {
                if (ladders[i][0] == newPosition) {
                    newPosition = ladders[i][1];
                    player.setPosition(newPosition);
                    System.out.println(player.getName() +" takes ladder from "+ ladders[i][0] + " to " + ladders[i][1] );
                    return false;
                }
            }

            if(newPosition == 100)
            {
                player.setPosition(100);
                return true;
            }
            
            //regular move
            player.setPosition(newPosition);
            System.out.println(player.getName() + " moves to " + newPosition);
            return false;
            
        }
    }
     

    

}
