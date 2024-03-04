package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;
    private PokemonMetadata expectedMetadata;

    @Before
    public void setUp() {
        // Create mock instance of IPokemonMetadataProvider
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);

        // Create expected metadata
        expectedMetadata = new PokemonMetadata(0, "bulbizarre", 126, 126, 90);
    }

    @Test
    public void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        // Stub the method call
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(expectedMetadata);

        // Call the method to be tested
        PokemonMetadata actualMetadata = pokemonMetadataProvider.getPokemonMetadata(0);

        // Verify that the metadata returned matches the expected metadata
        assertEquals(expectedMetadata, actualMetadata);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        // Stub the method call to throw an exception
        when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));

        // Call the method with an invalid index, expecting an exception
        pokemonMetadataProvider.getPokemonMetadata(-1);
    }
}
