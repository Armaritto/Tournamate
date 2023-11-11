package com.generator.tournamate.services;

import com.generator.tournamate.RoundStillRunningException;
import com.generator.tournamate.entities.SwissPlayer;
import com.generator.tournamate.entities.SwissRound;

import java.util.List;

public class SwissTournamentService {
    public SwissRound generateNextRound(SwissRound currentRound, List<SwissPlayer> players) throws RoundStillRunningException {
        if(!currentRound.finishRound()) throw new RoundStillRunningException();
        return new SwissRound(currentRound.getRoundNumber()+1, players);
    }
}
