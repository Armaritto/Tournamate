package com.generator.tournamate;

import java.util.ArrayList;
import java.util.List;

public class SwissTournament {
    int numberOfRounds;
    int currentRoundNumber =1;
    List<SwissPlayer> players = new ArrayList<>();
    List<SwissRound> rounds = List.of(new SwissRound(1, players));

    public SwissTournament(int numberOfRounds, List<SwissPlayer> players) {
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
    }
    @Override
    public String toString() {
        return "SwissTournament{" +
                "numberOfRounds=" + numberOfRounds +
                ", currentRound=" + currentRoundNumber +
                ", players=" + players +
                ", rounds=" + rounds +
                '}';
    }
}
