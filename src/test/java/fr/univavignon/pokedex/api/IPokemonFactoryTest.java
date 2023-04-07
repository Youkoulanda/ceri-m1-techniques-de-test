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
		
		pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		
		Mockito
		.when(pokemonFactoryMock.createPokemon(index, 10, 20, 2, 3))
		.thenReturn(pokemon);
	
		
		assertEquals(pokemon.getCp(), 613);
		assertEquals(pokemon.getHp(), 64);
		assertEquals(pokemon.getDust(), 4000);
		assertEquals(pokemon.getCandy(), 4);
		assertEquals(pokemon.getIv(), 56, 0.001);
		
	}
}
