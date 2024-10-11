package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setup() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        Pokemon expectedPokemon = new Pokemon(0, "Bulbizar", 126, 126, 90, 20, 60, 2, 4, 0.5);
        when(pokemonFactory.createPokemon(0, 20, 60, 2, 4)).thenReturn(expectedPokemon);
        Pokemon createdPokemon = pokemonFactory.createPokemon(0, 20, 60, 2, 4);

        assertNotNull(createdPokemon);
        assertEquals(0, createdPokemon.getIndex());
        assertEquals("Bulbizar", createdPokemon.getName());
        assertEquals(20, createdPokemon.getCp());
        assertEquals(60, createdPokemon.getHp());
        assertEquals(2, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
    }
}