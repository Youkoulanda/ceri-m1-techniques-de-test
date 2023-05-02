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
	PokemonMetadataProvider pokemonMetaDataProvider;
	PokemonFactory pokemonFactory;
	
	@Before
	public void setup() {
		pokedexFactory = mock(IPokedexFactory.class);
		pokedex = new Pokedex(pokemonMetaDataProvider, pokemonFactory);
	}

	@Test
	public void checkAddPokemon() {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		
		assertEquals(0, pokedex.addPokemon(pokemon));
	}
	
	@Test
	public void checkGetPokemon() throws PokedexException {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		
		assertEquals(pokemon, pokedex.getPokemon(0));
	}
	
	@Test
	public void checkGetPokemons(){
		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pokemon2 = new Pokemon(2, "Aquali", 186, 168, 260, 2729, 202, 5000, 40, 100);
		
		List<Pokemon> pokemons = new ArrayList();
				
		pokemons.add(pokemon1);
		pokemons.add(pokemon2);
		
		assertEquals(40, pokedex.getPokemons().get(1).getCandy());
	}
	
}
