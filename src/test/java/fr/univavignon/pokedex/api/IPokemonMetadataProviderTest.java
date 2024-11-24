package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @BeforeEach
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        int index = 1;
        PokemonMetadata mockMetadata = new PokemonMetadata(index, "Pikachu", 55, 40, 35); // Adjusted constructor params

        when(metadataProvider.getPokemonMetadata(index)).thenReturn(mockMetadata);

        PokemonMetadata retrievedMetadata = metadataProvider.getPokemonMetadata(index);

        assertNotNull(retrievedMetadata);
        assertEquals(mockMetadata, retrievedMetadata);
    }

    @Test
    public void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        int invalidIndex = -1;

        when(metadataProvider.getPokemonMetadata(invalidIndex)).thenThrow(new PokedexException("Invalid index"));

        try {
            metadataProvider.getPokemonMetadata(invalidIndex);
        } catch (PokedexException e) {
            assertEquals("Invalid index", e.getMessage());
        }
    }
}
