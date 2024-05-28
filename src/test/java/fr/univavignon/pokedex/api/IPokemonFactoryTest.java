package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 56, 4000, 4, 56));
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(4, pokemon.getCp());
        assertEquals(56, pokemon.getHp());
    }
}
