package assignment_249.assignment_1;

/*
 Written by: Anh Tu Chau 40207791
 COMP249
 Assignment 1
 Due date: February 4 2022
*/

/**
 * @author Anh Tu Chau
 * @version 1
 */
public class Player {

    String name;
    int position;
    int startingRoll;

    /**
     * Creates a player with a name and sets the location to 0
     * @param name Name of the player
     */
    public Player(String name){
        this.name = name;
        this.position = 0;
    }


    /**
     * Gets the name of a player
     * @return string the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the staring roll to chose order
     * @return the first roll to chose the order
     */
    public int getStartingRoll() {
        return startingRoll;
    }

    /**
     * Sets the starting roll of the player
     * @param startingRoll int the roll to decide the order
     */
    public void setStartingRoll(int startingRoll) {
        this.startingRoll = startingRoll;
    }

    /**
     * Gets the location of the player
     * @return int current location of the player
     */
    public int getPosition() {
        return position;
    }

    /**
     * Changes the location value of the player
     * @param position int new location for the player
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * prints the info of the player(name and location)
     */
    public String toString(){
        return this.name + " is at " + this.position;
    }

}





   
