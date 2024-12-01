package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;
    private PokemonMetadata vaporeon;
    private PokemonMetadata bulbasaur;

    @Before
    public void init() {
        // Using the real implementation of the metadata provider
        pokemonMetadataProvider = new PokemonMetadataProvider();

        // Initializing the PokemonMetadata objects for testing
        bulbasaur = new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);
        vaporeon = new PokemonMetadata(133, "Vaporeon", 186, 186, 260);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Test for a valid Pokémon (index 0: Bulbasaur)
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        Assert.assertEquals(bulbasaur.getIndex(), metadata.getIndex());
        Assert.assertEquals(bulbasaur.getName(), metadata.getName());
        Assert.assertEquals(bulbasaur.getAttack(), metadata.getAttack());
        Assert.assertEquals(bulbasaur.getDefense(), metadata.getDefense());
        Assert.assertEquals(bulbasaur.getStamina(), metadata.getStamina());

        // Test for another valid Pokémon (index 133: Vaporeon)
        metadata = pokemonMetadataProvider.getPokemonMetadata(133);
        Assert.assertEquals(vaporeon.getIndex(), metadata.getIndex());
        Assert.assertEquals(vaporeon.getName(), metadata.getName());
        Assert.assertEquals(vaporeon.getAttack(), metadata.getAttack());
        Assert.assertEquals(vaporeon.getDefense(), metadata.getDefense());
        Assert.assertEquals(vaporeon.getStamina(), metadata.getStamina());

        // Test for an invalid index (negative index)
        try {
            pokemonMetadataProvider.getPokemonMetadata(-189);
            Assert.fail("Expected exception");
        } catch (PokedexException e) {
            Assert.assertEquals("Pokemon not found", e.getMessage());
        }

        // Test for an index too large
        try {
            pokemonMetadataProvider.getPokemonMetadata(313);
            Assert.fail("Expected exception");
        } catch (PokedexException e) {
            Assert.assertEquals("Pokemon not found", e.getMessage());
        }
    }
}
