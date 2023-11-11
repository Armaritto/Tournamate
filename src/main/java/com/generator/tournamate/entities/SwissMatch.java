package com.generator.tournamate.entities;

public class SwissMatch {
     SwissPlayer player1;
     SwissPlayer player2;
     int warningsPlayer1=0;
     int warningsPlayer2=0;
     String matchStatus = "NA";

    public SwissMatch(SwissPlayer player1, SwissPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public SwissMatch(SwissPlayer player1, SwissPlayer player2, String matchStatus) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchStatus = matchStatus;
    }

    public void setStatusNA(){
        matchStatus = "NA";
    }
    public void setStatusP1(){
        matchStatus = "P1";
        player1.incrementScoreW();
    }
    public void setStatusP2(){
        matchStatus = "P2";
        player2.incrementScoreW();
    }
    public void setStatusD(){
        matchStatus = "D";
        player1.incrementScoreD();
        player2.incrementScoreD();
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public SwissPlayer getPlayer1() {
        return player1;
    }

    public SwissPlayer getPlayer2() {
        return player2;
    }

    public int getWarningsPlayer1() {
        return warningsPlayer1;
    }

    public int getWarningsPlayer2() {
        return warningsPlayer2;
    }
    public void addWarningPlayer1(){
        warningsPlayer1++;
    }
    public void addWarningPlayer2(){
        warningsPlayer2++;
    }
    public void removeWarningPlayer1(){
        if(warningsPlayer1>0)
            warningsPlayer1--;
    }
    public void removeWarningPlayer2(){
        if(warningsPlayer2>0)
            warningsPlayer2--;
    }

    @Override
    public String toString() {
        return "SwissMatch{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", warningsPlayer1=" + warningsPlayer1 +
                ", warningsPlayer2=" + warningsPlayer2 +
                ", matchStatus='" + matchStatus + '\'' +
                '}';
    }
}
