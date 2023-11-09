package com.generator.tournamate;

import java.util.ArrayList;
import java.util.List;

public class SwissTournament {
    int numberOfRounds;
    int currentRound=1;
    List<SwissPlayer> players = new ArrayList<>();
    List<SwissRound> rounds = new ArrayList<>();

    public SwissTournament(int numberOfRounds, List<SwissPlayer> players) {
        this.numberOfRounds = numberOfRounds;
        this.players = players;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public List<SwissPlayer> getPlayers() {
        return players;
    }

    public List<SwissRound> getRounds() {
        return rounds;
    }
}
