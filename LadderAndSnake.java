package assignment_249.assignment_1;

public class LadderAndSnake {


    private int dice;
    
    private int nbPlayers;
    
    private int[][] gameBoard;
    private int[][] snakes;
    private int[][] ladders;


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
        1. use constructor for board
        2. create players
        3. roll to chose order
        4. play
        */
    }

     

}
