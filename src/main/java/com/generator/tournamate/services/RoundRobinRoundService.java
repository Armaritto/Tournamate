package com.generator.tournamate.services;

import com.generator.tournamate.entities.RoundRobin;
import com.generator.tournamate.entities.RoundRobinMatch;
import com.generator.tournamate.entities.RoundRobinRound;
import com.generator.tournamate.entities.RoundRobinTeam;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
 public class RoundRobinRoundService {
     private RoundRobinRound round;
        public List<RoundRobinMatch> generateMatchList(Deque<RoundRobinTeam> teams , int roundNum,int num) {

               round =new RoundRobinRound(teams,roundNum,num);
                List<RoundRobinMatch> roundMatches =new ArrayList<>();
                RoundRobinTeam first = teams.removeFirst();
                for(int i=1; i<roundNum; i++){
                    teams.add(teams.removeFirst());
                }
                teams.add(first);
           // System.out.println(teams);
                for(int i=0; i<round.getNumOfMatches(); i++)
                {
                    if(teams.size()%2==1 &&roundNum==teams.size() )
                    {
                        teams.removeFirst();
                       roundMatches.add(i,new RoundRobinMatch(teams.removeFirst(),teams.removeFirst(),i+1));
                    }
                    else roundMatches.add(i,new RoundRobinMatch(teams.removeFirst(),teams.removeLast(),i+1));
                }
                round.setRoundMatches(roundMatches);

            return roundMatches;
        }
}
