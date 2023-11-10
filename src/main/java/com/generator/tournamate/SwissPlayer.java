package com.generator.tournamate;

public class SwissPlayer {
    long id;
    int currentScore;
    String Name;

    public long getId() {
        return id;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public String getName() {
        return Name;
    }

    public SwissPlayer(int currentScore, String name) {
        this.currentScore = currentScore;
        Name = name;
    }

    public SwissPlayer(long id, int currentScore, String name) {
        this.id = id;
        this.currentScore = currentScore;
        Name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setName(String name) {
        Name = name;
    }
    public void incrementScoreW(){
        currentScore += 2;
    }
    public void incrementScoreD(){
        currentScore += 1;
    }

    @Override
    public String toString() {
        return "SwissPlayer{" +
                "id=" + id +
                ", currentScore=" + currentScore +
                ", Name='" + Name + '\'' +
                '}';
    }
}
