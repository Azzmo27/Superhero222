package org.example.Comparators;

import org.example.Superhero;

import java.util.Comparator;

public class PowerandSuperheroComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
       int comparison = superhero1.getSuperheroName().compareTo(superhero2.getSuperheroName());
       if (comparison == 0 ) {
           return superhero1.getSuperPower().compareTo(superhero2.getSuperPower());
       }
       return comparison;

    }
}
