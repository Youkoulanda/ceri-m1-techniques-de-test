package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.HashMap;

import org.junit.Before;

//@Category(IPokemonMetaDataProvider.class)
public class IPokemonMetaDataProviderTest {

	private IPokemonMetadataProvider pokemonMetaDataProvider;
	int indexTooBig = 151;
	int indexTooSmall = -1;
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
	}
	
	@Test
	public void indexTooSmall() throws PokedexException{
		
		int indexTooSmall = -1;
			
		assertThrows(PokedexException.class, () -> {
			pokemonMetaDataProvider.getPokemonMetadata(indexTooSmall);
        });
	
	}
	
	public void indexTooBig() throws PokedexException{
		
		int indexTooBig = 151;
		
		assertThrows(PokedexException.class, () -> {
			pokemonMetaDataProvider.getPokemonMetadata(indexTooBig);
        });
	
	}
	
	
	@Test
	public void checkGetPokemonMetaData() throws PokedexException {
		
		int index = 3;
		PokemonMetadata pokemonMetaData = new PokemonMetadata(index, name, attack, defense, stamina);
		
		assertEquals(name ,pokemonMetaData.getName());
		assertEquals(attack ,pokemonMetaData.getAttack());
		assertEquals(defense ,pokemonMetaData.getDefense());
		assertEquals(stamina ,pokemonMetaData.getStamina());
		
	}
		
	
}