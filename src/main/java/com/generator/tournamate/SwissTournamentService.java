package com.generator.tournamate;

import java.util.ArrayList;
import java.util.List;

public class SwissTournamentService {
    public SwissRound generateNextRound(SwissRound currentRound, List<SwissPlayer> players) throws RoundStillRunningException{
        if(currentRound.finishRound()) throw new RoundStillRunningException();
        List<Pair<Integer, SwissPlayer>> l = new ArrayList<>();
        for(SwissPlayer p : players){
            l.add(Pair.createPair(p.currentScore, p));
        }

        return new SwissRound(currentRound.getRoundNumber()+1, l);
    }
}
