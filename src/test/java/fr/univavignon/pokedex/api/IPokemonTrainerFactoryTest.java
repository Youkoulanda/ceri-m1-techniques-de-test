package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        // Initialize mock Pokedex factory
        pokedexFactory = mock(IPokedexFactory.class);

        // Initialize trainer factory
        trainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        // Define trainer attributes
        String name = "Ash Ketchum";
        Team team = Team.MYSTIC;

        // Create mock Pokedex
        IPokedex pokedex = mock(IPokedex.class);

        // Configure Pokedex factory mock to return the mock Pokedex
        when(pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory(new PokemonMetadataProvider()))).thenReturn(pokedex);

        // Call the method under test
        PokemonTrainer trainer = trainerFactory.createTrainer(name, team, pokedexFactory);

        // Verify that the created trainer is not null
        assertNotNull(trainer);

        // Verify that the trainer's name and team match the expected values
        assertEquals(name, trainer.getName());
        assertEquals(team, trainer.getTeam());

        // Verify that the trainer's pokedex is the mock Pokedex
        assertEquals(pokedex, trainer.getPokedex());
    }
}
