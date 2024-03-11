package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @Before
    public void setUp() {
        // Initialize mock Trainer factory
        trainerFactory = mock(IPokemonTrainerFactory.class);

        // Initialize mock Pokedex factory
        pokedexFactory = mock(IPokedexFactory.class);

        // Initialize mock Pokedex
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testCreateTrainer() {
        // Define trainer attributes
        String name = "Sacha du bourg-palette";
        Team team = Team.INSTINCT;

        // Create a sample trainer
        PokemonTrainer trainer = new PokemonTrainer(name, team, pokedex);

        // Configure the mock to return the sample trainer when creating a trainer
        when(trainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(trainer);

        // Call the method under test
        PokemonTrainer createdTrainer = trainerFactory.createTrainer(name, team, pokedexFactory);

        // Verify that the created trainer is not null
        assertNotNull(createdTrainer);

        // Verify that the trainer's pokedex, team, and name match the expected values
        assertEquals(pokedex, createdTrainer.getPokedex());
        assertEquals(team, createdTrainer.getTeam());
        assertEquals(name, createdTrainer.getName());
    }
}
