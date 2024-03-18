package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        Pokemon pokemon = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy,56);

        // Call the method under test
        int actualIndex = pokedex.addPokemon(pokemon);

        // Verify that the returned index is non-negative
        assert(actualIndex >= 0);
    }

    // You can write similar tests for other methods of the IPokedex interface
}
