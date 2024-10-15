package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {



    @Test
    public void createPokemon(){
        IPokemonFactory ipokemonFactory = Mockito.mock(IPokemonFactory.class);
        Pokemon pokemon = new Pokemon(0, null, 0, 0, 0, 613, 64, 400, 4, 0);
        Mockito.when(ipokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
        assertTrue(ipokemonFactory.createPokemon(0, 613, 64, 4000, 4).equals(pokemon) );


    }

}
