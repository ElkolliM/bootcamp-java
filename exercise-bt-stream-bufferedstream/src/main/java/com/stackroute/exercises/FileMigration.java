package com.stackroute.exercises;

import java.io.*;

public class FileMigration {

    private String fileName;

    //Write here logic to read content of first file and write it in second file
    public String fileContentDuplicator(String firstFile, String secondFile) throws IOException {

        String result ="";
        if (firstFile != null && !firstFile.isBlank() && secondFile != null && !secondFile.isBlank()) {

            BufferedReader inputStream = new BufferedReader(new FileReader(firstFile.trim()));
            StringBuilder sb = new StringBuilder();
            String line = inputStream.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = inputStream.readLine();

            }
                result = sb.toString();
                BufferedWriter outputStream = new BufferedWriter(new FileWriter(secondFile.trim()));
                outputStream.write(result);
                outputStream.close();
            return result ;
            }
        return "Given fileName to read or write is empty, null or blank space";

    }

}
