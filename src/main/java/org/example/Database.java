package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Database {

    private final ArrayList<Superhero> superheroes;
    private final Scanner sc = new Scanner(System.in);

    private final Controller controller = new Controller(this);

    public Database() {
        this.superheroes = new ArrayList<>();

        Superhero superhero1 = new Superhero("Barry Allen", "The Flash ", "Super Speed", 1734, true, 10000);
        Superhero superhero2 = new Superhero("Bruce Banner", "Hulk ", "Strong", 1938, true, 30000);

        superheroes.add(superhero1);
        superheroes.add(superhero2);
    }

    public boolean addSuperheroes(String name, String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        Superhero newSuperhero = new Superhero(name, realName, superpower, yearCreated, isHuman, strength);
        superheroes.add(newSuperhero);
        return true;
    }

    public void showSuperheroes() {
        System.out.println("A list over all the superheroes: ");
        for (Superhero superhero : superheroes) {
            System.out.println(superhero);
        }
    }

    public boolean removeSuperhero(String superheroName) {
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equals(superheroName)) {
                superheroes.remove(superheroName);
                System.out.println("The superhero with the name " + superheroName + " got removed from the database.");
                return true;
            }
        }
        System.out.println("The superhero with the name " + superheroName + " could not be found in the database");
        return false;
    }


    public void searchSuperhero() {

        System.out.println("Skriv navnet på superhelten der skal findes");
        String userInput = sc.nextLine();

        ArrayList<Superhero> searchResult = getSuperheros();

        if (searchResult.isEmpty()) {
            System.out.println("Der blev ikke fundet nogen superhelt ud fra din søgning");
        } else if (searchResult.size() > 1) {
            System.out.println("Vælg en superhelt");
            int tæller = 0;
            for (Superhero hero : searchResult) {
                if (hero.getName().startsWith(userInput)) {
                    System.out.println("SuperhelteID: " + tæller++ + "\n" +
                            hero.getName() + ": realName is - " +
                            hero.getRealName() + "\nAbilities: " +
                            hero.getSuperPower() + "\nYear created: " +
                            hero.getYearCreated() + "\nis a Human: " +
                            hero.getIsHuman() + "\nTotal strength: " +
                            hero.getStrength() + "\n");
                }
            }
        }
    }

    public void editSuperhero() {
        System.out.println("Hvilken superhelt vil du redigere?");
        searchSuperhero();
        Superhero superhero;
        boolean chosenHero = false;
        while (!chosenHero) {
            System.out.println("Indtast ID på den superhelt der skal redigereres");
            int heroID = Integer.parseInt(sc.nextLine());
            superhero = getSuperheros().get(heroID);

            System.out.println("Er du sikker på at du vil foretage ændringer på superhelten: " + superhero.toString());
            String answer = sc.nextLine().toLowerCase();

            if (answer.startsWith("J")) {
                chosenHero = true;
            }
        }

    }

    private ArrayList<Superhero> getSuperheros() {
        return superheroes;
    }

    public void CreateSuperhero(){

        System.out.print("Add name: ");
        String name = sc.nextLine();

        System.out.print("Add real name: ");
        String realName = sc.nextLine();

        System.out.print("Add superpower: ");
        String superPower = sc.nextLine();

        System.out.print("Add year created: ");
        while (!sc.hasNextInt()) {
            System.out.print("You must enter a number: ");
            //Linjen efter skal være af sc.next(); metoden, da denne metode tager alle former for input.
            //hvis det var sc.nextInt(); ville programmet crashe, hvis man inputer andet end integers, da denne scanner ikke kan indlæse andet end integer.
            sc.nextLine();
        }
        int yearCreated = sc.nextInt();
        sc.nextLine();

        System.out.print("Add isHuman: ");
        while (!sc.hasNextBoolean()) {
            System.out.print("You must precisely type true or false: ");
            sc.nextLine();
        }
        Boolean isHuman = sc.nextBoolean();

        System.out.print("Add strength: ");
        while (!sc.hasNextDouble()) {
            System.out.print("You must enter a number: ");
            sc.nextLine();
        }
        int strength = sc.nextInt();
        controller.CreateSuperhero(name,realName, superPower, yearCreated, isHuman, strength);

        System.out.println("Superhero added to list, would you like to create a new superhero?");

    }

}

