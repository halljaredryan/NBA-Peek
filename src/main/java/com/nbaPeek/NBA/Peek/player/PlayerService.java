package com.nbaPeek.NBA.Peek.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    // Get players sorted by name
    public List<Player> getPlayersSortedByName(){
        return playerRepository.findAll().stream()
        .sorted(Comparator.comparing(Player::getPNAME))
        .collect(Collectors.toList());
    }

    // Get players sorted by team, then by name
    public List<Player> getPlayersSortedByTeamAndName(){
        return playerRepository.findAll().stream()
        .sorted(Comparator.comparing(Player::getTEAM).thenComparing(Player::getPNAME))
        .collect(Collectors.toList());
    }

    // Get players sorted by position, then by name
    public List<Player> getPlayersSortedByPositionAndName(){
        return playerRepository.findAll().stream()
        .sorted(Comparator.comparing(Player::getPOS).thenComparing(Player::getPNAME))
        .collect(Collectors.toList());
    }

    // Get players sorted by age (youngest first)
    public List<Player> getPlayersSortedByAge(){
        return playerRepository.findAll().stream()
        .sorted(Comparator.comparing(Player::getAGE))
        .collect(Collectors.toList());
    }

    // Get players sorted by points per game (highest first)
    public List<Player> getPlayersSortedByPointsPerGame(){
        return playerRepository.findAll().stream()
        .sorted(Comparator.comparing(Player::getPpG).reversed())
        .collect(Collectors.toList());
    }

    // Get players sorted by multiple criteria: team, position, name
    public List<Player> getPlayersSortedByTeamPositionName(){
        return playerRepository.findAll().stream()
        .sorted(Comparator.comparing(Player::getTEAM)
                .thenComparing(Player::getPOS)
                .thenComparing(Player::getPNAME))
        .collect(Collectors.toList());
    }

    public List<Player> getPlayersFromTeam(String teamName){
        return playerRepository.findAll().stream()
        .filter(player -> teamName.equals(player.getTEAM().toLowerCase()))
        .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findAll().stream()
        .filter(player -> player.getPNAME().toLowerCase()
        .contains(searchText.toLowerCase()))
        .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String searchText){
        return playerRepository.findAll().stream()
        .filter(player -> player.getPOS().toLowerCase()
        .contains(searchText.toLowerCase()))
        .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    @Transactional
    public void deletePlayer(String playerName){
        playerRepository.deleteByPNAME(playerName);
    }
}
