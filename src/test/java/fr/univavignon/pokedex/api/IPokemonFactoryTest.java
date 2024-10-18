package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemonExample1() {
        Pokemon bulbasaur = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,0.56);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbasaur);

        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", result.getName());
        assertEquals(613, result.getCp());
    }
}