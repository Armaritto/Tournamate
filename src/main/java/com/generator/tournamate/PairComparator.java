package com.generator.tournamate;

import com.generator.tournamate.entities.Participant;
import com.generator.tournamate.entities.SwissPlayer;

import java.util.Comparator;

public class PairComparator implements Comparator<Pair<Integer, SwissPlayer>> {
    public int compare(Pair p1, Pair p2){
        return ((int)p1.first - (int)p2.first);
    }

}
