package com.generator.tournamate.entities;
import com.generator.tournamate.Pair;

import java.util.ArrayList;
import java.util.List;

public class SwissRound {
    int roundNumber;
    boolean finished = false;
    List<SwissPlayer> playersList;
    List<Pair<Integer, SwissPlayer>> outputList = new ArrayList<>();
    List<Pair<Integer, SwissMatch>> matchList = null;

    public SwissRound(int roundNumber, List<SwissPlayer> playersList) {
        this.roundNumber = roundNumber;
        this.playersList = playersList;
    }

    public void setPlayersList(List<SwissPlayer> playersList) {
        this.playersList = playersList;
    }

    public List<SwissPlayer> getPlayersList() {
        return playersList;
    }

    public List<Pair<Integer, SwissPlayer>> getOutputList() {
        return outputList;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public boolean isFinished() {
        return finished;
    }


    public List<Pair<Integer, SwissMatch>> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Pair<Integer, SwissMatch>> matchList) {
        this.matchList = matchList;
    }

    public boolean finishRound(){
        for(Pair<Integer, SwissMatch> i : matchList){
            if(i.second.getMatchStatus().equals("NA")){
                return false;
            }
        }
        if(!finished)
        for(SwissPlayer p : playersList){
            outputList.add(Pair.createPair(p.score, p));
        }
        finished = true;

        return true;
    }

    @Override
    public String toString() {
        return "SwissRound{" +
                "roundNumber=" + roundNumber +
                ", finished=" + finished +
                ", playersList=" + playersList +
                ", outputList=" + outputList +
                ", matchList=" + matchList +
                '}';
    }
}
