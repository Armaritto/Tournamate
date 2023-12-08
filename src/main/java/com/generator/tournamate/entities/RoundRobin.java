package com.generator.tournamate.entities;

import com.generator.tournamate.RoundNotFoundException;


import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;



public class RoundRobin {
 private int numberOfRounds=0;
private List<RoundRobinRound> rounds;
private Deque<RoundRobinTeam> teams;
private int currentRound=1;


public RoundRobin(List<RoundRobinTeam> RoundRobinTeams)
{
    this.teams = new LinkedBlockingDeque<>(RoundRobinTeams);
    rounds=new ArrayList<>();
    if(teams.size()%2==0)
    {
        numberOfRounds=teams.size()-1;
        for (int i=0; i<numberOfRounds; i++)
        {
            rounds.add(new RoundRobinRound( teams , i+1,teams.size()/2));
        }
    } else{
        numberOfRounds=teams.size();
        for (int i=0; i<numberOfRounds; i++)
        {
            rounds.add( new RoundRobinRound(teams,i+1,(teams.size()-1)/2));
        }
        }
}
    public RoundRobinRound getRound(int roundNumber) throws RoundNotFoundException {
        for (RoundRobinRound r : rounds) {
            if (r.getRoundNum() == roundNumber) {
                return r;
            }

        }
        throw new RoundNotFoundException();
    }
    public void addRound(RoundRobinRound round){
        rounds.add(round);
    }
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public List<RoundRobinTeam> getTeams() {
        return teams.stream().toList();
    }

    public void setTeams(List<RoundRobinTeam> teams) {
        this.teams = new LinkedList<>(teams);
    }

    public int getCurrentRound() {
        return currentRound;
    }
    public void SetCurrentRound() {
        this.currentRound+=1;
    }


    public List<RoundRobinRound> getRounds() {
        return rounds;
    }

    public void setRounds(List<RoundRobinRound> rounds) {
        this.rounds = rounds;
    }
    @Override
    public String toString() {
        return "SwissTournament{" +
                "numberOfRounds=" + rounds.size() +
                ", currentRound=" + currentRound +
                ", Teams=" + teams+
                ", rounds=" + rounds +
                '}';
    }

    public void setRound(LinkedList<RoundRobinTeam> roundRobinTeams) {
    rounds.set(currentRound-1,new RoundRobinRound(roundRobinTeams,currentRound,(int)(teams.size()/2)));

    }
}
