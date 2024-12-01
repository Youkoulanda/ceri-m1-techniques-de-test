package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class IPokedexTest {
    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private Pokemon bulbizarre;
    private Pokemon aquali;
    private ArrayList<Pokemon> pokemons;

    @Before
    public void init() {
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
        pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
    }

    // Checking that the Pokedex contains the two Pokémon
    @Test
    public void testAddPokemon() {
        assertEquals(2, pokedex.size());
    }

    // Checking that an exception is thrown when adding a null Pokémon
    @Test
    public void testAddNullPokemon() {
        assertThrows(IllegalArgumentException.class, () -> {
            pokedex.addPokemon(null);
        });
    }

    // Checking correct retrieval of a Pokémon by its index
    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertEquals(bulbizarre, retrievedPokemon);
    }

    // Checking that an exception is thrown for an invalid index
    @Test
    public void testGetPokemonInvalidId() {
        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);
        });
    }

    // Checking that all Pokémon are correctly retrieved
    @Test
    public void testGetPokemons() {
        List<Pokemon> allPokemons = pokedex.getPokemons();
        assertEquals(2, allPokemons.size());
        assertTrue(allPokemons.contains(bulbizarre));
        assertTrue(allPokemons.contains(aquali));
    }

    // Retrieving Pokémon sorted and checking sorting by index
    @Test
    public void testGetPokemonsWithComparatorByIndex() {
        List<Pokemon> ResultPokemons = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(bulbizarre, ResultPokemons.get(0));
        assertEquals(aquali, ResultPokemons.get(1));
    }

    // Retrieving Pokémon sorted and checking sorting by CP
    @Test
    public void testGetPokemonsWithComparatorByCP() {
        List<Pokemon> PokemonsResult = pokedex.getPokemons(PokemonComparators.CP);
        assertEquals(bulbizarre, PokemonsResult.get(0));
        assertEquals(aquali, PokemonsResult.get(1));
    }

    // Checking that the createPokemon method throws an unsupported exception
    @Test
    public void testUnsupportedCreatePokemon() {
        assertThrows(UnsupportedOperationException.class, () -> {
            pokedex.createPokemon(0, 10, 10, 50, 100);
        });
    }

    // Checking that the getPokemonMetadata method throws an unsupported exception
    @Test
    public void testUnsupportedGetPokemonMetadata() {
        assertThrows(UnsupportedOperationException.class, () -> {
            pokedex.getPokemonMetadata(0);
        });
    }
}
