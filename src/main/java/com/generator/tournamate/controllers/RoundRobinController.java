package com.generator.tournamate.controllers;

import com.generator.tournamate.RoundNotFoundException;
import com.generator.tournamate.RoundStillRunningException;
import com.generator.tournamate.entities.RoundRobin;
import com.generator.tournamate.entities.RoundRobinMatch;
import com.generator.tournamate.entities.RoundRobinRound;
import com.generator.tournamate.entities.RoundRobinTeam;
import com.generator.tournamate.services.RoundRobinRoundService;
import com.generator.tournamate.services.RoundRobinService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(path = "/RoundRobintournament")
public class RoundRobinController {
    RoundRobinRoundService roundRobinRoundService = new RoundRobinRoundService();
    RoundRobinService roundRobinService= new RoundRobinService();
    List<RoundRobinTeam> teams =new ArrayList<>();
    RoundRobin myTournament = null;
    @PostMapping(path = "/newRoundRobinTournament")
    public String generateTournament() throws RoundNotFoundException {
//        teams.add(new RoundRobinTeam("11"));
//        teams.add(new RoundRobinTeam("22"));
//        teams.add(new RoundRobinTeam("33"));
//        teams.add(new RoundRobinTeam("44"));

        myTournament = new RoundRobin(teams);
        myTournament.setRound(new LinkedList<>(teams));
        System.out.println(myTournament);
        return myTournament.toString();

    }
    @PostMapping(path = "/newRoundRobinRound")
    public String generateRound() throws RoundNotFoundException, RoundStillRunningException {
//        generateTournament();
//        myTournament.addRound(new RoundRobinRound(new LinkedList<>(teams),2,myTournament.getRound(1).getNumOfMatches()));
        RoundRobinRound newRound = RoundRobinService.generateNextRound(myTournament.getRound(myTournament.getCurrentRound()), myTournament.getTeams());

        myTournament.addRound(newRound);
        return myTournament.toString();
    }
    @PostMapping(path = "/setMatch")
    public String setMatch(@RequestParam("roundNumber") int roundNumber , @RequestParam("matchNumber") int matchNumber, @RequestParam("matchStatus") String matchStatus) throws RoundNotFoundException {
        if(myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).getMatchStatus().equals("NA")) {
            switch (matchStatus) {
                case "P1":
                    myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber-1).setMatchResult("p1");
                    break;
                case "P2":
                    myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber-1).setMatchResult("p2");
                    break;
                case "D":
                    myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber-1).setMatchResult("D");
                    break;
                default:
                    myTournament.getRound(roundNumber).getRoundMatches().get(matchNumber-1).setMatchResult("NA");
            }
        }
        return myTournament.toString();
    }
    @PostMapping(path = "/generateMatches")
    public String generateMatches() throws RoundNotFoundException {
        List<RoundRobinMatch> matchList = roundRobinRoundService.generateMatchList
                (new LinkedList<>(myTournament.getTeams()),myTournament.getCurrentRound()
                        ,myTournament.getRound(myTournament.getCurrentRound()).getNumOfMatches());
        myTournament.getRound(1).setTeams(new LinkedList<>(teams));
        return myTournament.toString();
    }
    @GetMapping(path = "/myRoundRobinTournament")
    public RoundRobin getMyRoundRobinTournament(){
        return myTournament;
    }

    @GetMapping("/teams")
    public List<RoundRobinTeam> test(){
//        teams.add(new RoundRobinTeam("hh"));
        return teams;
    }
}
