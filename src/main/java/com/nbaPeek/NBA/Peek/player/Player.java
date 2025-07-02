package com.nbaPeek.NBA.Peek.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="regularszn")
public class Player {

    @Id
    @Column(name = "PNAME", unique = false)
    private String PNAME;
    private String TEAM;
    private char CUR;
    private String POS;
    private double AGE;
    private int GP;
    private double MpG;
    private double USG;
    private double TOV;
    private int FTA;
    private double FT;
    private int TwoPA;
    private double TwoP;
    private int ThreePA;
    private double ThreeP;
    private double eFG;
    private double TS;
    private double PpG;
    private double RpG;
    private double ApG;
    private double SpG;
    private double BpG;
    private double TOpG;
    private double PPlusR;
    private double PPlusA;
    private double PPlusRPlusA;
    private double VI;
    private double ORtg;
    private double DRtg;

    public Player() {}

    public Player(String PNAME, String TEAM, char CUR, String POS, double AGE, int GP, double MpG, double USG, double TOV, int FTA, double FT, int TwoPA, double TwoP, int ThreePA, double ThreeP, double eFG, double TS, double PpG, double RpG, double ApG, double SpG, double BpG, double TOpG, double PPlusR, double PPlusA, double PPlusRPlusA, double VI, double ORtg, double DRtg) {
        this.PNAME = PNAME;
        this.TEAM = TEAM;
        this.CUR = CUR;
        this.POS = POS;
        this.AGE = AGE;
        this.GP = GP;
        this.MpG = MpG;
        this.USG = USG;
        this.TOV = TOV;
        this.FTA = FTA;
        this.FT = FT;
        this.TwoPA = TwoPA;
        this.TwoP = TwoP;
        this.ThreePA = ThreePA;
        this.ThreeP = ThreeP;
        this.eFG = eFG;
        this.TS = TS;
        this.PpG = PpG;
        this.RpG = RpG;
        this.ApG = ApG;
        this.SpG = SpG;
        this.BpG = BpG;
        this.TOpG = TOpG;
        this.PPlusR = PPlusR;
        this.PPlusA = PPlusA;
        this.PPlusRPlusA = PPlusRPlusA;
        this.VI = VI;
        this.ORtg = ORtg;
        this.DRtg = DRtg;
    }

    public String getPNAME() {
        return this.PNAME;
    }

    public void setPNAME(String PNAME) {
        this.PNAME = PNAME;
    }

    public String getTEAM() {
        return this.TEAM;
    }

    public void setTEAM(String TEAM) {
        this.TEAM = TEAM;
    }

    public char getCUR() {
        return this.CUR;
    }

    public void setCUR(char CUR) {
        this.CUR = CUR;
    }

    public String getPOS() {
        return this.POS;
    }

    public void setPOS(String POS) {
        this.POS = POS;
    }

    public double getAGE() {
        return this.AGE;
    }

    public void setAGE(double AGE) {
        this.AGE = AGE;
    }

    public int getGP() {
        return this.GP;
    }

    public void setGP(int GP) {
        this.GP = GP;
    }

    public double getMpG() {
        return this.MpG;
    }

    public void setMpG(double MpG) {
        this.MpG = MpG;
    }

    public double getUSG() {
        return this.USG;
    }

    public void setUSG(double USG) {
        this.USG = USG;
    }

    public double getTOV() {
        return this.TOV;
    }

    public void setTOV(double TOV) {
        this.TOV = TOV;
    }

    public int getFTA() {
        return this.FTA;
    }

    public void setFTA(int FTA) {
        this.FTA = FTA;
    }

    public double getFT() {
        return this.FT;
    }

    public void setFT(double FT) {
        this.FT = FT;
    }

    public int getTwoPA() {
        return this.TwoPA;
    }

    public void setTwoPA(int TwoPA) {
        this.TwoPA = TwoPA;
    }

    public double getTwoP() {
        return this.TwoP;
    }

    public void setTwoP(double TwoP) {
        this.TwoP = TwoP;
    }

    public int getThreePA() {
        return this.ThreePA;
    }

    public void setThreePA(int ThreePA) {
        this.ThreePA = ThreePA;
    }

    public double getThreeP() {
        return this.ThreeP;
    }

    public void setThreeP(double ThreeP) {
        this.ThreeP = ThreeP;
    }

    public double getEFG() {
        return this.eFG;
    }

    public void setEFG(double eFG) {
        this.eFG = eFG;
    }

    public double getTS() {
        return this.TS;
    }

    public void setTS(double TS) {
        this.TS = TS;
    }

    public double getPpG() {
        return this.PpG;
    }

    public void setPpG(double PpG) {
        this.PpG = PpG;
    }

    public double getRpG() {
        return this.RpG;
    }

    public void setRpG(double RpG) {
        this.RpG = RpG;
    }

    public double getApG() {
        return this.ApG;
    }

    public void setApG(double ApG) {
        this.ApG = ApG;
    }

    public double getSpG() {
        return this.SpG;
    }

    public void setSpG(double SpG) {
        this.SpG = SpG;
    }

    public double getBpG() {
        return this.BpG;
    }

    public void setBpG(double BpG) {
        this.BpG = BpG;
    }

    public double getTOpG() {
        return this.TOpG;
    }

    public void setTOpG(double TOpG) {
        this.TOpG = TOpG;
    }

    public double getPPlusR() {
        return this.PPlusR;
    }

    public void setPPlusR(double PPlusR) {
        this.PPlusR = PPlusR;
    }

    public double getPPlusA() {
        return this.PPlusA;
    }

    public void setPPlusA(double PPlusA) {
        this.PPlusA = PPlusA;
    }

    public double getPPlusRPlusA() {
        return this.PPlusRPlusA;
    }

    public void setPPlusRPlusA(double PPlusRPlusA) {
        this.PPlusRPlusA = PPlusRPlusA;
    }

    public double getVI() {
        return this.VI;
    }

    public void setVI(double VI) {
        this.VI = VI;
    }

    public double getORtg() {
        return this.ORtg;
    }

    public void setORtg(double ORtg) {
        this.ORtg = ORtg;
    }

    public double getDRtg() {
        return this.DRtg;
    }

    public void setDRtg(double DRtg) {
        this.DRtg = DRtg;
    }
        
}

