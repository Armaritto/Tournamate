package com.generator.tournamate.entities;

import java.util.List;


public class RoundRobinMatch {

    private int matchNum;
    private RoundRobinTeam matchTeam1;
    private RoundRobinTeam matchTeam2;
    private String MatchStatus = "NA";

    public RoundRobinMatch(RoundRobinTeam matchTeam1, RoundRobinTeam matchTeam2, int matchNum)
    {
        this.matchTeam1=matchTeam1;
        this.matchTeam2=matchTeam2;
        this.matchNum=matchNum;
    }
    public int getMatchNum() {
        return matchNum;
    }

    public String getMatchStatus() {
        return MatchStatus="NA";
    }
    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    public String getMatchResult() {
        return MatchStatus;
    }


    public void setMatchResult(String stat) {

        MatchStatus = stat;

        if (stat.equals("D")) {
            matchTeam1.setTeamPoints(1);
            matchTeam2.setTeamPoints(1);
            matchTeam1.setDraws(matchTeam1.getDraws()+1);
            matchTeam2.setDraws(matchTeam2.getDraws()+1);


        } else if (stat.equals("P1")) {
            matchTeam1.setTeamPoints(3);
            matchTeam1.setWins(matchTeam1.getWins()+1);
            matchTeam2.setLosses(matchTeam2.getLosses()+1);
        } else if (stat.equals("P2")) {
            matchTeam2.setTeamPoints(3);
            matchTeam2.setWins(matchTeam2.getWins()+1);
            matchTeam1.setLosses(matchTeam1.getLosses()+1);
        }
    }

    public RoundRobinTeam getMatchTeam1() {
        return matchTeam1;
    }

    public void setMatchTeam1(RoundRobinTeam matchTeam1) {
        this.matchTeam1 = matchTeam1;
    }

    public RoundRobinTeam getMatchTeam2() {
        return matchTeam2;
    }

    public void setMatchTeam2(RoundRobinTeam matchTeam2) {
        this.matchTeam2 = matchTeam2;
    }

    @Override
    public String toString() {
        return "RoundRobinMatch{" +
                "matchNum=" + matchNum +
                ", matchTeam1=" + matchTeam1 +
                ", matchTeam2=" + matchTeam2 +
                ", MatchStatus='" + MatchStatus + '\'' +
                '}';
    }
}
