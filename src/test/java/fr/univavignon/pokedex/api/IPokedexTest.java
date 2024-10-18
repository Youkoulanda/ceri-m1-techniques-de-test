package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokedexTest {

    private IPokedex pokedex;

    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testAddPokemon() {
        Pokemon bulbasaur =new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,0.56);
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);

        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemons() {
        Pokemon bulbasaur = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,0.56);
        List<Pokemon> pokemons = Arrays.asList(bulbasaur);
        when(pokedex.getPokemons()).thenReturn(pokemons);

        List<Pokemon> result = pokedex.getPokemons();
        assertEquals(1, result.size());
        assertEquals("Bulbizarre", result.get(0).getName());
    }
}
