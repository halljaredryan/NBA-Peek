package com.nbaPeek.NBA.Peek.player;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface PlayerRepository extends JpaRepository<Player, String> {//provides CROD ops for player entity with type and pkey
    void deleteByName(String playerName);

    Optional<List<Player>> findByPNAME(String pNAME);

    
}
