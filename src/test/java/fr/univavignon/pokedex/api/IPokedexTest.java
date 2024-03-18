package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokedexTest {

    private IPokedex pokedex;
    private int index;
    private String name;
    private int attack;
    private int defense;
    private int stamina;
    private int cp;
    private int hp;
    private int dust;
    private int candy;


    @Before
    public void setUp() {
        // Initialize the Pokedex with real implementations
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Initialize Pokemon attributes
        name = "bulbizarre";
        attack = 126;
        defense = 126;
        stamina = 90;
        index = 0;
        cp = 613;
        hp = 64;
        dust = 4000;
        candy = 4;

    }

    @Test
    public void testSize() {
        // Call the method under test
        int actualSize = pokedex.size();

        // Verify that the returned size is non-negative
        assert(actualSize >= 0);
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        // Create a sample Pokemon
        Pokemon pokemon = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, 56);

        // Call the method under test
        int actualIndex = pokedex.addPokemon(pokemon);

        // Verify that the returned index is non-negative
        assert(actualIndex >= 0);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Add a Pokemon to the Pokedex
        Pokemon addedPokemon = createTestPokemon();
        pokedex.addPokemon(addedPokemon);

        // Retrieve the Pokemon by index
        Pokemon retrievedPokemon = pokedex.getPokemon(0);

        // Check if the retrieved Pokemon matches the added one
        assertNotNull(retrievedPokemon);
        assertEquals(addedPokemon.getIndex(), retrievedPokemon.getIndex());
        assertEquals(addedPokemon.getName(), retrievedPokemon.getName());
        assertEquals(addedPokemon.getCp(), retrievedPokemon.getCp());
        assertEquals(addedPokemon.getHp(), retrievedPokemon.getHp());
        assertEquals(addedPokemon.getDust(), retrievedPokemon.getDust());
        assertEquals(addedPokemon.getCandy(), retrievedPokemon.getCandy());
    }

    // Helper method to create a test Pokemon
    private Pokemon createTestPokemon() throws PokedexException {
        return pokedex.createPokemon(0, 500, 50, 2000, 2);
    }

    // You can add more test cases for other methods as needed
}
