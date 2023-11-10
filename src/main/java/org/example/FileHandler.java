package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private final File cvsFile = new File("superheroes.csv");

    public ArrayList<Superhero> loadAllData() {
        ArrayList<Superhero> superheroDataList = new ArrayList<>();
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(cvsFile, StandardCharsets.ISO_8859_1);
            fileScanner.nextLine();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        Superhero superhero1 = null;
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] attributes = line.split(";");
            Superhero superheroData1 = null;
            superheroData1 = new Superhero(
                    attributes[0],
                    attributes[1],
                    attributes[2],
                    (Integer.parseInt(attributes[3])),
                    (Boolean.parseBoolean(attributes[4])),
                    (Integer.parseInt(attributes[5]))

            );
            superheroDataList.add(superheroData1);

        }
        return superheroDataList;
    }

    public void saveSuperhero(ArrayList<Superhero> superheroDataList, File fileToSaveTo) {
        try (PrintStream saveToFile = new PrintStream(fileToSaveTo)) {
            for (Superhero superhero : superheroDataList) {
                saveToFile.println(
                        superhero.getRealName() + ";" +
                                superhero.getSuperheroName() + ";" +
                                superhero.getSuperPower() + ";" +
                                superhero.getYearCreated() + ";" +
                                superhero.getIsHuman() + ";" +
                                superhero.getStrength()
                );
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

}






