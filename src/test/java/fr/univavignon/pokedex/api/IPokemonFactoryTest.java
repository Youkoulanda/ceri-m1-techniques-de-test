package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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

    @Before
    public void setUp() {
        // Initialize mock Pokemon factory
        pokemonFactory = mock(IPokemonFactory.class);

        // Initialize Pokemon attributes
        name = "bulbizzare";
        attack = 126;
        defense = 126;
        stamina = 90;
        index = 0;
        cp = 613;
        hp = 64;
        dust = 4000;
        candy = 4;

        // Define behavior of the mock method
        Pokemon mockedPokemon = new Pokemon(index,name,attack,defense,stamina, cp, hp, dust, candy,56); // Define the expected return value
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(mockedPokemon); // Define behavior
    }

    @Test
    public void testCreatePokemon() {
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
