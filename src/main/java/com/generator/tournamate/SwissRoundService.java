package com.generator.tournamate;
import java.util.ArrayList;
import java.util.List;

public class SwissRoundService {
    public List<Pair<Integer, SwissMatch>> generateMatchList(List<SwissPlayer> inputList){
        List<Pair<Integer, SwissMatch>> matchList = new ArrayList<>();

        for(int i=0; i< inputList.size()-1; i+=2){
            SwissPlayer p1 = inputList.get(i);
            SwissPlayer p2 = inputList.get(i+1);

            matchList.add(new Pair(i, new SwissMatch(p1, p2)));
        }
        if(inputList.size() % 2 != 0){
            int i = inputList.size()-1;
            SwissPlayer p1 = inputList.get(i);
            SwissPlayer bye = new SwissPlayer(0, "bye");
            matchList.add(new Pair(inputList.size()-1, new SwissMatch(p1, bye)));
            matchList.get(i).second.setStatusP1();
        }
        return matchList;
    }
}
