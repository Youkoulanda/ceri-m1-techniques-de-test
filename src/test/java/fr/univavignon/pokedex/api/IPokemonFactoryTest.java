package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {



     @Test
    public void createPokemon() {
        IPokemonFactory ipokemonFactory = Mockito.mock(IPokemonFactory.class);
        Pokemon pokemon = new Pokemon(0, null, 0, 0, 0, 613, 64, 4000, 4, 0);
        Mockito.when(ipokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
        assertTrue(ipokemonFactory.createPokemon(0, 613, 64, 4000, 4).equals(pokemon));
    }

    @Test
    public void createPokemonValidData() {
        IPokemonFactory ipokemonFactory = Mockito.mock(IPokemonFactory.class);
        Pokemon charizard = new Pokemon(6, "Charizard", 223, 173, 186, 2400, 120, 5000, 6, 80.0);

        Mockito.when(ipokemonFactory.createPokemon(6, 2400, 120, 5000, 6)).thenReturn(charizard);

        Pokemon result = ipokemonFactory.createPokemon(6, 2400, 120, 5000, 6);

        assertNotNull("The created Pokemon should not be null", result);
        assertEquals("The index should be 6", 6, result.getIndex());
        assertEquals("The name should be Charizard", "Charizard", result.getName());
        assertEquals("The CP should be 2400", 2400, result.getCp());
        assertEquals("The HP should be 120", 120, result.getHp());
        assertEquals("The candy count should be 6", 6, result.getCandy());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createPokemonInvalidData() {
        IPokemonFactory ipokemonFactory = Mockito.mock(IPokemonFactory.class);

        Mockito.when(ipokemonFactory.createPokemon(-1, 0, 0, 0, 0)).thenThrow(new IllegalArgumentException("Invalid Pokemon data"));

        ipokemonFactory.createPokemon(-1, 0, 0, 0, 0);
    }

    @Test
    public void createPokemonBoundaryValues() {
        IPokemonFactory ipokemonFactory = Mockito.mock(IPokemonFactory.class);
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 118, 118, 90, 300, 50, 2000, 4, 56.0);

        Mockito.when(ipokemonFactory.createPokemon(0, 300, 50, 2000, 4)).thenReturn(bulbasaur);

        Pokemon result = ipokemonFactory.createPokemon(0, 300, 50, 2000, 4);

        assertNotNull("The created Pokemon should not be null", result);
        assertEquals("The index should be 0", 0, result.getIndex());
        assertEquals("The name should be Bulbasaur", "Bulbasaur", result.getName());
    }

    @Test
    public void createPokemonEqualityTest() {
        IPokemonFactory ipokemonFactory = Mockito.mock(IPokemonFactory.class);
        Pokemon pikachu = new Pokemon(25, "Pikachu", 112, 96, 111, 800, 60, 3000, 4, 70.0);

        Mockito.when(ipokemonFactory.createPokemon(25, 800, 60, 3000, 4)).thenReturn(pikachu);

        Pokemon result1 = ipokemonFactory.createPokemon(25, 800, 60, 3000, 4);
        Pokemon result2 = ipokemonFactory.createPokemon(25, 800, 60, 3000, 4);

        assertSame("The objects should be the same", result1, result2);
    }

}
