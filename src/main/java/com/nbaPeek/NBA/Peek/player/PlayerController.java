package com.nbaPeek.NBA.Peek.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController //domain object definer
@RequestMapping(path = "api/reg/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String TEAM,
        @RequestParam(required = false) String PNAME,
        @RequestParam(required = false) String POS) {
        
        if (TEAM != null){
            return playerService.getPlayersFromTeam(TEAM);
        } else if (POS != null) {
            return playerService.getPlayersByPosition(POS);
        } else if (PNAME != null) {
            return playerService.getPlayersByName(PNAME);
        } else {
            return playerService.getPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}
