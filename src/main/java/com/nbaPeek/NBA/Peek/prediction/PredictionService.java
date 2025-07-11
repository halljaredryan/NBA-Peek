package com.nbaPeek.NBA.Peek.prediction;

import com.nbaPeek.NBA.Peek.game.Game;
import com.nbaPeek.NBA.Peek.game.GameRepository;
import com.nbaPeek.NBA.Peek.player.Player;
import com.nbaPeek.NBA.Peek.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PredictionService {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private GameRepository gameRepository;
    
    public PredictionResponse predictGame(PredictionRequest request) {
        // Calculate team statistics from player data
        PredictionRequest.TeamStats homeStats = calculateTeamStats(request.getHomeTeam());
        PredictionRequest.TeamStats awayStats = calculateTeamStats(request.getAwayTeam());
        
        // Use a simple weighted scoring model for prediction
        double homeScore = calculateTeamScore(homeStats, true);
        double awayScore = calculateTeamScore(awayStats, false);
        
        // Calculate win probabilities
        double totalScore = homeScore + awayScore;
        double homeWinProbability = homeScore / totalScore;
        double awayWinProbability = awayScore / totalScore;
        
        // Determine winner
        String predictedWinner = homeWinProbability > awayWinProbability ? 
            request.getHomeTeam() : request.getAwayTeam();
        
        // Calculate confidence based on score difference
        double scoreDifference = Math.abs(homeScore - awayScore);
        double confidence = Math.min(0.95, 0.5 + (scoreDifference / 100.0));
        
        // Generate prediction reason
        String predictionReason = generatePredictionReason(homeStats, awayStats, 
                                                         homeWinProbability, awayWinProbability);
        
        // Create team comparison
        PredictionResponse.TeamComparison comparison = createTeamComparison(homeStats, awayStats);
        
        PredictionResponse response = new PredictionResponse(
            request.getHomeTeam(), request.getAwayTeam(), predictedWinner,
            homeWinProbability, awayWinProbability, confidence, predictionReason
        );
        response.setTeamComparison(comparison);
        
        return response;
    }
    
    private PredictionRequest.TeamStats calculateTeamStats(String teamCode) {
        List<Player> players = playerRepository.findByTEAM(teamCode);
        
        if (players.isEmpty()) {
            // Return default stats if no players found
            return new PredictionRequest.TeamStats(100.0, 40.0, 20.0, 8.0, 5.0, 110.0, 110.0, 82);
        }
        
        // Calculate averages
        double avgPpg = players.stream().mapToDouble(Player::getPpG).average().orElse(0.0);
        double avgRpg = players.stream().mapToDouble(Player::getRpG).average().orElse(0.0);
        double avgApg = players.stream().mapToDouble(Player::getApG).average().orElse(0.0);
        double avgSpg = players.stream().mapToDouble(Player::getSpG).average().orElse(0.0);
        double avgBpg = players.stream().mapToDouble(Player::getBpG).average().orElse(0.0);
        double avgOrtg = players.stream().mapToDouble(Player::getORtg).average().orElse(110.0);
        double avgDrtg = players.stream().mapToDouble(Player::getDRtg).average().orElse(110.0);
        int gamesPlayed = players.stream().mapToInt(Player::getGP).max().orElse(82);
        
        return new PredictionRequest.TeamStats(avgPpg, avgRpg, avgApg, avgSpg, avgBpg, avgOrtg, avgDrtg, gamesPlayed);
    }
    
    private double calculateTeamScore(PredictionRequest.TeamStats stats, boolean isHome) {
        // Weighted scoring model
        double offensiveScore = stats.getAvgPpg() * 0.3 + stats.getAvgOrtg() * 0.2;
        double defensiveScore = (120.0 - stats.getAvgDrtg()) * 0.2; // Lower DRtg is better
        double reboundingScore = stats.getAvgRpg() * 0.1;
        double playmakingScore = stats.getAvgApg() * 0.1;
        double defensivePlaysScore = (stats.getAvgSpg() + stats.getAvgBpg()) * 0.1;
        
        // Home court advantage
        double homeAdvantage = isHome ? 3.0 : 0.0;
        
        return offensiveScore + defensiveScore + reboundingScore + 
               playmakingScore + defensivePlaysScore + homeAdvantage;
    }
    
    private String generatePredictionReason(PredictionRequest.TeamStats homeStats, 
                                          PredictionRequest.TeamStats awayStats,
                                          double homeWinProb, double awayWinProb) {
        StringBuilder reason = new StringBuilder();
        
        if (homeWinProb > awayWinProb) {
            reason.append("Home team advantage with ");
        } else {
            reason.append("Away team strength with ");
        }
        
        // Compare key metrics
        if (homeStats.getAvgPpg() > awayStats.getAvgPpg()) {
            reason.append("superior offensive production, ");
        } else if (awayStats.getAvgPpg() > homeStats.getAvgPpg()) {
            reason.append("superior offensive production, ");
        }
        
        if (homeStats.getAvgOrtg() > awayStats.getAvgOrtg()) {
            reason.append("better offensive efficiency, ");
        } else if (awayStats.getAvgOrtg() > homeStats.getAvgOrtg()) {
            reason.append("better offensive efficiency, ");
        }
        
        if (homeStats.getAvgDrtg() < awayStats.getAvgDrtg()) {
            reason.append("stronger defense, ");
        } else if (awayStats.getAvgDrtg() < homeStats.getAvgDrtg()) {
            reason.append("stronger defense, ");
        }
        
        reason.append("and balanced team performance.");
        
        return reason.toString();
    }
    
    private PredictionResponse.TeamComparison createTeamComparison(PredictionRequest.TeamStats homeStats, 
                                                                  PredictionRequest.TeamStats awayStats) {
        String offensiveAdvantage = homeStats.getAvgPpg() > awayStats.getAvgPpg() ? 
            "Home" : "Away";
        
        String defensiveAdvantage = homeStats.getAvgDrtg() < awayStats.getAvgDrtg() ? 
            "Home" : "Away";
        
        String reboundingAdvantage = homeStats.getAvgRpg() > awayStats.getAvgRpg() ? 
            "Home" : "Away";
        
        String playmakingAdvantage = homeStats.getAvgApg() > awayStats.getAvgApg() ? 
            "Home" : "Away";
        
        String experienceAdvantage = homeStats.getGamesPlayed() > awayStats.getGamesPlayed() ? 
            "Home" : "Away";
        
        return new PredictionResponse.TeamComparison(
            offensiveAdvantage, defensiveAdvantage, reboundingAdvantage,
            playmakingAdvantage, experienceAdvantage
        );
    }
    
    public PredictionResponse predictGameWithTeamNames(String homeTeam, String awayTeam) {
        // Convert team names to team codes
        String homeTeamCode = convertTeamNameToCode(homeTeam);
        String awayTeamCode = convertTeamNameToCode(awayTeam);
        
        PredictionRequest request = new PredictionRequest(homeTeamCode, awayTeamCode, null, null);
        return predictGame(request);
    }
    
    private String convertTeamNameToCode(String teamName) {
        // Simple mapping - in a real app, you'd have a proper mapping table
        Map<String, String> teamMapping = Map.ofEntries(
            Map.entry("Cleveland Cavaliers", "Cle"),
            Map.entry("Los Angeles Lakers", "Lal"),
            Map.entry("Golden State Warriors", "Gol"),
            Map.entry("Boston Celtics", "Bos"),
            Map.entry("Milwaukee Bucks", "Mil"),
            Map.entry("Phoenix Suns", "Pho"),
            Map.entry("Denver Nuggets", "Den"),
            Map.entry("Miami Heat", "Mia"),
            Map.entry("Chicago Bulls", "Chi"),
            Map.entry("Sacramento Kings", "Sac"),
            Map.entry("Los Angeles Clippers", "Lac"),
            Map.entry("Philadelphia 76ers", "Phi"),
            Map.entry("Dallas Mavericks", "Dal"),
            Map.entry("Minnesota Timberwolves", "Min"),
            Map.entry("Houston Rockets", "Hou"),
            Map.entry("Atlanta Hawks", "Atl"),
            Map.entry("Orlando Magic", "Orl"),
            Map.entry("Indiana Pacers", "Ind"),
            Map.entry("Washington Wizards", "Was"),
            Map.entry("Charlotte Hornets", "Cha"),
            Map.entry("Toronto Raptors", "Tor"),
            Map.entry("Brooklyn Nets", "Bro"),
            Map.entry("New York Knicks", "Nyk"),
            Map.entry("Detroit Pistons", "Det"),
            Map.entry("Utah Jazz", "Uta"),
            Map.entry("Memphis Grizzlies", "Mem"),
            Map.entry("Portland Trail Blazers", "Por"),
            Map.entry("Oklahoma City Thunder", "Okc"),
            Map.entry("San Antonio Spurs", "San")
        );
        
        return teamMapping.getOrDefault(teamName, teamName);
    }
} 