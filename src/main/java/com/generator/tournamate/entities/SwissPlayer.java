package com.generator.tournamate.entities;

public class SwissPlayer extends Participant{

    public SwissPlayer(String name, int score) {
        super(name, score);
    }

    public void incrementScoreW(){
        this.score += 2;
    }
    public void incrementScoreD(){
        this.score += 1;
    }


}
