package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final File file = new File("SuperheroData.cvs");

    public ArrayList<Superhero> loadAllData() {
        Scanner fileScanner = null;
        ArrayList<Superhero> superheroDataList = new ArrayList<>();
        try {
            fileScanner = new Scanner(file);
            fileScanner.nextLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Superhero superheroData1 = null;
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] attributes = line.split(";");
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
        fileScanner.close();
        return superheroDataList;
    }
}
