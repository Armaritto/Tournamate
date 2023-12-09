package com.generator.tournamate.controllers;
import com.generator.tournamate.PairComparator;
import com.generator.tournamate.ParticipantComparator;
import com.generator.tournamate.services.Service;
import com.generator.tournamate.RoundNotFoundException;
import com.generator.tournamate.RoundStillRunningException;
import com.generator.tournamate.entities.*;
import com.generator.tournamate.services.RoundRobinRoundService;
import com.generator.tournamate.services.RoundRobinService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path = "/RoundRobintournament")
public class RoundRobinController {
    RoundRobinRoundService roundRobinRoundService = new RoundRobinRoundService();
    RoundRobinService roundRobinService= new RoundRobinService();
  //  List<RoundRobinTeam> teams =new ArrayList<>();
    RoundRobin myTournament = null;
    @PostMapping(path = "/newRoundRobinTournament")
    public Long generateTournament(@RequestParam("name") String name, @RequestParam("list") List list) throws RoundNotFoundException {
//        teams.add(new RoundRobinTeam("11"));
//        teams.add(new RoundRobinTeam("22"));
//        teams.add(new RoundRobinTeam("33"));
//        teams.add(new RoundRobinTeam("44"));
//        teams.add(new RoundRobinTeam("55"));
//        teams.add(new RoundRobinTeam("66"));
//        teams.add(new RoundRobinTeam("77"));
//        teams.add(new RoundRobinTeam("88"));
        List<RoundRobinTeam> teams =new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            teams.add(new RoundRobinTeam(list.get(i).toString()));
        }

        myTournament = new RoundRobin(teams);
        myTournament.setRound(new LinkedList<>(teams));
        //System.out.println(myTournament);
        return 13L;

    }

    @PostMapping(path = "/newRoundRobinRound")
    public List generateRound(@RequestParam("id") Long id) throws RoundNotFoundException, RoundStillRunningException {
//        generateTournament();
//        myTournament.addRound(new RoundRobinRound(new LinkedList<>(teams),2,myTournament.getRound(1).getNumOfMatches()));
       // RoundRobinRound newRound = RoundRobinService.generateNextRound(myTournament.getRound(myTournament.getCurrentRound()), myTournament.getTeams());
        int roundNumber = myTournament.getCurrentRound();
        myTournament.setCurrentRound(roundNumber+1);
        List<RoundRobinMatch> matchList = roundRobinRoundService.generateMatchList
                (new LinkedList<>(myTournament.getTeams()),roundNumber
                        ,myTournament.getRound(roundNumber).getNumOfMatches());
        myTournament.getRound(roundNumber).setRoundMatches(matchList);
        return matchList;
    }
    @PostMapping(path = "/setMatch")
    public String setMatch(@RequestParam("id") Long id, @RequestParam("roundNumber") int roundNumber , @RequestParam("matchNumber") int matchNumber, @RequestParam("matchStatus") String matchStatus) throws RoundNotFoundException {
        if(myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).getMatchStatus().equals("NA")) {
            switch (matchStatus) {
                case "P1":
                    myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("P1");
                    break;
                case "P2":
                    myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("P2");
                    break;
                case "D":
                    myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("D");
                    break;
                default:
                    myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("NA");
            }
        }
        return myTournament.toString();
    }
//    @PostMapping(path = "/generateMatches")
//    public String generateMatches(@RequestParam("roundNumber")int roundNumber) throws RoundNotFoundException {
//        List<RoundRobinMatch> matchList = roundRobinRoundService.generateMatchList
//                (new LinkedList<>(myTournament.getTeams()),roundNumber
//                        ,myTournament.getRound(roundNumber).getNumOfMatches());
//       // myTournament.getRound(roundNumber).setTeams(new LinkedList<>(teams));
//        myTournament.getRound(roundNumber).setRoundMatches(matchList);
//
//        return myTournament.toString();
//    }
    @GetMapping(path = "/myRoundRobinTournament")
    public RoundRobin getMyRoundRobinTournament(){
        return myTournament;
    }

    @GetMapping("/")
    public List getRoundRobinTeams(@RequestParam("id") Long id){
        List tmp = new ArrayList();
        for(int i=0; i<myTournament.getTeams().size(); i++){
            tmp.add(myTournament.getTeams().get(i));
        }

        Collections.sort(tmp, new ParticipantComparator());
        Collections.reverse(tmp);
        System.out.println(tmp);
        return tmp;
    }
}
