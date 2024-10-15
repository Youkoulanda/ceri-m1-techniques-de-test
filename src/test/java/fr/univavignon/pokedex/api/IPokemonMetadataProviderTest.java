package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {


   @Test
    public void getPokemonMetadataTest() throws PokedexException{
        IPokemonMetadataProvider iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
       // Pokemon Aquali = new Pokemon(133,"Aquali",186,168, 	260,2729, 	202,5000,4, 	100);
        PokemonMetadata pokemonMetadataAquali = new  PokemonMetadata(133, "Aquali", 186, 168, 260);
        Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadataAquali);
        assertTrue(iPokemonMetadataProvider.getPokemonMetadata(133).equals(pokemonMetadataAquali));

    }

}
