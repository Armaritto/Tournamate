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

import java.util.*;

import static java.lang.Long.valueOf;

@CrossOrigin
@RestController
@RequestMapping(path = "/RoundRobintournament")
public class RoundRobinController {
    RoundRobinRoundService roundRobinRoundService = new RoundRobinRoundService();
    RoundRobinService roundRobinService= new RoundRobinService();
    //  List<RoundRobinTeam> teams =new ArrayList<>();
    RoundRobin tmpTournament = null;
    public static HashMap<Long, RoundRobin> AllRoundRobins = new HashMap<>();
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
        Long id = valueOf((long) (Math.random()*10000000));
        RoundRobin tmpTournament = null;

        tmpTournament = new RoundRobin(teams);
        tmpTournament.setRound(new LinkedList<>(teams));
        AllRoundRobins.put(id, tmpTournament);
        System.out.println(AllRoundRobins);
        return id;

    }
    @GetMapping(path = "/numOfRounds")
    public int numOfRounds(@RequestParam("id") Long id) {
        return AllRoundRobins.get(id).getNumberOfRounds();
    }

    @PostMapping(path = "/newRoundRobinRound")
    public List generateRound(@RequestParam("id") Long id) throws RoundNotFoundException, RoundStillRunningException {
//        generateTournament();
//        myTournament.addRound(new RoundRobinRound(new LinkedList<>(teams),2,myTournament.getRound(1).getNumOfMatches()));
        // RoundRobinRound newRound = RoundRobinService.generateNextRound(myTournament.getRound(myTournament.getCurrentRound()), myTournament.getTeams());
        int roundNumber = AllRoundRobins.get(id).getCurrentRound();
        AllRoundRobins.get(id).setCurrentRound(roundNumber+1);
        List<RoundRobinMatch> matchList = roundRobinRoundService.generateMatchList
                (new LinkedList<>(AllRoundRobins.get(id).getTeams()),roundNumber
                        ,AllRoundRobins.get(id).getRound(roundNumber).getNumOfMatches());
        AllRoundRobins.get(id).getRound(roundNumber).setRoundMatches(matchList);
        return matchList;
    }
    @PostMapping(path = "/setMatch")
    public String setMatch(@RequestParam("id") Long id, @RequestParam("roundNumber") int roundNumber , @RequestParam("matchNumber") int matchNumber, @RequestParam("matchStatus") String matchStatus) throws RoundNotFoundException {
        if(AllRoundRobins.get(id).getRound(roundNumber).getRoundMatches().get(matchNumber).getMatchStatus().equals("NA")) {
            switch (matchStatus) {
                case "P1":
                    AllRoundRobins.get(id).getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("P1");
                    break;
                case "P2":
                    AllRoundRobins.get(id).getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("P2");
                    break;
                case "D":
                    AllRoundRobins.get(id).getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("D");
                    break;
                default:
                    AllRoundRobins.get(id).getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("NA");
            }
        }
        return AllRoundRobins.get(id).toString();
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
    public RoundRobin getMyRoundRobinTournament(@RequestParam("id") Long id){
        return AllRoundRobins.get(id);
    }

    @GetMapping("/")
    public List getRoundRobinTeams(@RequestParam("id") Long id){
        List tmp = new ArrayList();
        for(int i=0; i<AllRoundRobins.get(id).getTeams().size(); i++){
            tmp.add(AllRoundRobins.get(id).getTeams().get(i));
        }

        Collections.sort(tmp, new ParticipantComparator());
        Collections.reverse(tmp);
        System.out.println(tmp);
        return tmp;
    }
}
