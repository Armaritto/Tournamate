package com.RoundRobin.services;
import com.RoundRobin.RoundStillRunningException;
import com.RoundRobin.entities.RoundRobin;
import com.RoundRobin.entities.RoundRobinRound;
import com.RoundRobin.entities.RoundRobinTeam;

import java.util.LinkedList;
import java.util.List;

public class RoundRobinService {
        public static RoundRobinRound generateNextRound(RoundRobinRound currentRound, List<RoundRobinTeam> teams) throws RoundStillRunningException {
            if(currentRound.finishRound()) throw new RoundStillRunningException();
            return new RoundRobinRound(new LinkedList<>(teams), currentRound.getRoundNum()+1, currentRound.getNumOfMatches());
        }
}

