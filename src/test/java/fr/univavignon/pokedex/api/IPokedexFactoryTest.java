package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Initialize mock dependencies
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);

        // Configure the behavior of the pokedexFactory mock
        pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedexMock = mock(IPokedex.class); // Create a mock IPokedex instance
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedexMock); // Specify the behavior of the factory method
    }

    @Test
    public void testCreatePokedex() {
        // Create a Pokedex instance using the factory
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Verify that the created Pokedex instance is not null
        assertNotNull(pokedex);
    }
}
