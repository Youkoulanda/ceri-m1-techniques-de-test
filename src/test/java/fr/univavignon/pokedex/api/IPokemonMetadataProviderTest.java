package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeEach
    public void setUp() {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        PokemonMetadata expectedMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(expectedMetadata);
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);

        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("bad index"));
        assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(999));
    }
}