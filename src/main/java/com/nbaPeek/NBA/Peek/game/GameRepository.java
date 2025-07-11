package com.nbaPeek.NBA.Peek.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    
    List<Game> findByHomeTeamAndAwayTeam(String homeTeam, String awayTeam);
    
    List<Game> findByHomeTeam(String homeTeam);
    
    List<Game> findByAwayTeam(String awayTeam);
    
    List<Game> findByGameDateBetween(LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT g FROM Game g WHERE g.homeTeam = :team OR g.awayTeam = :team ORDER BY g.gameDate DESC")
    List<Game> findRecentGamesByTeam(@Param("team") String team);
    
    @Query("SELECT COUNT(g) FROM Game g WHERE g.homeTeam = :team AND g.homeWin = true")
    long countHomeWinsByTeam(@Param("team") String team);
    
    @Query("SELECT COUNT(g) FROM Game g WHERE g.awayTeam = :team AND g.homeWin = false")
    long countAwayWinsByTeam(@Param("team") String team);
    
    @Query("SELECT COUNT(g) FROM Game g WHERE (g.homeTeam = :team OR g.awayTeam = :team)")
    long countTotalGamesByTeam(@Param("team") String team);
} 