package com.generator.tournamate.services;
import com.generator.tournamate.RoundStillRunningException;
import com.generator.tournamate.entities.RoundRobin;
import com.generator.tournamate.entities.RoundRobinRound;
import com.generator.tournamate.entities.RoundRobinTeam;

import java.util.LinkedList;
import java.util.List;

public class RoundRobinService {
        public static RoundRobinRound generateNextRound(RoundRobinRound currentRound, List<RoundRobinTeam> teams) throws RoundStillRunningException {
          //  if(!currentRound.finishRound()) throw new RoundStillRunningException();
            return new RoundRobinRound(new LinkedList<>(teams), currentRound.getRoundNum()+1, currentRound.getNumOfMatches());
        }
}

