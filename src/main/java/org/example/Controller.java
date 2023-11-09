package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {


    private final Database database;


    public Controller(Database database) {
        this.database = database;
    }

    public void addSuperhero(String realName, String superheroName, String superPower, int yearCreated, Boolean isHuman, int strength) throws FileNotFoundException {
        database.addSuperheroes(realName, superheroName, superPower, yearCreated, isHuman, strength);
    }

    public void showSuperhero() {
        database.showSuperheroes();
    }

    public boolean removeSuperhero(String superheroName) {
        return database.removeSuperhero(superheroName);
    }


    public void searchSuperhero() {

        database.searchSuperhero();
    }
    public void SortedOptions(){

        database.sortedOptions();
    }

    public void viewAsuperhero() {
        database.viewAsuperhero();
    }

    public void showSuperheroes() {
        database.showSuperheroes();
    }

    public void editSuperhero() {
        database.editSuperhero();
    }
}



