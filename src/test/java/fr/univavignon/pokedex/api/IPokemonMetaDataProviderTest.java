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

	private PokemonMetadata pokemonMetaDada;
	private Pokemon pokemon;
	int index = 3;
	int indexTooBig = 151;
	int indexTooSmall = -1;
	String name = "Carapuce";
	int attack = 4;
	int defense = 5;
	int stamina = 6;
	
	//Test that PokemonMetadata throws an error if index is out of range
	
	@Test
	public void checkIndexRange() {
		
		/** TODO: Change IllegalArgumentException by PokedexException once exception is implemented **/
		
		assertThrows(IllegalArgumentException.class, () -> {
            if(indexTooBig < 0 || indexTooBig > 150) {
                throw new IllegalArgumentException("Index out of range");
            }
        });
		
		assertThrows(IllegalArgumentException.class, () -> {
            if(indexTooSmall < 0 || indexTooSmall > 150) {
                throw new IllegalArgumentException("Index out of range");
            }
        });
	
	}
	
	//Test that getPokemonMetadata returns an object of type PokemonMetadata
	
	
	@Before
	public void setup() {
		
		pokemonMetaDada = new PokemonMetadata(index, name, attack, defense, stamina);
		pokemon = new Pokemon(index, name, attack, defense, stamina, 7, 8, 9, 10, 11);
		
		
	}
	
	@Test
	public void checkReturnsPokemonMetaData() {
		
		assertEquals(pokemon.getName(), name);
		assertEquals(pokemonMetaDada.getAttack(), attack);
		assertEquals(pokemon.getDefense(), defense);
		assertEquals(pokemon.getStamina(), stamina);
		
	}
	
	//Test that when you create a Pokemon its attack, defense and stamina are added
	//to the its Metadata 
	
//	@Before
//	public void setup() {
//		pokemon = new Pokemon(index, name, attack, defense, stamina, 7, 8, 9, 10, 11);
//		
//		PokemonMetadata mockito = mock(PokemonMetadata.class);
//		
//		mockito.when(PokemonMetadata.getPokemonMetadata(index)
//		.thenReturn(mockito));
		
	
}