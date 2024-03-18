package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Initialize real implementations of dependencies
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);

        // Create an instance of the PokedexFactory
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        // Create a Pokedex instance using the factory
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Verify that the created Pokedex instance is not null
        assertNotNull(pokedex);
    }
}
