package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;

//@Category(IPokemonMetaDataProvider.class)
public class IPokemonMetaDataProviderTest {

	private IPokemonMetadataProvider pokemonMetaDataProvider;
	int indexTooBig = 151;
	int indexTooSmall = -1;
	String name = "Carapuce";
	int attack = 4;
	int defense = 5;
	int stamina = 6;
	
	//Test that PokemonMetadata throws an error if index is out of range
	
	@Before
	public void setup() {
		pokemonMetaDataProvider = mock(IPokemonMetadataProvider.class);
	}
	
	@Test
	public void indexTooSmall() throws PokedexException{
		
		int indexTooSmall = -1;
		
		Mockito
		.when(pokemonMetaDataProvider.getPokemonMetadata(indexTooSmall))
		.thenThrow(new PokedexException("Index out of range"));
			
		assertThrows(PokedexException.class, () -> {
			pokemonMetaDataProvider.getPokemonMetadata(indexTooSmall);
        });
	
	}
	
	public void indexTooBig() throws PokedexException{
		
		int indexTooBig = 151;
		
		Mockito
		.when(pokemonMetaDataProvider.getPokemonMetadata(indexTooBig))
		.thenThrow(new PokedexException("Index out of range"));
		
		assertThrows(PokedexException.class, () -> {
			pokemonMetaDataProvider.getPokemonMetadata(indexTooBig);
        });
	
	}
	
	
	@Test
	public void checkGetPokemonMetaData() throws PokedexException {
		
		int index = 3;
		PokemonMetadata pokemonMetaData = new PokemonMetadata(index, name, attack, defense, stamina);
		
		Mockito
		.when(pokemonMetaDataProvider.getPokemonMetadata(index))
		.thenReturn(pokemonMetaData);
		
		assertEquals(name ,pokemonMetaData.getName());
		assertEquals(attack ,pokemonMetaData.getAttack());
		assertEquals(defense ,pokemonMetaData.getDefense());
		assertEquals(stamina ,pokemonMetaData.getStamina());
		
	}
		
	
}