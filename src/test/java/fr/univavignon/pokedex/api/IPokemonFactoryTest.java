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
        Pokemon expectedPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(expectedPokemon);
        Pokemon createdPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(createdPokemon);
        assertEquals(0, createdPokemon.getIndex());
        assertEquals("Bulbizarre", createdPokemon.getName());
        assertEquals(613, createdPokemon.getCp());
        assertEquals(64, createdPokemon.getHp());
        assertEquals(4000, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
    }
}