package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;
    /**
     *
     */
    private PokemonMetadata aquali;
    private PokemonMetadata bulbizarre;

    /**
     * Initialization of the objects required for the tests.
     * This method is executed before each test to set up the test environment.
     */
    @Before
    public void init() {

        // Initializing the factory for Pokedex and other dependencies
        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);

        // Creating Pokemon metadata objects for testing
        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
    }

    /**
     * Test for the creation of a Pokedex.
     * This test verifies that the `createPokedex` method correctly creates a Pokedex object.
     */
    @Test
    public void testCreatePokedex() {
        // Creating the Pokedex using the factory
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Verifying that the created Pokedex is not null
        Assert.assertNotNull(createdPokedex);

        // Verifying that the created instance is indeed an object of type Pokedex
        Assert.assertTrue(createdPokedex instanceof Pokedex);
    }
}
