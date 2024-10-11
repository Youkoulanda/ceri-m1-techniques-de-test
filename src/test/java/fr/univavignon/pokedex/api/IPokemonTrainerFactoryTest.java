package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp() {
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer expectedTrainer = new PokemonTrainer("Lucas", Team.MYSTIC, mock(IPokedex.class));
        when(pokemonTrainerFactory.createTrainer("Lucas", Team.MYSTIC, pokedexFactory)).thenReturn(expectedTrainer);
        PokemonTrainer createdTrainer = pokemonTrainerFactory.createTrainer("Lucas", Team.MYSTIC, pokedexFactory);

        assertNotNull(createdTrainer);
        assertEquals("Lucas", createdTrainer.getName());
        assertEquals(Team.MYSTIC, createdTrainer.getTeam());
        assertEquals(expectedTrainer.getPokedex(), createdTrainer.getPokedex());
    }
}