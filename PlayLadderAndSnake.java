package assignment_249.assignment_1;
import java.util.Scanner;
import java.util.ArrayList;
/*
 Assignment 1
 Written by: Anh Tu Chau 40207791
 ***********************************
 general explanation to add later
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


        int i = 1;

        while (!valid) {
            if (i == 4) {
                System.out.println("Bad Attempt 4! You have exhausted all your chances. Program will terminate!");
                System.exit(0);
            }

            System.out.println("Bad attempt "+ i +" -Invalid # of players. # between 2 and 4 inclusively.");
            if (i ==3) {
                System.out.println("This is your last attempt!");
            }
            nbPlayers = keyboard.nextInt();
            i++;
            valid = nbPlayers >= 2 && nbPlayers <= 4;
        }

        //creating the board
        LadderAndSnake board = new LadderAndSnake(nbPlayers);

        //initializing game
        board.play();


        /*
            1. ask for nb of player between 2 and 4
            2. play()
            3. player take turn
            4. update board
            5. print board
            6. set up for next player and ask for next round
            7. repeat 1 to 6 until winner
        */

        // player take turn until someone wins
        



        //Closing message
        System.out.println("Thank you for using the Ladder and Snake program!");
        
        keyboard.close();
    }
    
}