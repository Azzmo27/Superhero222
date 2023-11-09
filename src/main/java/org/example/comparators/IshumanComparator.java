package org.example.comparators;

import org.example.Superhero;

import java.util.Comparator;

public class IshumanComparator implements Comparator<Superhero>  {

    public int compare (Superhero superhero1, Superhero superhero2){
        return Boolean.compare(superhero1.getIsHuman(), superhero2.getIsHuman());
    }


    }




