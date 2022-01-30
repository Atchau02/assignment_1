package assignment_249.assignment_1;

public class Player {

    String name;
    int position;
    int startingRoll;

    public Player(String name){
        this.name = name;
        this.position = 0;
    }


    //getters and setter
    public String getName() {
        return name;
    }

    public int getStartingRoll() {
        return startingRoll;
    }

    public void setStartingRoll(int startingRoll) {
        this.startingRoll = startingRoll;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String toString(){
        return this.name + " is at " + this.position;
    }

}



   
