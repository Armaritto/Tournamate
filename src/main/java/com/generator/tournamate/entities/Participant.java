package com.generator.tournamate.entities;

public class Participant {
    long id;
    String name;
    int score;
    String photoPath;

    public Participant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Participant(long id, String name, int score, String photoPath) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.photoPath = photoPath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
