package com.nbaPeek.NBA.Peek.prediction;

import java.util.List;

public class PredictionRequest {
    private String homeTeam;
    private String awayTeam;
    private TeamStats homeTeamStats;
    private TeamStats awayTeamStats;
    
    public PredictionRequest() {}
    
    public PredictionRequest(String homeTeam, String awayTeam, TeamStats homeTeamStats, TeamStats awayTeamStats) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamStats = homeTeamStats;
        this.awayTeamStats = awayTeamStats;
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
    
    public TeamStats getHomeTeamStats() {
        return homeTeamStats;
    }
    
    public void setHomeTeamStats(TeamStats homeTeamStats) {
        this.homeTeamStats = homeTeamStats;
    }
    
    public TeamStats getAwayTeamStats() {
        return awayTeamStats;
    }
    
    public void setAwayTeamStats(TeamStats awayTeamStats) {
        this.awayTeamStats = awayTeamStats;
    }
    
    public static class TeamStats {
        private double avgPpg;
        private double avgRpg;
        private double avgApg;
        private double avgSpg;
        private double avgBpg;
        private double avgOrtg;
        private double avgDrtg;
        private int gamesPlayed;
        
        public TeamStats() {}
        
        public TeamStats(double avgPpg, double avgRpg, double avgApg, double avgSpg, 
                        double avgBpg, double avgOrtg, double avgDrtg, int gamesPlayed) {
            this.avgPpg = avgPpg;
            this.avgRpg = avgRpg;
            this.avgApg = avgApg;
            this.avgSpg = avgSpg;
            this.avgBpg = avgBpg;
            this.avgOrtg = avgOrtg;
            this.avgDrtg = avgDrtg;
            this.gamesPlayed = gamesPlayed;
        }
        
        // Getters and Setters
        public double getAvgPpg() {
            return avgPpg;
        }
        
        public void setAvgPpg(double avgPpg) {
            this.avgPpg = avgPpg;
        }
        
        public double getAvgRpg() {
            return avgRpg;
        }
        
        public void setAvgRpg(double avgRpg) {
            this.avgRpg = avgRpg;
        }
        
        public double getAvgApg() {
            return avgApg;
        }
        
        public void setAvgApg(double avgApg) {
            this.avgApg = avgApg;
        }
        
        public double getAvgSpg() {
            return avgSpg;
        }
        
        public void setAvgSpg(double avgSpg) {
            this.avgSpg = avgSpg;
        }
        
        public double getAvgBpg() {
            return avgBpg;
        }
        
        public void setAvgBpg(double avgBpg) {
            this.avgBpg = avgBpg;
        }
        
        public double getAvgOrtg() {
            return avgOrtg;
        }
        
        public void setAvgOrtg(double avgOrtg) {
            this.avgOrtg = avgOrtg;
        }
        
        public double getAvgDrtg() {
            return avgDrtg;
        }
        
        public void setAvgDrtg(double avgDrtg) {
            this.avgDrtg = avgDrtg;
        }
        
        public int getGamesPlayed() {
            return gamesPlayed;
        }
        
        public void setGamesPlayed(int gamesPlayed) {
            this.gamesPlayed = gamesPlayed;
        }
    }
} 