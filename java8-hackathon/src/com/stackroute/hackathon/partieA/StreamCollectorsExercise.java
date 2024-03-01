package com.stackroute.hackathon.partieA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExercise {

    public static void main(String[] args) {
        Country America = new Country("USA", "America");
        Country Algeria = new Country("ALG", "Algeria");
        Country Maldive = new Country("ML", "Maldive");


        Player player1 = new Player("depp", 103, 999, 120, America);
        Player player2 = new Player("oli", 100, 559, 820, Algeria);
        Player player3 = new Player("mari", 200, 222, 80, Maldive);

        List<Player> players = Arrays.asList(player1, player2, player3);


        System.out.println("1- Display the names of all players.");
        displayPlayers(players);
        System.out.println("2- Display the name of players whose highest score .");
        displayPlayersForCountry(players, "America");


        System.out.println("3- List of all Players, whose have scored more than 5000 runs ");
        LinkedList<String> linkedList = getPlayerNames(players);
        linkedList.stream().forEach(element -> System.out.println("Player: " + element.toString()));


        System.out.println("4-the average runs scored by players from a particular Country ");
        Map<Object, Double> averageList = getAverageRunsPlayersByCountry(players, "Algeria");
        System.out.println("the average Runs by players is = " + averageList);


        List<Player> list = getPlayerSortedList(players);
        list.stream().forEach(p -> System.out
                .println("Player name: " + p.getPlayerName() + " country: " + p.getCountry().getCountryName() + " matchesPlayed: " + p.getMatchesPlayed()));


        findPlayer(players, "oli", "Algeria");
    }


    static void displayPlayers(List<Player> players) {
        players.stream().forEach(p -> System.out.println("Player name has scored maximum runs is: " + p.getPlayerName()));
    }

    static void displayPlayersForCountry(List<Player> players, String country) {
        players.stream().filter(p -> p.getCountry().getCountryName().toUpperCase().equals(country.toUpperCase()))
                .filter(p -> p.getHighestScore() > 100).forEach(p -> System.out.println("Player name: " + p.getPlayerName()));
    }

    static LinkedList<String> getPlayerNames(List<Player> players) {
        return players.stream().filter(p -> p.getRuns() > 5000).map(Player::getPlayerName).sorted().collect(Collectors.toCollection(LinkedList::new));
    }

    static Map<Object, Double> getAverageRunsPlayersByCountry(List<Player> players, String country) {
        return players.stream().filter(p -> p.getCountry().getCountryName().toUpperCase().equals(country.toUpperCase()))
                .collect(Collectors.groupingBy(p -> p.getPlayerName(), Collectors.averagingInt(Player::getRuns)));
    }

    static List<Player> getPlayerSortedList(List<Player> players) {
        return players.stream().sorted(Comparator.comparing(Player::getPlayerName).reversed())
                .sorted(Comparator.comparingInt(Player::getMatchesPlayed).reversed()).collect(Collectors.toList());
    }

    static void findPlayer(List<Player> players, String name, String country) {
        players.stream().filter(p -> p.getPlayerName().toUpperCase().equals(name.toUpperCase()))
                .filter(p -> p.getCountry().getCountryName().toUpperCase().equals(country.toUpperCase())).filter(p -> p.getMatchesPlayed() > 200)
                .forEach(p -> System.out.println("Player name: " + p.getPlayerName() + "  country: " + p.getCountry().getCountryName()));
    }
}