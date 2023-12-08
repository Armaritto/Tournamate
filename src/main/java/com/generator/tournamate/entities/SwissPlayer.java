package com.generator.tournamate.entities;

public class SwissPlayer extends Participant{

    public SwissPlayer(String name, int score) {
        super(name, score);
    }

    int numOfWins = 0;
    int numOfLosses = 0;
    int numOfDraws = 0;


    public void incrementScoreW(){
        this.score += 2;
    }
    public void incrementScoreD(){
        this.score += 1;
    }


}
