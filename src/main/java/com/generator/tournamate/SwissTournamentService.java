package com.generator.tournamate;

import java.util.ArrayList;
import java.util.List;

public class SwissTournamentService {
    public SwissRound generateNextRound(SwissRound currentRound, List<SwissPlayer> players) throws RoundStillRunningException{
        if(currentRound.finishRound()) throw new RoundStillRunningException();
        return new SwissRound(currentRound.getRoundNumber()+1, players);
    }
}
