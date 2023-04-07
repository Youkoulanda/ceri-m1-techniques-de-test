package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
	
	IPokedexFactory pokedexFactory;
	IPokedex pokedex;
	IPokemonMetadataProvider pokemonMetaDataProvider;
	IPokemonFactory pokemonFactory;

	
	@Before
	public void setup() {
		pokedexFactory = mock(IPokedexFactory.class);
		pokedex = mock(IPokedex.class);
		pokemonMetaDataProvider = mock(IPokemonMetadataProvider.class);
		pokemonFactory = mock(IPokemonFactory.class);
	}
	

	@Test
	public void checkCreatePokedex() {
		
		Mockito
		.when(pokedexFactory.createPokedex(pokemonMetaDataProvider, pokemonFactory))
		.thenReturn(pokedex);
		
		IPokedex pokedex2 = pokedexFactory.createPokedex(pokemonMetaDataProvider, pokemonFactory);
		
		assertEquals(0, pokedex2.size());
			
	}
	
	
	
}
