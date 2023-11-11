package com.RoundRobin.controllers;

import com.RoundRobin.RoundNotFoundException;
import com.RoundRobin.RoundStillRunningException;
import com.RoundRobin.entities.RoundRobin;
import com.RoundRobin.entities.RoundRobinMatch;
import com.RoundRobin.entities.RoundRobinRound;
import com.RoundRobin.entities.RoundRobinTeam;
import com.RoundRobin.services.RoundRobinRoundService;
import com.RoundRobin.services.RoundRobinService;
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