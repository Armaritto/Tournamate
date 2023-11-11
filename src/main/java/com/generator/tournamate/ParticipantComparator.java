package com.generator.tournamate;

import com.generator.tournamate.entities.Participant;
import com.generator.tournamate.entities.SwissPlayer;

import java.util.Comparator;

public class ParticipantComparator implements Comparator<Participant> {
    public int compare(Participant p1, Participant p2){
        return (p1.getScore() - p2.getScore());
    }
}