package com.generator.tournamate;
import java.util.ArrayList;
import java.util.List;

public class SwissRoundService {
    public List<Pair<Integer, SwissMatch>> generateMatchList(List<Pair<Integer, SwissPlayer>> inputList){
        List<Pair<Integer, SwissMatch>> matchList = new ArrayList<>();
        if(inputList.size() % 2 != 0){
            SwissPlayer bye = new SwissPlayer(0, "bye");
            Pair<Integer, SwissPlayer> p =new Pair(0, bye);
            inputList.add(0, p);
        }

        for(int i=0; i< inputList.size()-1; i+=2){
            SwissPlayer p1 = inputList.get(i).second;
            SwissPlayer p2 = inputList.get(i+1).second;

            matchList.add(new Pair(i, new SwissMatch(p1, p2)));
        }
        return matchList;
    }
}
