package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {
	
	IPokedexFactory pokedexFactory;
	IPokedex pokedex;
	String name = "Bulbizarre";
	int attack = 126;
	int defense = 126;
	int stamina = 90;
	
	@Before
	public void setup() {
		HashMap<Integer, PokemonMetadata> pokemonMetadata = new HashMap<Integer, PokemonMetadata>();
		pokemonMetadata.put(0, new PokemonMetadata(0, name, attack, defense, stamina));
		pokemonMetadata.put(0, new PokemonMetadata(133, "Aquali", 186, 168, 260));
		IPokemonMetadataProvider pokemonMetaDataProvider = new PokemonMetadataProvider(pokemonMetadata);
		IPokemonFactory pokemonFactory = new PokemonFactory(pokemonMetaDataProvider);
		pokedexFactory = new PokedexFactory(pokemonMetaDataProvider, pokemonFactory);
		pokedex = new Pokedex(pokemonMetaDataProvider, pokemonFactory);
	}

	@Test
	public void checkAddPokemon() {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		
		assertEquals(0, pokedex.addPokemon(pokemon));
	}
	
	@Test
	public void checkGetPokemon() throws PokedexException {
		Pokemon pokemon = new Pokemon(2, "Aquali", 186, 168, 260, 2729, 202, 5000, 40, 100);
		
		pokedex.addPokemon(pokemon);
		
		assertEquals(pokemon, pokedex.getPokemon(2));
	}
	
	@Test
	public void checkGetPokemons(){
		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pokemon2 = new Pokemon(2, "Aquali", 186, 168, 260, 2729, 202, 5000, 40, 100);
		
		List<Pokemon> pokemons = new ArrayList();
				
		pokedex.addPokemon(pokemon1);
		pokedex.addPokemon(pokemon2);
		
		assertEquals(pokemon1, pokedex.getPokemons().get(0));
	}
	
}
