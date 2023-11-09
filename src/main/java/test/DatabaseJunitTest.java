package test;

import org.example.Superhero;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class DatabaseJunitTest {

    @Test
     public void removeSuperhero() {
        ArrayList<Superhero> superheroes = new ArrayList<>();

// arrange
        Superhero superheroTest = new Superhero("Natasha","Mohamed", "fly" ,2003, true ,100);
        superheroes.add(superheroTest);

// act
        superheroes.remove(superheroTest);
//assert
        ArrayList<Superhero> expected = new ArrayList<>();
        assertEquals(superheroes, expected);
    }

}
