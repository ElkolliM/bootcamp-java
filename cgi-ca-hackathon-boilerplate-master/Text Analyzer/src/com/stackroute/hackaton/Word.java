package com.stackroute.hackaton;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import java.io.IOException;
import java.util.stream.Collectors;


public class Word {
    public static void main(String[] args) {
        String path = "data/daffodils.txt";

    }

    String dtailsWord;
    int occ_number_word = 0;

    public Word(String dtailsWord, int occ_number_word)  {
        this.dtailsWord = dtailsWord;
        this.occ_number_word = occ_number_word;
    }

    public String getDtailsWord() {
        return dtailsWord;
    }

    public int getOcc_number_word() {
        return occ_number_word;

    }


    public void setDtailsWord(String dtailsWord) {
        this.dtailsWord = dtailsWord;
    }

    public void setOcc_number_word(int occ_number_word) {
        this.occ_number_word = occ_number_word;
    }


    private static ArrayList<Word> wordList = new ArrayList<>();

    File file = new File("daffodils.txt");
    Word word = new Word(dtailsWord ,occ_number_word);
    Scanner sc = null;







    public static List<Word> getWords(String path) {
        List<Word> wordList = new ArrayList<>();

        try {
            List<String> words = Files.lines(Paths.get(path)).map(line -> line.split(" ")).flatMap(Arrays::stream)
                    .sorted((p1, p2) -> p1.compareTo(p2)).collect(Collectors.toList());

         //   Map< words, Integer> wordCounter = words.stream().collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));

        //    wordCounter.forEach((k, v) -> wordList.add(new Word((String) k, v)));
        }
        catch (IOException e) {
            System.out.println("occurs");
        }
        return wordList;
    }





}



