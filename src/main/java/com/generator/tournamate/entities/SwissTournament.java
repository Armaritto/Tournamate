package com.generator.tournamate.entities;

import com.generator.tournamate.RoundNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Long.valueOf;

public class SwissTournament {
    Long id;
    int numberOfRounds;
    int currentRoundNumber =1;
    List<SwissPlayer> players = new ArrayList<>();
    ArrayList<SwissRound> rounds = new ArrayList<>(Arrays.asList(new SwissRound(1, players)));

    public SwissTournament(Long id, int numberOfRounds, List<SwissPlayer> players) {
        this.id =  id;
        this.numberOfRounds = numberOfRounds;
        this.players = players;
    }
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    public List<SwissPlayer> getPlayers() {
        return players;
    }

    public List<SwissRound> getRounds() {
        return rounds;
    }
    public SwissRound getRound(int roundNumber) throws RoundNotFoundException {
        for (SwissRound r : rounds) {
            if (r.getRoundNumber() == roundNumber) {
                return r;
            }

        }
        throw new RoundNotFoundException();
    }
    public void addRound(SwissRound round){
        rounds.add(round);
        currentRoundNumber++;
    }
    @Override
    public String toString() {
        return "SwissTournament{" + '\n' +
                "numberOfRounds=" + numberOfRounds + '\n' +
                ", currentRound=" + currentRoundNumber + '\n' +
                ", players=" + players + '\n' +
                ", rounds=" + rounds + '\n' +
                '}';
    }
}
