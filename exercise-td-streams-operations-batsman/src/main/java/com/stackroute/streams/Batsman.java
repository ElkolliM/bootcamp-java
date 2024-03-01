package com.stackroute.streams;


public class Batsman {


    private String name;
    private int matchesPlayed;
    private int totalRuns;
    private int highestScore;
    private Country country;

    public Batsman() {
    }

    public Batsman(String name, int matchesPlayed,int totalRuns , int highestScore, Country country) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.totalRuns = totalRuns;
        this.highestScore = highestScore;
        this.country = country;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setTotalRuns (int totalRuns){
        this.totalRuns=totalRuns;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public Country getCountry() {
        return country;
    }






}
