package org.example.Comparators;

import org.example.Superhero;

import java.util.Comparator;

public class SuperheroComparator implements Comparator<Superhero> {
    @Override

    //This method compares
    public int compare(Superhero superhero1, Superhero superhero2) {
        return superhero1.getSuperheroName().compareTo(superhero2.getSuperheroName());
    }


   // @Test



}