package com.generator.tournamate.entities;

import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class RoundRobinRound {
    private int numOfMatches;
    private int roundNum;
    boolean finished = false;
    private List<RoundRobinMatch> roundMatches;
    private Deque<RoundRobinTeam> teams;
public RoundRobinRound(Deque<RoundRobinTeam> teams, int roundNum,int num)
{
    this.teams =teams;
    this.roundNum=roundNum;
    this.numOfMatches=num;

}
    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    public boolean finishRound(){
        for(RoundRobinMatch i : roundMatches){
            if(i.getMatchStatus().equals("NA")){
                return false;
            }
        }
        finished = true;
        return true;
    }

    public List<RoundRobinMatch> getRoundMatches() {
        return roundMatches;
    }

    public void setRoundMatches(List<RoundRobinMatch> roundMatches) {
        this.roundMatches = roundMatches;
    }

    public int getRoundNum() {
        return roundNum;
    }

    public int getNumOfMatches() {
        return numOfMatches;
    }

    public void setTeams(Deque<RoundRobinTeam> teams) {
        this.teams = teams;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }


    @Override
    public String toString() {
        return "RoundRobinRound{" +
                "numOfMatches=" + numOfMatches +
                ", roundNum=" + roundNum +
                ", finished=" + finished +
                ", roundMatches=" + roundMatches +
               // ", teams=" + teams +
                '}';
    }
}
