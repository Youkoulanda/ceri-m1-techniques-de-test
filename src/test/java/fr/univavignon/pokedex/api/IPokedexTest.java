package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private IPokedex pokedex;

    @BeforeEach
    public void setup() {
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testSize() {
        when(pokedex.size()).thenReturn(3);
        int size = pokedex.size();

        assertEquals(3, size);
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbizar", 33, 33, 33, 33, 33, 33, 33, 33);
        when(pokedex.addPokemon(pokemon)).thenReturn(0);
        int index = pokedex.addPokemon(pokemon);

        assertEquals(0, index);
    }

    @Test
    public void testGetPokemonValidId() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizar", 33, 33, 33, 33, 33, 33, 33, 33);
        when(pokedex.getPokemon(0)).thenReturn(pokemon);
        Pokemon result = pokedex.getPokemon(0);

        assertNotNull(result);
        assertEquals("Bulbizar", result.getName());
    }

    @Test
    public void testGetPokemonInvalidId() throws PokedexException {
        PokedexException pokException = new PokedexException("ID invalide");
        when(pokedex.getPokemon(200)).thenThrow(pokException);

        assertThrows(PokedexException.class, () -> pokedex.getPokemon(200));
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon(0, "Bulbizar", 33, 33, 33, 33, 33, 33, 33, 33),
                new Pokemon(151, "MewTwo", 33, 33, 33, 33, 33, 33, 33, 33)
        );
        when(pokedex.getPokemons()).thenReturn(pokemons);
        List<Pokemon> result = pokedex.getPokemons();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon(0, "Bulbizar", 33, 33, 33, 33, 33, 33, 33, 33),
                new Pokemon(151, "MewTwo", 33, 33, 33, 33, 33, 33, 33, 33)
        );
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        when(pokedex.getPokemons(comparator)).thenReturn(pokemons);
        List<Pokemon> result = pokedex.getPokemons(comparator);

        assertEquals("Bulbizar", result.get(0).getName());
    }
}