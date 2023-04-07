package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
	
	IPokedexFactory pokedexFactory;
	IPokemonTrainerFactory pokedexTrainerFactory;
	IPokedex pokedex;
	
	
	@Before
	public void setup() {
		pokedexFactory = mock(IPokedexFactory.class);
		pokedexTrainerFactory = mock(IPokemonTrainerFactory.class);
		pokedex = mock(IPokedex.class);
	}
	
	@Test
	public void checkCreatePokedex() {
		
		PokemonTrainer pokemonTrainer = new PokemonTrainer("Sasha", Team.MYSTIC , pokedex);
		
		Mockito
		.when(pokedexTrainerFactory.createTrainer("Sasha", Team.MYSTIC , pokedexFactory))
		.thenReturn(pokemonTrainer);
		
		PokemonTrainer pokemonTrainer2 = pokedexTrainerFactory.createTrainer("Sasha", Team.MYSTIC , pokedexFactory);
		
		assertEquals(pokemonTrainer2.getName(), pokemonTrainer.getName());
			
	}

}
