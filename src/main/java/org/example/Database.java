package org.example;
import org.example.comparators.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Database {
    private ArrayList<Superhero> superheroes;
    private final Scanner sc = new Scanner(System.in);
    private final File file = new File("superheroes.cvs");
    private final FileHandler filehandler = new FileHandler();

    public Database() {

         try {
            this.superheroes = filehandler.loadAllData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSuperheroes(String realName, String superheroName, String superpower, int yearCreated, boolean isHuman, int strength) throws FileNotFoundException {
        Superhero newSuperhero = new Superhero(realName, superheroName, superpower, yearCreated, isHuman, strength);
        superheroes.add(newSuperhero);
        filehandler.saveSuperhero(superheroes, file);

    }

    public void showSuperheroes() {
        PowerandSuperheroComparator comporson = new PowerandSuperheroComparator();
        Collections.sort(superheroes,comporson);
        System.out.println("A list over all the superheroes: ");
        for (Superhero superhero : superheroes) {
            System.out.println(superhero);
        }

    }

    public boolean removeSuperhero(String superheroName) {
        for (Superhero superhero : superheroes) {
            if (superhero.getRealName().equalsIgnoreCase(superheroName)) {
                superheroes.remove(superhero);
                System.out.println("The superhero with the name " + superheroName + " got removed from the database.");
                System.out.println("Here is the list of the remaining superheroes" + superheroes + "\n" );
                return true;
            }
        }
        System.out.println("The superhero with the name " + superheroName + " could not be found in the database");
        return false;

    }

    public void searchSuperhero() {

        System.out.println("Write the government name of the superhero ");
        String userInput = sc.nextLine();

        ArrayList<Superhero> searchResult = getSuperheros();

        if (searchResult.isEmpty()) {
            System.out.println("Sorry there was no superhero with that name");
        } else if (searchResult.size() > 1) {

            int counter = 0;
            for (Superhero hero : searchResult) {
                if (hero.getRealName().startsWith(userInput)) {
                    System.out.println("SuperheroID: " + counter++ + "\n" +
                            hero.getRealName() + ": superhero name is - " +
                            hero.getSuperheroName() + "\nAbilities: " +
                            hero.getSuperPower() + "\nYear created: " +
                            hero.getYearCreated() + "\nis a Human: " +
                            hero.getIsHuman() + "\nTotal strength: " +
                            hero.getStrength() + "\n");
                }
            }
        }
    }
    public void editSuperhero() {
        System.out.println("Please choose a superhero you would like to edit");
        searchSuperhero();
        Superhero superhero;
        boolean chosenHero = false;
        while (!chosenHero) {
            System.out.println("Type in the ID on the superhero, you would like to edit");
            int heroID = Integer.parseInt(sc.nextLine());
            superhero = getSuperheros().get(heroID);

            System.out.println("Are you sure you would like to make changes on the superhero: " + superhero.toString());
            String answer = sc.nextLine().toLowerCase();

            if (answer.startsWith("Y")) {
                chosenHero = true;
            }
        }
    }
    private ArrayList<Superhero> getSuperheros() {
        return superheroes;
    }

    public void viewAsuperhero() {
        System.out.println("Type in the name of the superhero you would like to see:");
        String superName = sc.nextLine();

        Superhero chosenSuperhero = null;
        for (Superhero superhero : getSuperheros()) {
            if (superhero.getSuperheroName().equalsIgnoreCase(superName)) {
                chosenSuperhero = superhero;
                break;

            }
        }
        if (chosenSuperhero != null) {
            System.out.println("Information:");
            System.out.println("Superhero Name: " + chosenSuperhero.getSuperheroName());
            System.out.println("Real Name: " + chosenSuperhero.getRealName());
            System.out.println("Superpower: " + chosenSuperhero.getSuperPower());
            System.out.println("Year Created: " + chosenSuperhero.getYearCreated());
            System.out.println("Is the superhero Human: " + chosenSuperhero.getIsHuman());
            System.out.println("Strength: " + chosenSuperhero.getStrength());
        } else {
            System.out.println("The superhero with the name " + superName + " was not found sorry...");
        }
    }

    public void superheroSortedByName() {
        RealNameComparator comparator = new RealNameComparator();
        Collections.sort(superheroes, comparator);

        for (Superhero superhero : superheroes) {
            System.out.println(superhero.getRealName());
        }

    }

    public void SuperheroName() {
        SuperheroComparator comparator = new SuperheroComparator();
        Collections.sort(superheroes, comparator);

        for (Superhero superhero : superheroes) {
            System.out.println(superhero.getSuperheroName());
        }
    }

    public void SuperPowerComparator() {
        SuperPowerComparator comparator = new SuperPowerComparator();
        Collections.sort(superheroes, comparator);

        for (Superhero superhero : superheroes) {
            System.out.println(superhero.getSuperPower());
        }
    }

    public void yearCreated() {
        YearCreatedComparator comparator = new YearCreatedComparator();
        Collections.sort(superheroes, comparator);

        for (Superhero superhero : superheroes) {
            System.out.println(superhero.getYearCreated());
        }

    }

    public boolean isHuman() {
        IshumanComparator comparator = new IshumanComparator();
        Collections.sort(superheroes, comparator);

        for (Superhero superhero : superheroes) {
            if (superhero.getIsHuman())
                return true;
            System.out.println(superhero.getIsHuman());
        }
        return false;
    }

    public void strength() {
        StrengthComparator comparator = new StrengthComparator();
        Collections.sort(superheroes, comparator);

        for (Superhero superhero : superheroes) {
            System.out.println(superhero.getStrength());
        }
    }

    // this method (switch case ) is a menu of the sorted attributes.
    public void sortedOptions() {
        int Sorted = sc.nextInt();
        sc.nextLine();
        switch (Sorted) {
            case 1 -> superheroSortedByName();
            case 2 -> SuperheroName();
            case 3 -> SuperPowerComparator();
            case 4 -> yearCreated();
            case 5 -> isHuman();
            case 6 -> strength();
            default -> System.out.println("Invalid choice. Try again ...");
        }

    }


}

