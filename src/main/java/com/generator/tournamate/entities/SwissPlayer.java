package com.generator.tournamate.entities;

public class SwissPlayer extends Participant implements Cloneable{

    public SwissPlayer(String name, int score) {
        super(name, score);
    }

    int numOfWins = 0;
    int numOfLosses = 0;
    int numOfDraws = 0;
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public int getNumOfLosses() {
        return numOfLosses;
    }

    public void setNumOfLosses(int numOfLosses) {
        this.numOfLosses = numOfLosses;
    }

    public int getNumOfDraws() {
        return numOfDraws;
    }

    public void setNumOfDraws(int numOfDraws) {
        this.numOfDraws = numOfDraws;
    }

    public void incrementScoreW(){
        this.score += 2;
    }
    public void incrementScoreD(){
        this.score += 1;
    }

    @Override
    public String toString() {
        return "SwissPlayer{" +
                "numOfWins=" + numOfWins +
                ", numOfLosses=" + numOfLosses +
                ", numOfDraws=" + numOfDraws +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
