package org.example.comparators;

import org.example.Superhero;

import java.util.Comparator;

public class YearCreatedComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero superH1, Superhero superH2){
        return superH1.getYearCreated();
    }
}
