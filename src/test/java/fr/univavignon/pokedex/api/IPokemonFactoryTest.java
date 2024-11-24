package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        int index = 1;
        int cp = 500;
        int hp = 200;
        int dust = 1000;
        int candy = 25;

        Pokemon mockPokemon = new Pokemon(index, "Pikachu", cp, hp, 35, cp, 35, dust, candy, 0.9); // Adjust constructor params as necessary

        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(mockPokemon);

        Pokemon createdPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(createdPokemon); // Check that a Pokémon instance is returned
        assertEquals(mockPokemon, createdPokemon); // Check that the created Pokémon is the same as the mock
    }
}

