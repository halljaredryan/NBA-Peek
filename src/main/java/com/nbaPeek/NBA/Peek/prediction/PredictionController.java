package com.nbaPeek.NBA.Peek.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/predictions")
@CrossOrigin(origins = "*")
public class PredictionController {
    
    @Autowired
    private PredictionService predictionService;
    
    @PostMapping("/predict")
    public ResponseEntity<PredictionResponse> predictGame(@RequestBody PredictionRequest request) {
        try {
            PredictionResponse response = predictionService.predictGame(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/predict")
    public ResponseEntity<PredictionResponse> predictGameWithParams(
            @RequestParam String homeTeam,
            @RequestParam String awayTeam) {
        try {
            PredictionResponse response = predictionService.predictGameWithTeamNames(homeTeam, awayTeam);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/teams")
    public ResponseEntity<Map<String, String>> getAvailableTeams() {
        Map<String, String> teams = Map.ofEntries(
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
        
        return ResponseEntity.ok(teams);
    }
    
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        return ResponseEntity.ok(Map.of("status", "healthy", "service", "NBA Prediction Service"));
    }
} 