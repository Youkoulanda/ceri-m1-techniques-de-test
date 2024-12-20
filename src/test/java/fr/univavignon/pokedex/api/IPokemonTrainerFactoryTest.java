package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the PokemonTrainerFactory class.
 * Ensures proper creation of PokemonTrainer instances and validates exceptions for invalid inputs.
 */
public class IPokemonTrainerFactoryTest {

    private PokemonTrainerFactory trainerFactory;
    private PokemonMetadataProvider metadataProvider;
    private PokemonFactory pokemonFactory;
    private PokedexFactory pokedexFactory;

    @Before
    public void init() {
        // Initialize dependencies for the PokemonTrainerFactory
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedexFactory = new PokedexFactory();
        trainerFactory = new PokemonTrainerFactory(metadataProvider, pokemonFactory);
    }

    @Test
    public void testCreateTrainerValid() {
        PokemonTrainer trainer = trainerFactory.createTrainer("Bulbizarre", Team.VALOR, pokedexFactory);

        // Validate trainer properties
        Assert.assertNotNull("Trainer should not be null", trainer);
        Assert.assertEquals("Trainer name should be 'Bulbizarre'", "Bulbizarre", trainer.getName());
        Assert.assertEquals("Trainer team should be 'VALOR'", Team.VALOR, trainer.getTeam());
        Assert.assertNotNull("Pokedex should not be null", trainer.getPokedex());
        Assert.assertEquals("Pokedex should be empty", 0, trainer.getPokedex().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithNullName() {
        // Test with null name
        trainerFactory.createTrainer(null, Team.VALOR, pokedexFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithEmptyName() {
        // Test with empty name
        trainerFactory.createTrainer("", Team.VALOR, pokedexFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithNullTeam() {
        // Test with null team
        trainerFactory.createTrainer("Bulbizarre", null, pokedexFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithNullPokedexFactory() {
        // Test with null pokedex factory
        trainerFactory.createTrainer("Bulbizarre", Team.VALOR, null);
    }
}
