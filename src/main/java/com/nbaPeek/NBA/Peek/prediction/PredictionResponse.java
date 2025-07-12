package com.nbaPeek.NBA.Peek.prediction;

public class PredictionResponse {
    private String homeTeam;
    private String awayTeam;
    private String predictedWinner;
    private double homeWinProbability;
    private double awayWinProbability;
    private double confidence;
    private String predictionReason;
    private TeamComparison teamComparison;
    
    public PredictionResponse() {}
    
    public PredictionResponse(String homeTeam, String awayTeam, String predictedWinner, 
                            double homeWinProbability, double awayWinProbability, 
                            double confidence, String predictionReason) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.predictedWinner = predictedWinner;
        this.homeWinProbability = homeWinProbability;
        this.awayWinProbability = awayWinProbability;
        this.confidence = confidence;
        this.predictionReason = predictionReason;
    }
    
    // Getters and Setters
    public String getHomeTeam() {
        return homeTeam;
    }
    
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    
    public String getAwayTeam() {
        return awayTeam;
    }
    
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
    
    public String getPredictedWinner() {
        return predictedWinner;
    }
    
    public void setPredictedWinner(String predictedWinner) {
        this.predictedWinner = predictedWinner;
    }
    
    public double getHomeWinProbability() {
        return homeWinProbability;
    }
    
    public void setHomeWinProbability(double homeWinProbability) {
        this.homeWinProbability = homeWinProbability;
    }
    
    public double getAwayWinProbability() {
        return awayWinProbability;
    }
    
    public void setAwayWinProbability(double awayWinProbability) {
        this.awayWinProbability = awayWinProbability;
    }
    
    public double getConfidence() {
        return confidence;
    }
    
    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
    
    public String getPredictionReason() {
        return predictionReason;
    }
    
    public void setPredictionReason(String predictionReason) {
        this.predictionReason = predictionReason;
    }
    
    public TeamComparison getTeamComparison() {
        return teamComparison;
    }
    
    public void setTeamComparison(TeamComparison teamComparison) {
        this.teamComparison = teamComparison;
    }
    
    public static class TeamComparison {
        private String offensiveAdvantage;
        private String defensiveAdvantage;
        private String reboundingAdvantage;
        private String playmakingAdvantage;
        private String experienceAdvantage;
        
        public TeamComparison() {}
        
        public TeamComparison(String offensiveAdvantage, String defensiveAdvantage, 
                            String reboundingAdvantage, String playmakingAdvantage, 
                            String experienceAdvantage) {
            this.offensiveAdvantage = offensiveAdvantage;
            this.defensiveAdvantage = defensiveAdvantage;
            this.reboundingAdvantage = reboundingAdvantage;
            this.playmakingAdvantage = playmakingAdvantage;
            this.experienceAdvantage = experienceAdvantage;
        }
        
        // Getters and Setters
        public String getOffensiveAdvantage() {
            return offensiveAdvantage;
        }
        
        public void setOffensiveAdvantage(String offensiveAdvantage) {
            this.offensiveAdvantage = offensiveAdvantage;
        }
        
        public String getDefensiveAdvantage() {
            return defensiveAdvantage;
        }
        
        public void setDefensiveAdvantage(String defensiveAdvantage) {
            this.defensiveAdvantage = defensiveAdvantage;
        }
        
        public String getReboundingAdvantage() {
            return reboundingAdvantage;
        }
        
        public void setReboundingAdvantage(String reboundingAdvantage) {
            this.reboundingAdvantage = reboundingAdvantage;
        }
        
        public String getPlaymakingAdvantage() {
            return playmakingAdvantage;
        }
        
        public void setPlaymakingAdvantage(String playmakingAdvantage) {
            this.playmakingAdvantage = playmakingAdvantage;
        }
        
        public String getExperienceAdvantage() {
            return experienceAdvantage;
        }
        
        public void setExperienceAdvantage(String experienceAdvantage) {
            this.experienceAdvantage = experienceAdvantage;
        }
    }
} 