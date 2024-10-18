package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;

    @Before
    public void setUp() {
        trainerFactory = mock(IPokemonTrainerFactory.class);
    }

    @Test
    public void testCreateTrainer() {
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);
        when(trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory)).thenReturn(trainer);

        PokemonTrainer result = trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);
        assertEquals("Ash", result.getName());
        assertEquals(Team.MYSTIC, result.getTeam());
        assertNotNull(result.getPokedex());
    }
}
