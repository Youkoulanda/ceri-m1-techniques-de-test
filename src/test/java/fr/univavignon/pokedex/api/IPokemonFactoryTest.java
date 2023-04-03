package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

//@Category(IPokemonFactory.class)
public class IPokemonFactoryTest {
	
	private IPokemonFactory pokemonFactory;
	private Pokemon pokemon;
	private int index;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void checkCreatePokemon(int index) {
		
		pokemon = pokemonFactory.createPokemon(index, 10, 20, 2, 3);
		
		assertEquals(pokemon.getCp(), 10);
		assertEquals(pokemon.getHp(), 20);
		assertEquals(pokemon.getDust(), 2);
		assertEquals(pokemon.getCandy(), 3);
		
	}
}
