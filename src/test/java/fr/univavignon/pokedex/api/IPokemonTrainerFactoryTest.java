package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {



     @Test
    public void createTrainer(){
        IPokemonTrainerFactory iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        PokemonTrainer pokemonTrainer = new  PokemonTrainer("zzz",Team.VALOR, null);
        Mockito.when(iPokemonTrainerFactory.createTrainer("zzz", Team.VALOR, null)).thenReturn(pokemonTrainer);
        assertTrue(iPokemonTrainerFactory.createTrainer("zzz", Team.VALOR, null).equals(pokemonTrainer));


    }

}
