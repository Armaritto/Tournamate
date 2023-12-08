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
        player1.setNumOfWins(player1.getNumOfWins()+1);
        player2.setNumOfLosses(player2.getNumOfLosses()+1);
    }
    public void setStatusP2(){
        matchStatus = "P2";
        player2.incrementScoreW();
        player2.setNumOfWins(player2.getNumOfWins()+1);
        player1.setNumOfLosses(player1.getNumOfLosses()+1);
    }
    public void setStatusD(){
        matchStatus = "D";
        player1.incrementScoreD();
        player2.incrementScoreD();
        player1.setNumOfDraws(player1.getNumOfDraws()+1);
        player2.setNumOfDraws(player2.getNumOfDraws()+1);
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
        return "SwissMatch{" + '\n' +
                "player1=" + player1 +'\n' +
                ", player2=" + player2 +'\n' +
                ", matchStatus='" + matchStatus + '\'' +
                '}';
    }
}
