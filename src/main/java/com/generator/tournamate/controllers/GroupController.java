package com.generator.tournamate.controllers;

import com.generator.tournamate.RoundNotFoundException;
import com.generator.tournamate.RoundStillRunningException;
import com.generator.tournamate.entities.*;
import com.generator.tournamate.services.RoundRobinRoundService;
import com.generator.tournamate.services.RoundRobinService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Long.valueOf;

@CrossOrigin
@RestController
@RequestMapping(path = "/group")
public class GroupController {
    RoundRobinRoundService roundRobinRoundService = new RoundRobinRoundService();
    RoundRobinService roundRobinService= new RoundRobinService();
    GroupTournament myTournament = null;
    @PostMapping(path = "/newRoundRobinTournament")
    public Long generateTournament(@RequestParam("name") String name, @RequestParam("numOfRound") int numOfRounds, @RequestParam("list") List list,  @RequestParam("n") int numOfGroups) throws RoundNotFoundException {

        myTournament = new GroupTournament(name, numOfGroups, list);
        for(int i=0; i<numOfGroups; i++){
            myTournament.getSubTournaments().add(new RoundRobin(new ArrayList<RoundRobinTeam>()));
        }
      //  List<RoundRobinTeam> teams =new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            myTournament.getSubTournaments().get(i%numOfGroups).getTeams().add(new RoundRobinTeam(list.get(i).toString()));
        }

        return 13L;

    }

    @PostMapping(path = "/newGroupRound")
    public List generateRound(@RequestParam("id") Long id, @RequestParam("groupNumber") int groupNumber) throws RoundNotFoundException, RoundStillRunningException {
//        generateTournament();
//        myTournament.addRound(new RoundRobinRound(new LinkedList<>(teams),2,myTournament.getRound(1).getNumOfMatches()));
        RoundRobin subTournament = myTournament.getSubTournaments().get(groupNumber);
        int roundNumber = subTournament.getCurrentRound();
        subTournament.setCurrentRound(roundNumber+1);
        List<RoundRobinMatch> matchList = roundRobinRoundService.generateMatchList
                (new LinkedList<>(subTournament.getTeams()),roundNumber
                        ,subTournament.getRound(roundNumber).getNumOfMatches());
        subTournament.getRound(roundNumber).setRoundMatches(matchList);
        return matchList;
    }
    @PostMapping(path = "/setMatch")
    public String setMatch(@RequestParam("id") Long id, @RequestParam("roundNumber") int roundNumber , @RequestParam("matchNumber") int matchNumber, @RequestParam("matchStatus") String matchStatus, @RequestParam("groupNumber") int groupNumber) throws RoundNotFoundException {
        RoundRobin subTournament = myTournament.getSubTournaments().get(groupNumber);
        if(subTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).getMatchStatus().equals("NA")) {
            switch (matchStatus) {
                case "P1":
                    subTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("P1");
                    break;
                case "P2":
                    subTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("P2");
                    break;
                case "D":
                    subTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("D");
                    break;
                default:
                    subTournament.getRound(roundNumber).getRoundMatches().get(matchNumber).setMatchResult("NA");
            }
        }
        return myTournament.toString();
    }

    @GetMapping(path = "/myGroupTournament")
    public GroupTournament getMyGroupTournament(){
        return myTournament;
    }

    @GetMapping("/")
    public List getGroupTeams(@RequestParam("id") Long id){
        return myTournament.getTeams();
    }
}
