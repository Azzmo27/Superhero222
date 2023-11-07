package org.example;

import java.util.Comparator;

public class NameComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
        return superhero1.getName().compareTo(superhero2.getName());
    }
}
