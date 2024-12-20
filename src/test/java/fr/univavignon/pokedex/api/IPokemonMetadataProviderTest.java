package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the IPokemonMetadataProvider interface.
 * These tests verify the functionality of the getPokemonMetadata method
 * with valid and invalid Pokémon indexes.
 */
public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;
    private PokemonMetadata Bulbizarre;
    private PokemonMetadata Aquali;

    /**
     * Initialization method to prepare the necessary objects before each test.
     * This method runs before each test to set up the testing environment.
     */
    @Before
    public void init() {
        // Initialize the Pokémon metadata provider and test Pokémon data
        pokemonMetadataProvider = new PokemonMetadataProvider();
        Bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        Aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
    }

    /**
     * Tests the getPokemonMetadata method with different valid and invalid Pokémon indexes.
     * This test ensures that the correct Pokémon metadata is returned for valid indexes
     * and appropriate exceptions are thrown for invalid indexes.
     *
     * @throws PokedexException If an error occurs during the test execution
     */
    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Test for a valid Pokémon (index 0: Bulbasaur)
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        Assert.assertEquals(Bulbizarre.getIndex(), metadata.getIndex());
        Assert.assertEquals(Bulbizarre.getName(), metadata.getName());
        Assert.assertEquals(Bulbizarre.getAttack(), metadata.getAttack());
        Assert.assertEquals(Bulbizarre.getDefense(), metadata.getDefense());
        Assert.assertEquals(Bulbizarre.getStamina(), metadata.getStamina());

        // Test for another valid Pokémon (index 133: Vaporeon)
        metadata = pokemonMetadataProvider.getPokemonMetadata(133);
        Assert.assertEquals(Aquali.getIndex(), metadata.getIndex());
        Assert.assertEquals(Aquali.getName(), metadata.getName());
        Assert.assertEquals(Aquali.getAttack(), metadata.getAttack());
        Assert.assertEquals(Aquali.getDefense(), metadata.getDefense());
        Assert.assertEquals(Aquali.getStamina(), metadata.getStamina());

        // Test for an invalid index (negative index)
        try {
            pokemonMetadataProvider.getPokemonMetadata(-189);
            Assert.fail("Expected exception");
        } catch (PokedexException e) {
            Assert.assertEquals("Pokemon not found", e.getMessage());
        }

        // Test for an index that is too large (out of bounds)
        try {
            pokemonMetadataProvider.getPokemonMetadata(313);
            Assert.fail("Expected exception");
        } catch (PokedexException e) {
            // Verify that the exception message is as expected
            Assert.assertEquals("Pokemon not found", e.getMessage());
        }
    }
}
