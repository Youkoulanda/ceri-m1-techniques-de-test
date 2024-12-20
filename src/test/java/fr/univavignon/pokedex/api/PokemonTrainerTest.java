package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class PokemonTrainerTest {
       @Test
    public void testPokemonTrainerEquality() {
        // Mocking dependencies
        IPokedex mockedPokedex1 = Mockito.mock(IPokedex.class);
        IPokedex mockedPokedex2 = Mockito.mock(IPokedex.class);

        // Creating PokemonTrainer instances
        PokemonTrainer trainer1 = new PokemonTrainer("Ash", Team.VALOR, mockedPokedex1);
        PokemonTrainer trainer2 = new PokemonTrainer("Ash", Team.VALOR, mockedPokedex1);
        PokemonTrainer trainer3 = new PokemonTrainer("Misty", Team.MYSTIC, mockedPokedex2);

        // Verifying equality
        assertEquals("Trainers with the same attributes should be equal", trainer1, trainer2);
        assertNotEquals("Trainers with different attributes should not be equal", trainer1, trainer3);
    }

    @Test(expected = NullPointerException.class)
    public void testPokemonTrainerWithNullName() {
        // Mocking dependencies
        IPokedex mockedPokedex = Mockito.mock(IPokedex.class);

        // Attempting to create a trainer with a null name
        new PokemonTrainer(null, Team.VALOR, mockedPokedex);
    }

    @Test(expected = NullPointerException.class)
    public void testPokemonTrainerWithNullTeam() {
        // Mocking dependencies
        IPokedex mockedPokedex = Mockito.mock(IPokedex.class);

        // Attempting to create a trainer with a null team
        new PokemonTrainer("Ash", null, mockedPokedex);
    }

    @Test(expected = NullPointerException.class)
    public void testPokemonTrainerWithNullPokedex() {
        // Attempting to create a trainer with a null pokedex
        new PokemonTrainer("Ash", Team.VALOR, null);
    }
}
