package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class IPokedexTest {

    private IPokedex pokedex;
    private List<Pokemon> pokemons;

    @Before
    public void setUp(){

        this.pokedex = Mockito.mock(IPokedex.class);
        pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(0,
                "Bulbizarre",
                126,
                126,
                90,
                613,
                64,
                4000,
                4,
                56.0));

        pokemons.add(
                new Pokemon(
                        133,
                        "Aquali",
                        186,
                        186,
                        260,
                        2729,
                        202,
                        5000,
                        4,
                        100.0
                )
        );


    }

    @Test
    public void ShouldReturnSize(){

        //when
        Mockito.doReturn(this.pokemons.size()).when(this.pokedex).size();

        //then
        assertEquals(2,this.pokedex.size());
    }
}
