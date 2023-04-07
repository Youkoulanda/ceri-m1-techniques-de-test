package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {
	
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
	public void checkAddPokemon() {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		
		Mockito
		.when(pokedex.addPokemon(pokemon))
		.thenReturn(pokemon.getIndex());
		
		assertEquals(0, pokedex.addPokemon(pokemon));
	}
	
	@Test
	public void checkGetPokemon() throws PokedexException {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		
		Mockito
		.when(pokedex.getPokemon(0))
		.thenReturn(pokemon);
		
		assertEquals(pokemon, pokedex.getPokemon(0));
	}
	
	@Test
	public void checkGetPokemons(){
		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pokemon2 = new Pokemon(2, "Aquali", 186, 168, 260, 2729, 202, 5000, 40, 100);
		
		List<Pokemon> pokemons = new ArrayList();
				
		pokemons.add(pokemon1);
		pokemons.add(pokemon2);
		
		Mockito
		.when(pokedex.getPokemons())
		.thenReturn(pokemons);
		
		assertEquals(40, pokedex.getPokemons().get(1).getCandy());
	}
	
}
