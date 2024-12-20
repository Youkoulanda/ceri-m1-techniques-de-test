package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

   @Test
    public void createPokedex() {
        IPokedexFactory iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex pokedex = Mockito.mock(IPokedex.class);

        Mockito.when(iPokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        IPokedex result = iPokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull("The created Pokedex should not be null", result);
        assertEquals("The returned Pokedex should match the mock instance", pokedex, result);
    }

    @Test
    public void createPokedexWithValidProviders() {
        IPokedexFactory iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex expectedPokedex = Mockito.mock(IPokedex.class);

        Mockito.when(iPokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(expectedPokedex);

        IPokedex actualPokedex = iPokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull("The Pokedex should not be null", actualPokedex);
        assertSame("The returned Pokedex should be the expected instance", expectedPokedex, actualPokedex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createPokedexWithNullMetadataProvider() {
        IPokedexFactory iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

        Mockito.when(iPokedexFactory.createPokedex(null, pokemonFactory)).thenThrow(new IllegalArgumentException("Metadata provider cannot be null"));

        iPokedexFactory.createPokedex(null, pokemonFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createPokedexWithNullPokemonFactory() {
        IPokedexFactory iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        Mockito.when(iPokedexFactory.createPokedex(metadataProvider, null)).thenThrow(new IllegalArgumentException("Pokemon factory cannot be null"));

        iPokedexFactory.createPokedex(metadataProvider, null);
    }

    @Test
    public void createPokedexEqualityTest() {
        IPokedexFactory iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex pokedex1 = Mockito.mock(IPokedex.class);
        IPokedex pokedex2 = Mockito.mock(IPokedex.class);

        Mockito.when(iPokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex1).thenReturn(pokedex2);

        IPokedex result1 = iPokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        IPokedex result2 = iPokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotSame("Each call should return a different Pokedex instance", result1, result2);
    }

}
