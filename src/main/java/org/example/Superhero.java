package org.example;

public class Superhero {

    private final String Name;
    private final String RealName;

    private final String superPower;

    private final int yearCreated;

    private final boolean isHuman;

    private final int strength;

    Superhero(String Name, String RealName, String superPower, int yearCreated, Boolean isHuman, int strength) {

        this.realName = realName;
        this.superheroName = superheroName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }


    public String getRealName() {
        return realName;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getSuperPower() {
        return superPower;
    }


    public int getYearCreated() {
        return yearCreated;
    }

    public boolean getIsHuman() {
        return isHuman;
    }

    public int getStrength() {
        return strength;
    }



    @Override
    public String toString() {
        return "\n" + "Superhero:"
                 + superheroName +
                ", Name = " + realName +
                ", Powers = " + superPower +
                ", Year of creation = " + yearCreated +
                ", Human = " + isHuman +
                ", Strength = " + strength + " " + "\n";


    }
}