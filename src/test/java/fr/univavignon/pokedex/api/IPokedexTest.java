package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon testPokemon;

    @BeforeEach
    public void setUp() {
        pokedex = mock(IPokedex.class);
        // Initialize a test Pokémon
        testPokemon = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 35, 1000, 25, 0.9); // Adjust the constructor as needed
    }

    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(testPokemon)).thenReturn(0);

        int index = pokedex.addPokemon(testPokemon);

        assertEquals(0, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(0)).thenReturn(testPokemon);

        Pokemon retrievedPokemon = pokedex.getPokemon(0);

        assertNotNull(retrievedPokemon);
        assertEquals(testPokemon, retrievedPokemon);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(testPokemon);

        when(pokedex.getPokemons()).thenReturn(pokemonList);

        List<Pokemon> retrievedPokemons = pokedex.getPokemons();

        assertNotNull(retrievedPokemons);
        assertEquals(1, retrievedPokemons.size());
        assertEquals(testPokemon, retrievedPokemons.get(0));
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(testPokemon);

        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);

        when(pokedex.getPokemons(comparator)).thenReturn(pokemonList);

        List<Pokemon> retrievedPokemons = pokedex.getPokemons(comparator);

        assertNotNull(retrievedPokemons);
        assertEquals(1, retrievedPokemons.size());
        assertEquals(testPokemon, retrievedPokemons.get(0));
    }
}

