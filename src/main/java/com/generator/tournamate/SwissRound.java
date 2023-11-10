package com.generator.tournamate;
import java.util.ArrayList;
import java.util.List;

public class SwissRound {
    int roundNumber;
    boolean finished = false;
    List<Pair<Integer, SwissPlayer>> inputList = new ArrayList<>();
    List<Pair<Integer, SwissMatch>> matchList = null;
    public SwissRound(int roundNumber, List<Pair<Integer, SwissPlayer>> inputList) {
        this.roundNumber = roundNumber;
        this.inputList = inputList;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public boolean isFinished() {
        return finished;
    }

    public List<Pair<Integer, SwissPlayer>> getInputList() {
        return inputList;
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
        finished = true;
        return true;
    }

    @Override
    public String toString() {
        return "SwissRound{" +
                "roundNumber=" + roundNumber +
                ", finished=" + finished +
                ", inputList=" + inputList +
                ", matchList=" + matchList +
                '}';
    }
}
