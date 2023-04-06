package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

	IPokemonFactory pokemonFactory;
	Pokemon bulbizarre;
	Pokemon aquali;

	@Before
	public void init() {
		pokemonFactory = Mockito.mock(IPokemonFactory.class);
		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
		aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
	}

	@Test
	public void testCreatePokemon() {
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
		Mockito.when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
		Assert.assertEquals(bulbizarre, pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
		Assert.assertEquals(aquali, pokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
	}

}
