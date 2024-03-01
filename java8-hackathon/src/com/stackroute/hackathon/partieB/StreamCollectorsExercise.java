package com.stackroute.hackathon.partieB;

import com.stackroute.hackathon.partieA.Player;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCollectorsExercise {
    private List<Player> player;


    public List<Player> getListOfPlayers() {
        List<Player> listOfPlayers = new ArrayList<Player>();
        listOfPlayers = player;
        return listOfPlayers;
    }

    public Optional<Player> getPlayersByCountry (List<Player> listOfPlayers , String countryId) {
        if (listOfPlayers == null || countryId == null) return Optional.empty();
        if (listOfPlayers.stream().distinct()
                .filter(player -> player.getCountry().getCountryId().equalsIgnoreCase(countryId))
                .collect(Collectors.toList()).isEmpty()) {
            throw new RuntimeException();

        } else {
            Optional<Player> player;
            player = (listOfPlayers.stream().distinct().filter(player1 -> player1.getCountry().getCountryId().equalsIgnoreCase(countryId))
                    .findFirst());
            if (player.isPresent()) return player;
        }
        return Optional.empty();
    }


    public Map<String,Integer> getPlayerNamesByCountry (List<Player> playerList, String countryId){
        if ( playerList == null || playerList.isEmpty() || countryId==null) return Collections.emptyMap();
        Map <String,Integer> filterMap = new TreeMap<>();
        List<Player> players = playerList.stream()
                .filter(player1 -> player1.getMatchesPlayed()>=50).collect(Collectors.toList());

        for (Player player: players) filterMap.put(player.getCountry().getCountryId(), player.getMatchesPlayed());

        return filterMap;

    }

    public Map<String, Integer> getTotalPlayersByCountry (List<Player> playerList , String countryNames){

        Map <String,Integer> totalplayers = new TreeMap<>();
        List<Player> players = playerList.stream()
                .filter(player1 -> player1.getCountry().getCountryName().equalsIgnoreCase(countryNames)).collect(Collectors.toList());

        for (Player player: players)
            totalplayers.put(player.getCountry().getCountryId(), totalplayers.values().stream().mapToInt(i->i).sum());
        LinkedHashMap <String,Integer> result = (LinkedHashMap<String, Integer>) totalplayers;
        return result;


    }


    public Map<String, Integer> getMaxScoreByCountry (List<Player>player , String countryName){
        if (player == null || player.isEmpty()) return Collections.emptyMap();
        Map <String,Integer> totalplayers = new TreeMap<>();

        player.stream().filter(player1 -> player1.getCountry().getCountryName().equalsIgnoreCase(countryName))
                .max(Comparator.comparing(Player::getHighestScore))
                .get().getHighestScore();
        for (Player players: player)
            totalplayers.put(players.getCountry().getCountryName(), players.getHighestScore());
        return totalplayers;

    }



    public Map<String,Integer> getPlayerNamesStringByCountry(List <Player> player , String countryName ){

        if ( player == null || player.isEmpty() || countryName==null) return Collections.emptyMap();
        Map <String,Integer> result1 = new TreeMap<>();

        result1 = (Map<String, Integer>) player.stream().filter(player1 -> player1.getCountry().getCountryName().equalsIgnoreCase(countryName))
                .map(Player::getPlayerName).collect(Collectors.toList());

        return result1;


    }






}
