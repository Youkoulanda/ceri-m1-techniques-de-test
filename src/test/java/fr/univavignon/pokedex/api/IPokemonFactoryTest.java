package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

//@Category(IPokemonFactory.class)
public class IPokemonFactoryTest {
	
	private IPokemonFactory pokemonFactory;
	private IPokemonFactory pokemonFactoryMock;
	private Pokemon pokemon;
	private int index;
	
	@Before
	public void setup() {
		pokemonFactoryMock = mock(IPokemonFactory.class);
	}
	
	@Test
	public void checkCreatePokemon() {
		
		pokemon = new Pokemon(index, "Pikachu", 10, 20, 30, 7, 8, 9, 10, 11);
		
		Mockito
		.when(pokemonFactoryMock.createPokemon(index, 10, 20, 2, 3))
		.thenReturn(pokemon);
	
		
		assertEquals(pokemon.getCp(), 10);
		assertEquals(pokemon.getHp(), 20);
		assertEquals(pokemon.getDust(), 2);
		assertEquals(pokemon.getCandy(), 3);
		
	}
}
