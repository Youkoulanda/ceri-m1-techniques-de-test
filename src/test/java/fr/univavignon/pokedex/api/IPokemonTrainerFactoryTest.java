package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {



      @Test
    public void createTrainer() {
        IPokemonTrainerFactory iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        IPokedex mockPokedex = Mockito.mock(IPokedex.class);
        PokemonTrainer pokemonTrainer = new PokemonTrainer("zzz", Team.VALOR, mockPokedex);

        Mockito.when(iPokemonTrainerFactory.createTrainer("zzz", Team.VALOR, (IPokedexFactory) mockPokedex)).thenReturn(pokemonTrainer);

        PokemonTrainer result = iPokemonTrainerFactory.createTrainer("zzz", Team.VALOR, (IPokedexFactory) mockPokedex);

        assertNotNull("The created trainer should not be null", result);
        assertEquals("The trainer's name should be 'zzz'", "zzz", result.getName());
        assertEquals("The trainer's team should be VALOR", Team.VALOR, result.getTeam());
        assertEquals("The trainer's pokedex should match the mock pokedex", mockPokedex, result.getPokedex());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTrainerWithNullName() {
        IPokemonTrainerFactory iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);

        Mockito.when(iPokemonTrainerFactory.createTrainer(null, Team.MYSTIC, null)).thenThrow(new IllegalArgumentException("Trainer name cannot be null"));

        iPokemonTrainerFactory.createTrainer(null, Team.MYSTIC, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTrainerWithNullTeam() {
        IPokemonTrainerFactory iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);

        Mockito.when(iPokemonTrainerFactory.createTrainer("Ash", null, null)).thenThrow(new IllegalArgumentException("Team cannot be null"));

        iPokemonTrainerFactory.createTrainer("Ash", null, null);
    }

    @Test
    public void createTrainerEqualityTest() {
        IPokemonTrainerFactory iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        IPokedex mockPokedex = Mockito.mock(IPokedex.class);
        PokemonTrainer trainer1 = new PokemonTrainer("Ash", Team.INSTINCT, mockPokedex);
        PokemonTrainer trainer2 = new PokemonTrainer("Ash", Team.INSTINCT, mockPokedex);

        Mockito.when(iPokemonTrainerFactory.createTrainer("Ash", Team.INSTINCT, (IPokedexFactory) mockPokedex)).thenReturn(trainer1).thenReturn(trainer2);

        PokemonTrainer result1 = iPokemonTrainerFactory.createTrainer("Ash", Team.INSTINCT, (IPokedexFactory) mockPokedex);
        PokemonTrainer result2 = iPokemonTrainerFactory.createTrainer("Ash", Team.INSTINCT, (IPokedexFactory) mockPokedex);

        assertNotSame("Each call should return a different PokemonTrainer instance", result1, result2);
    }

    @Test
    public void createTrainerWithDifferentTeams() {
        IPokemonTrainerFactory iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        IPokedex mockPokedex = Mockito.mock(IPokedex.class);
        PokemonTrainer valorTrainer = new PokemonTrainer("Red", Team.VALOR, mockPokedex);
        PokemonTrainer mysticTrainer = new PokemonTrainer("Blue", Team.MYSTIC, mockPokedex);

        Mockito.when(iPokemonTrainerFactory.createTrainer("Red", Team.VALOR, (IPokedexFactory) mockPokedex)).thenReturn(valorTrainer);
        Mockito.when(iPokemonTrainerFactory.createTrainer("Blue", Team.MYSTIC, (IPokedexFactory) mockPokedex)).thenReturn(mysticTrainer);

        PokemonTrainer resultValor = iPokemonTrainerFactory.createTrainer("Red", Team.VALOR, (IPokedexFactory) mockPokedex);
        PokemonTrainer resultMystic = iPokemonTrainerFactory.createTrainer("Blue", Team.MYSTIC, (IPokedexFactory) mockPokedex);

        assertNotEquals("Trainers from different teams should not be equal", resultValor, resultMystic);
    }
}
