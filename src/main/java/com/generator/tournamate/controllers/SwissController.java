package com.generator.tournamate.controllers;

import com.generator.tournamate.*;
import com.generator.tournamate.entities.SwissMatch;
import com.generator.tournamate.entities.SwissPlayer;
import com.generator.tournamate.entities.SwissRound;
import com.generator.tournamate.entities.SwissTournament;
import com.generator.tournamate.services.SwissRoundService;
import com.generator.tournamate.services.SwissTournamentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/swiss")
public class SwissController {
    SwissRoundService swissRoundService = new SwissRoundService();
    SwissTournamentService swissTournamentService = new SwissTournamentService();
    List<SwissPlayer> swissPlayerList =List.of(new SwissPlayer("player0",0 ),
            new SwissPlayer( "player1", 0),
            new SwissPlayer( "player2", 0),
            new SwissPlayer("player3", 0)
         );
    SwissTournament mySwissTournament = null;
    @PostMapping(path = "/newSwissTournament")
    public String generateTournament() throws RoundNotFoundException {
        mySwissTournament = new SwissTournament(3, swissPlayerList);
        mySwissTournament.getRound(1).setPlayersList(swissPlayerList);
        System.out.println(mySwissTournament);
        return mySwissTournament.toString();

    }
    @PostMapping(path = "/newSwissRound")
    public String generateRound() throws RoundNotFoundException, RoundStillRunningException {
        SwissRound newRound = swissTournamentService.generateNextRound(mySwissTournament.getRound(mySwissTournament.getCurrentRoundNumber()), mySwissTournament.getPlayers());
        mySwissTournament.addRound(newRound);
        return mySwissTournament.toString();
    }
    @PostMapping(path = "/setMatch")
    public String setMatch(@RequestParam("roundNumber") int roundNumber , @RequestParam("matchNumber") int matchNumber, @RequestParam("matchStatus") String matchStatus) throws RoundNotFoundException {
        if(mySwissTournament.getRound(roundNumber).getMatchList().get(matchNumber).second.getMatchStatus().equals("NA")) {
            switch (matchStatus) {
                case "P1":
                    mySwissTournament.getRound(roundNumber).getMatchList().get(matchNumber).second.setStatusP1();
                    break;
                case "P2":
                    mySwissTournament.getRound(roundNumber).getMatchList().get(matchNumber).second.setStatusP2();
                    break;
                case "D":
                    mySwissTournament.getRound(roundNumber).getMatchList().get(matchNumber).second.setStatusD();
                    break;
                default:
                    mySwissTournament.getRound(roundNumber).getMatchList().get(matchNumber).second.setStatusNA();
            }
        }
        return mySwissTournament.toString();
    }
    @PostMapping(path = "/generateMatches")
    public String generateMatches() throws RoundNotFoundException {
        List<Pair<Integer, SwissMatch>> matchList = swissRoundService.generateMatchList(mySwissTournament.getPlayers());
        mySwissTournament.getRound(1).setMatchList(matchList);
        return mySwissTournament.toString();
    }
    @GetMapping(path = "/mySwissTournament")
    public SwissTournament getMySwissTournament(){
        return mySwissTournament;
    }

    @GetMapping
    public List<SwissPlayer> test(){
        return swissPlayerList;
    }
}