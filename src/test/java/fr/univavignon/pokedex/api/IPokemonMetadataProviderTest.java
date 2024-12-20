package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {


     @Test
    public void getPokemonMetadataBoundaryTest() throws PokedexException {
        IPokemonMetadataProvider iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        PokemonMetadata pokemonMetadataBulbasaur = new PokemonMetadata(0, "Bulbasaur", 118, 118, 90);

        Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadataBulbasaur);

        PokemonMetadata result = iPokemonMetadataProvider.getPokemonMetadata(0);

        assertNotNull("The result should not be null", result);
        assertEquals("The index should be 0", 0, result.getIndex());
        assertEquals("The name should be Bulbasaur", "Bulbasaur", result.getName());
    }

     @Test
    public void getPokemonMetadataEqualityTest() throws PokedexException {
        IPokemonMetadataProvider iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        PokemonMetadata pokemonMetadataCharizard = new PokemonMetadata(6, "Charizard", 223, 173, 186);

        Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(6)).thenReturn(pokemonMetadataCharizard);

        PokemonMetadata result1 = iPokemonMetadataProvider.getPokemonMetadata(6);
        PokemonMetadata result2 = iPokemonMetadataProvider.getPokemonMetadata(6);

        assertSame("The objects should be the same", result1, result2);
    }

    @Test(expected = PokedexException.class)
    public void getPokemonMetadataInvalidIndexTest() throws PokedexException {
        IPokemonMetadataProvider iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));

        iPokemonMetadataProvider.getPokemonMetadata(-1);
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        IPokemonMetadataProvider iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        PokemonMetadata pokemonMetadataAquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        
        Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadataAquali);
        
        PokemonMetadata result = iPokemonMetadataProvider.getPokemonMetadata(133);
        
        assertNotNull("The result should not be null", result);
        assertEquals("The index should be 133", 133, result.getIndex());
        assertEquals("The name should be Aquali", "Aquali", result.getName());
        assertEquals("The attack should be 186", 186, result.getAttack());
        assertEquals("The defense should be 168", 168, result.getDefense());
        assertEquals("The stamina should be 260", 260, result.getStamina());
    }


}
