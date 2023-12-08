package com.generator.tournamate.entities;
import com.generator.tournamate.Pair;
import com.generator.tournamate.PairComparator;

import java.util.ArrayList;
import java.util.Collections;
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


    public boolean finishRound() throws CloneNotSupportedException {

        for(Pair<Integer, SwissMatch> i : matchList){
            if(i.second.getMatchStatus().equals("NA")){
                return false;
            }
        }
        if(!finished)
        for(SwissPlayer p : playersList){

            outputList.add(Pair.createPair(p.score, (SwissPlayer) p.clone()));

        }
        Collections.sort(outputList, new PairComparator());
        Collections.reverse(outputList);
        finished = true;

        return true;
    }

    @Override
    public String toString() {
        return "SwissRound{" + '\n' +
                "roundNumber=" + roundNumber +
                ", finished=" + finished + '\n' +'\n' +
            //    ", playersList=" + playersList +'\n' +'\n' +
                ", outputList=" + outputList +
                ", matchList=" + matchList +
                '}' + '\n' ;
    }
}
