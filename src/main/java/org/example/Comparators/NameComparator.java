package org.example.Comparators;

import org.example.Superhero;

import java.util.Comparator;

public class NameComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
        return superhero1.getSuperheroName().compareTo(superhero2.getSuperheroName());
    }
}
