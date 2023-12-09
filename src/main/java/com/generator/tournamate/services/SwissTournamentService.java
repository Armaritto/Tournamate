package com.generator.tournamate.services;


import com.generator.tournamate.RoundNotFoundException;
import com.generator.tournamate.RoundStillRunningException;
import com.generator.tournamate.entities.SwissPlayer;
import com.generator.tournamate.entities.SwissRound;
import com.generator.tournamate.entities.SwissTournament;

import java.util.HashMap;
import java.util.List;

import static java.lang.Long.valueOf;

public class SwissTournamentService {
    public static HashMap<Long, SwissTournament> AllSwissTournaments = new HashMap<>();
    public Long generateSwissTournament(int numberOfRounds, List<SwissPlayer> players) throws RoundNotFoundException {  // generates a new tournament and returns its id
        Long id = valueOf(13);  //valueOf((long) (Math.random()*10000000));
        AllSwissTournaments.put(id, new SwissTournament(id, numberOfRounds, players));
        SwissTournamentService.AllSwissTournaments.get(id).getRound(1).setPlayersList(players);
        return id;
    }
    public SwissRound generateNextRound(SwissRound currentRound, List<SwissPlayer> players) throws RoundStillRunningException, CloneNotSupportedException {
        if(currentRound.getRoundNumber() == 1){return currentRound;}
        if(!currentRound.finishRound()) throw new RoundStillRunningException();
        return new SwissRound(currentRound.getRoundNumber()+1, players);
    }
}
