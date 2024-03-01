package com.stackroute.hackathon.partieB;

import com.stackroute.hackathon.partieA.Country;

public class Player {
    private String playerName;
    private int matchesPlayed;
    private int runs;
    private int highestScore;
    private Country country;

    public Player(String playerName, int matchesPlayed, int runs, int highestScore, Country country) {
        this.playerName = playerName;
        this.matchesPlayed = matchesPlayed;
        this.runs = runs;
        this.highestScore = highestScore;
        this.country = country;
    }

    public Player(){

    }


    public String getPlayerName() {
        return playerName;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getRuns() {
        return runs;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public Country getCountry() {
        return country;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


}
