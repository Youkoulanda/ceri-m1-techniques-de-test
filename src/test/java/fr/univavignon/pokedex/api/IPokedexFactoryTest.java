package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokedexFactoryTest {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex, "The pokedex instance should not be null.");
        // Additional validation can be performed here to verify the correct configuration of the pokedex instance.
    }
}
