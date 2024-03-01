package com.stackroute.fileio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicateLines {
    //write logic to read data from input.txt and  write result to output.txt
    public void removeDuplicateLines() throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);


        Set<String> stringSet = new HashSet<>();
        while (scanner.hasNextLine()){
            stringSet.add(scanner.nextLine());
        }

        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        for (String s : stringSet){
            bufferedOutputStream.write(s.getBytes());
            bufferedOutputStream.write("\n".getBytes());
            bufferedOutputStream.flush();
        }

        scanner.close();

    }
}
