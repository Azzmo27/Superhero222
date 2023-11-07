package org.example;

import java.util.Comparator;

public class SuperPowerComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero superH1, Superhero superH2) {
        return superH1.getSuperPower().compareTo(superH2.getSuperPower());
    }

}
