package com.stackroute.streams;

import java.util.*;
import java.util.stream.Collectors;

public class BatsmanService {

    public Optional<Batsman> getBatsman(List <Batsman> bastmanList , String name, String countryCode) {
        if (bastmanList== null || name ==null || countryCode==null) return Optional.empty();
        if (bastmanList.stream().distinct()
                .filter(batsman -> batsman.getCountry().getCountryCode().equalsIgnoreCase(countryCode)).count() == 0) {
            throw new CountryNotFoundException();

        } else{
            Optional<Batsman> batsman;
            batsman = (bastmanList.stream().distinct().filter(batsman1 -> batsman1.getName().equalsIgnoreCase(name)
                                                           &&batsman1.getCountry().getCountryCode().equalsIgnoreCase(countryCode))
                    .findFirst());
            if (batsman.isPresent())return batsman;
        }
        return Optional.empty();

    }


    public Map<String ,Integer> getPlayerNameWithTotalRuns(List<Batsman> batsmanList){
        if (batsmanList == null || batsmanList.isEmpty())return Collections.emptyMap();
        Map<String ,Integer> filterMap = new TreeMap<>();
        List<Batsman> batsmen = batsmanList.stream()
                .filter(batsman -> batsman.getMatchesPlayed()>=50).collect(Collectors.toList());

        for (Batsman batsman: batsmen) filterMap.put(batsman.getName(),batsman.getTotalRuns());
        return filterMap;

    }


    public Optional<LinkedList<String>> getPlayerNamesByCountry(List<Batsman> batsmanList, String countryName){
        if ( batsmanList == null || batsmanList.isEmpty() || countryName==null) return Optional.empty();
        LinkedList<String> filtreList;
        filtreList =  batsmanList.stream().parallel()
                .filter(batsman -> batsman.getCountry().getName().equalsIgnoreCase(countryName)
                        && batsman.getTotalRuns()>=5000)
                .map(Batsman::getName)
                .collect(
                        LinkedList::new,
                        LinkedList::add,
                        LinkedList::addAll);


        if (filtreList.isEmpty())return Optional.empty();
        filtreList.sort((String s1 ,String s2)-> s2.compareTo(s1));
        return Optional.of(filtreList);

    }


    public String getBatsmanNamesForCountry(List<Batsman> batsmanList , String code ){
        if (batsmanList == null || code == null || batsmanList.isEmpty()) return null;
        List<String> filtredList = batsmanList.stream()
                .filter(batsman -> batsman.getCountry().getCountryCode().equalsIgnoreCase(code))
                .map(Batsman::getName).sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        StringBuilder result = new StringBuilder("[");
        for (String name :filtredList) result.append(name).append(',');
        return result.substring(0,result.length()-1) +']';
    }


    public int getHighestRunsScoredByBatsman (List<Batsman> batsmanList , String countryName) {

        if (batsmanList == null || batsmanList.isEmpty()) return 0;
        return batsmanList.stream().filter(batsman -> batsman.getCountry().getName().equalsIgnoreCase(countryName))
                .max(Comparator.comparingInt(Batsman::getHighestScore))
                .get().getHighestScore();
    }

}
