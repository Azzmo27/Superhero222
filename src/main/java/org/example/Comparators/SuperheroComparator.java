package org.example.Comparators;

import org.example.Superhero;

import java.util.Comparator;

public class SuperheroComparator implements Comparator<Superhero> {
    @Override

    //compare navne så de kan sorters
    public int compare(Superhero superhero1, Superhero superhero2) {
        return superhero1.getName().compareTo(superhero2.getName());
    }


   // @Test



}