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

    /**
     * Initialization of the objects required for testing.
     * This method is executed before each test to prepare the testing environment.
     */
    @Before
    public void init() {
        // Initialize the Pokedex instance with the necessary providers
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Create two Pokémon objects for testing (Bulbizarre and Aquali)
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);

        // Add Pokémon to a list and to the Pokedex
        pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
    }

    /**
     * Test adding Pokémon to the Pokedex.
     * This test verifies that adding two Pokémon to the Pokedex increases its size to 2.
     */
    @Test
    public void testAddPokemon() {
        assertEquals(2, pokedex.size());
    }

    /**
     * Test adding a null Pokémon to the Pokedex.
     * This test verifies that an IllegalArgumentException is thrown when a null Pokémon is added.
     */
    @Test
    public void testAddNullPokemon() {
        assertThrows(IllegalArgumentException.class, () -> {
            pokedex.addPokemon(null);
        });
    }

    /**
     * Test retrieving a Pokémon by its index.
     * This test verifies that the Pokémon retrieved is the one added to the Pokedex at index 0.
     */
    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertEquals(bulbizarre, retrievedPokemon);
    }

    /**
     * Test retrieving a Pokémon with an invalid index.
     * This test verifies that a PokedexException is thrown when attempting to retrieve a Pokémon with an invalid index.
     */
    @Test
    public void testGetPokemonInvalidId() {
        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);
        });
    }

    /**
     * Test retrieving all Pokémon.
     * This test verifies that all Pokémon added to the Pokedex can be retrieved in a list.
     */
    @Test
    public void testGetPokemons() {
        List<Pokemon> allPokemons = pokedex.getPokemons();
        assertEquals(2, allPokemons.size());
        assertTrue(allPokemons.contains(bulbizarre));
        assertTrue(allPokemons.contains(aquali));
    }

    /**
     * Test retrieving Pokémon sorted by index.
     * This test verifies that Pokémon are correctly sorted by their index when using a comparator.
     */
    @Test
    public void testGetPokemonsWithComparatorByIndex() {
        List<Pokemon> ResultPokemons = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(bulbizarre, ResultPokemons.get(0));
        assertEquals(aquali, ResultPokemons.get(1));
    }

    /**
     * Test retrieving Pokémon sorted by CP (combat points).
     * This test verifies that Pokémon are correctly sorted by their CP when using a comparator.
     */
    @Test
    public void testGetPokemonsWithComparatorByCP() {
        List<Pokemon> PokemonsResult = pokedex.getPokemons(PokemonComparators.CP);
        assertEquals(bulbizarre, PokemonsResult.get(0));
        assertEquals(aquali, PokemonsResult.get(1));
    }

    /**
     * Test the createPokemon method.
     * This test verifies that an UnsupportedOperationException is thrown when attempting to use the createPokemon method,
     * which is not supported in the Pokedex.
     */
    @Test
    public void testUnsupportedCreatePokemon() {
        assertThrows(UnsupportedOperationException.class, () -> {
            pokedex.createPokemon(0, 10, 10, 50, 100);
        });
    }

    /**
     * Test the getPokemonMetadata method.
     * This test verifies that an UnsupportedOperationException is thrown when attempting to use the getPokemonMetadata method,
     * which is not supported in the Pokedex.
     */
    @Test
    public void testUnsupportedGetPokemonMetadata() {
        assertThrows(UnsupportedOperationException.class, () -> {
            pokedex.getPokemonMetadata(0);
        });
    }
}
