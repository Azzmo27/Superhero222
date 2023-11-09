package test;
import org.example.Superhero;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class DatabaseJunitTest {

    @Test
     public void removeSuperhero() {
        ArrayList<Superhero> superheroes = new ArrayList<>();

        Superhero superheroTest = new Superhero("Natasha","Black Widow", "Combat skills" ,1999, true ,100);
        superheroes.add(superheroTest);

        superheroes.remove(superheroTest);

        ArrayList<Superhero> expected = new ArrayList<>();
        assertEquals(superheroes, expected);
    }


}
