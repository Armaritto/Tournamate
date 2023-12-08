package com.generator.tournamate.controllers;

import com.generator.tournamate.*;
import com.generator.tournamate.services.SwissRoundService;
import com.generator.tournamate.services.SwissTournamentService;
import com.generator.tournamate.entities.SwissMatch;
import com.generator.tournamate.entities.SwissPlayer;
import com.generator.tournamate.entities.SwissRound;
import com.generator.tournamate.entities.SwissTournament;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/swiss")
public class SwissController {
    SwissRoundService swissRoundService = new SwissRoundService();
    SwissTournamentService swissTournamentService = new SwissTournamentService();
    List<SwissPlayer> swissPlayerList = Arrays.asList(

            new SwissPlayer("player1", 0),
            new SwissPlayer("player2", 0),
            new SwissPlayer("player3", 0),
            new SwissPlayer("player4", 0),
            new SwissPlayer("player5", 0),
            new SwissPlayer("player6", 0)
    );
    //SwissTournament SwissTournamentService.AllSwissTournaments.get(id) = null;
    @PostMapping(path = "/newSwissTournament")
    public Long generateTournament() throws RoundNotFoundException {
//        SwissTournamentService.AllSwissTournaments.get(id) = new SwissTournament(3, swissPlayerList);
//        SwissTournamentService.AllSwissTournaments.get(id).getRound(1).setPlayersList(swissPlayerList);
//        System.out.println(SwissTournamentService.AllSwissTournaments.get(id));
        return swissTournamentService.generateSwissTournament(3, swissPlayerList);

    }
    @PostMapping(path = "/newSwissRound")
    public String generateRound(@RequestParam("id") Long id) throws RoundNotFoundException, RoundStillRunningException {
        SwissRound newRound = swissTournamentService.generateNextRound(SwissTournamentService.AllSwissTournaments.get(id).getRound(SwissTournamentService.AllSwissTournaments.get(id).getCurrentRoundNumber()), SwissTournamentService.AllSwissTournaments.get(id).getPlayers());
        SwissTournamentService.AllSwissTournaments.get(id).addRound(newRound);
        return SwissTournamentService.AllSwissTournaments.get(id).toString();
    }
    @PostMapping(path = "/finishRound")
    public String finishRound(@RequestParam("id") Long id, @RequestParam("roundNumber") int roundNumber) throws RoundNotFoundException {
        SwissTournamentService.AllSwissTournaments.get(id).getRound(roundNumber).finishRound();
        return SwissTournamentService.AllSwissTournaments.get(id).toString();
    }

    @PostMapping(path = "/setMatch")
    public String setMatch(@RequestParam("id") Long id, @RequestParam("roundNumber") int roundNumber , @RequestParam("matchNumber") int matchNumber, @RequestParam("matchStatus") String matchStatus) throws RoundNotFoundException {
        if(SwissTournamentService.AllSwissTournaments.get(id).getRound(roundNumber).getMatchList().get(matchNumber).second.getMatchStatus().equals("NA")) {
            switch (matchStatus) {
                case "P1":
                    SwissTournamentService.AllSwissTournaments.get(id).getRound(roundNumber).getMatchList().get(matchNumber).second.setStatusP1();
                    break;
                case "P2":
                    SwissTournamentService.AllSwissTournaments.get(id).getRound(roundNumber).getMatchList().get(matchNumber).second.setStatusP2();
                    break;
                case "D":
                    SwissTournamentService.AllSwissTournaments.get(id).getRound(roundNumber).getMatchList().get(matchNumber).second.setStatusD();
                    break;
                default:
                    SwissTournamentService.AllSwissTournaments.get(id).getRound(roundNumber).getMatchList().get(matchNumber).second.setStatusNA();
            }
        }
        Collections.sort(SwissTournamentService.AllSwissTournaments.get(id).getPlayers(), new ParticipantComparator());
        Collections.reverse(SwissTournamentService.AllSwissTournaments.get(id).getPlayers());
        return SwissTournamentService.AllSwissTournaments.get(id).toString();
    }
    @PostMapping(path = "/generateMatches")
    public String generateMatches(@RequestParam("id") Long id) throws RoundNotFoundException {
        List<Pair<Integer, SwissMatch>> matchList = swissRoundService.generateMatchList(SwissTournamentService.AllSwissTournaments.get(id).getPlayers());
        SwissTournamentService.AllSwissTournaments.get(id).getRound(SwissTournamentService.AllSwissTournaments.get(id).getCurrentRoundNumber()).setMatchList(matchList);
        return SwissTournamentService.AllSwissTournaments.get(id).toString();
    }
//    @GetMapping(path = "/")
//    public SwissTournament getSwissTournamentService.AllSwissTournaments.get(id)(@RequestParam("id") Long id){
//        return SwissTournamentService.AllSwissTournaments.get(id);
//    }

    @GetMapping
    public List<SwissPlayer> test(){
        return swissPlayerList;
    }
}