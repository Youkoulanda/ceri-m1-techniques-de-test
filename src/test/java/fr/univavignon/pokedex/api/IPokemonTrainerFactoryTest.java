package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp() {
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void testCreateTrainer() {
        String trainerName = "Ash";
        Team trainerTeam = Team.VALOR;
        IPokedex mockPokedex = mock(IPokedex.class);

        when(pokedexFactory.createPokedex(any(), any())).thenReturn(mockPokedex); // Stub the pokedex creation

        PokemonTrainer mockTrainer = new PokemonTrainer(trainerName, trainerTeam, mockPokedex);
        when(trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory)).thenReturn(mockTrainer);

        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);

        assertNotNull(createdTrainer);
        assertEquals(trainerName, createdTrainer.getName());
        assertEquals(trainerTeam, createdTrainer.getTeam());
        assertEquals(mockPokedex, createdTrainer.getPokedex());
    }
}
