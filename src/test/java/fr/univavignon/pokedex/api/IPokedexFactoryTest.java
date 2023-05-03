package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
	
	IPokedexFactory pokedexFactory;
	IPokedex pokedex;
	IPokemonMetadataProvider pokemonMetaDataProvider;
	IPokemonFactory pokemonFactory;
	String name = "Bulbizarre";
	int attack = 126;
	int defense = 126;
	int stamina = 90;
	
	@Before
	public void setup() {
		HashMap<Integer, PokemonMetadata> pokemonMetadata = new HashMap<Integer, PokemonMetadata>();
		pokemonMetadata.put(0, new PokemonMetadata(0, name, attack, defense, stamina));
		pokemonMetadata.put(0, new PokemonMetadata(133, "Aquali", 186, 168, 260));
		pokemonMetaDataProvider = new PokemonMetadataProvider(pokemonMetadata);
		pokemonFactory = new PokemonFactory(pokemonMetaDataProvider);
		pokedexFactory = new PokedexFactory(pokemonMetaDataProvider, pokemonFactory);
	}
	

	@Test
	public void checkCreatePokedex() {
		
		IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetaDataProvider, pokemonFactory);
		
		assertEquals(Pokedex.class, pokedex.getClass());
			
	}
	
	
	
}
