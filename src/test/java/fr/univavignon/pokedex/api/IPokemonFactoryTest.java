package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private int index;
    private String name;
    private int attack;
    private int defense;
    private int stamina;
    private int cp;
    private int hp;
    private int dust;
    private int candy;
    private int iv;

    @Before
    public void setUp() throws PokedexException {
        // Initialize PokemonFactory directly instead of mocking
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);

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
        iv = 56;
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        // Create a Pokemon instance using the factory
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Verify that the created Pokemon instance is not null
        assertNotNull(pokemon);

        // Verify that the attributes of the created Pokemon match the expected values
        assertEquals(index, pokemon.getIndex());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }
}
