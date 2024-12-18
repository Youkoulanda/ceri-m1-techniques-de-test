package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the IPokemonTrainerFactory implementation.
 * This class ensures the correct behavior of the PokemonMetadataProvider when retrieving Pokémon metadata.
 */
public class IPokemonTrainerFactoryTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    private PokemonMetadata aquali;
    private PokemonMetadata bulbizarre;

    /**
     * Initializes the test environment before each test.
     * Sets up the metadata provider and predefined metadata objects for validation.
     */
    @Before
    public void init() {
        pokemonMetadataProvider = new PokemonMetadataProvider();

        // Create metadata objects for Bulbizarre and Aquali to use in assertions
        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
    }

    /**
     * Tests the getPokemonMetadata method to ensure it returns correct metadata for valid Pokémon indices
     * and throws appropriate exceptions for invalid indices.
     */
    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Test case: Valid Pokémon index (0: Bulbizarre)
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        Assert.assertEquals(bulbizarre.getIndex(), metadata.getIndex());
        Assert.assertEquals(bulbizarre.getName(), metadata.getName());
        Assert.assertEquals(bulbizarre.getAttack(), metadata.getAttack());
        Assert.assertEquals(bulbizarre.getDefense(), metadata.getDefense());
        Assert.assertEquals(bulbizarre.getStamina(), metadata.getStamina());

        // Test case: Valid Pokémon index (133: Aquali)
        metadata = pokemonMetadataProvider.getPokemonMetadata(133);
        Assert.assertEquals(aquali.getIndex(), metadata.getIndex());
        Assert.assertEquals(aquali.getName(), metadata.getName());
        Assert.assertEquals(aquali.getAttack(), metadata.getAttack());
        Assert.assertEquals(aquali.getDefense(), metadata.getDefense());
        Assert.assertEquals(aquali.getStamina(), metadata.getStamina());

        // Test case: Invalid index (negative value)
        try {
            pokemonMetadataProvider.getPokemonMetadata(-189);
            Assert.fail("Expected exception");
        } catch (PokedexException e) {
            // Verify that the exception message matches the expected error
            Assert.assertEquals("Pokemon not found", e.getMessage());
        }

        // Test case: Invalid index (too large)
        try {
            pokemonMetadataProvider.getPokemonMetadata(313);
            Assert.fail("Expected exception");
        } catch (PokedexException e) {
            // Verify that the exception message matches the expected error
            Assert.assertEquals("Pokemon not found", e.getMessage());
        }
    }
}
