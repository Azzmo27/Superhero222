package org.example;

import java.util.ArrayList;

public class Controller {

    private final ArrayList<Superhero> superheroes = new ArrayList<>();
    private final Database database;



    public Controller(Database database) {
        this.database = database;
    }

    public boolean addSuperhero(String Name, String RealName, String superPower, int yearCreated, Boolean isHuman, int strength) {
        return database.addSuperheroes(Name, RealName, superPower, yearCreated, isHuman, strength);
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
}



