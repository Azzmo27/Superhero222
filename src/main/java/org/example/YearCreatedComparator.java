package org.example;

import java.util.Comparator;

public class YearCreatedComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero superH1, Superhero superH2){
        return superH1.getYearCreated();
    }
}
