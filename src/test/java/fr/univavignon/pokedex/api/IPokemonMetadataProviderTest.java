package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class PokemonMetadataProviderTest {

    private PokemonMetadataProvider pokemonMetadataProvider;
    private PokemonMetadata expectedMetadata;

    @Before
    public void setUp() {
        // Create an instance of PokemonMetadataProvider
        pokemonMetadataProvider = new PokemonMetadataProvider();

        // Create expected metadata
        expectedMetadata = new PokemonMetadata(0, "Bulbizzare", 126, 126, 90);
    }

    @Test
    public void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        // Call the method to be tested
        PokemonMetadata actualMetadata = pokemonMetadataProvider.getPokemonMetadata(0);

        // Verify that the metadata returned matches the expected metadata
        assertEquals(expectedMetadata, actualMetadata);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        // Call the method with an invalid index, expecting an exception
        pokemonMetadataProvider.getPokemonMetadata(-1);
    }

    @Test
    public void testGetStamina() {
        // Test the getStamina() method
        assertEquals(90, expectedMetadata.getStamina());
    }

    @Test
    public void testGetDefense() {
        // Test the getDefense() method
        assertEquals(126, expectedMetadata.getDefense());
    }

    @Test
    public void testGetAttack() {
        // Test the getAttack() method
        assertEquals(126, expectedMetadata.getAttack());
    }

    @Test
    public void testGetName() {
        // Test the getName() method
        assertEquals("Bulbizarre", expectedMetadata.getName());
    }
}
