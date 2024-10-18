package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadataExample1() throws PokedexException {
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(metadata);

        PokemonMetadata result = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbizarre", result.getName());
        assertEquals(126, result.getAttack());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));

        pokemonMetadataProvider.getPokemonMetadata(-1); // Should throw exception
    }
}
