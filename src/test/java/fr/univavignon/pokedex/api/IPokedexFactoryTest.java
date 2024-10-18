package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex pokedex = mock(IPokedex.class);

        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        IPokedex result = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(result);
    }
}
