package fr.univavignon.pokedex.api;



import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
        // Initialize mock Pokedex
        pokedex = mock(IPokedex.class);
        name = "bulbizzare";
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
        // Define the expected size
        int expectedSize = 10;

        // Configure the mock to return the expected size
        when(pokedex.size()).thenReturn(expectedSize);

        // Call the method under test
        int actualSize = pokedex.size();

        // Verify that the returned size matches the expected size
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAddPokemon() {
        // Create a sample Pokemon
        Pokemon pokemon = new Pokemon(index,name,attack,defense,stamina, cp, hp, dust, candy,56);

        // Define the expected index
        int expectedIndex = 1;

        // Configure the mock to return the expected index when adding a Pokemon
        when(pokedex.addPokemon(pokemon)).thenReturn(expectedIndex);

        // Call the method under test
        int actualIndex = pokedex.addPokemon(pokemon);

        // Verify that the returned index matches the expected index
        assertEquals(expectedIndex, actualIndex);
    }

    // You can write similar tests for other methods of the IPokedex interface
}
