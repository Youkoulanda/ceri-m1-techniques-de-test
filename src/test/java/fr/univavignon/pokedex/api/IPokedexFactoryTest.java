package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;
    private PokemonMetadata aquali;
    private PokemonMetadata bulbizarre;

    @Before
    public void init() {

        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);

        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        Assert.assertNotNull(createdPokedex);  // Vérifie que le Pokedex n'est pas nul
        Assert.assertTrue(createdPokedex instanceof Pokedex);  // Vérifie que l'instance est bien un Pokedex
    }
}
