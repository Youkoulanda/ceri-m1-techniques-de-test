package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Comparator;
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

//	@Test
//	public void checkAddPokemonIndexExcpetions() {
//		int indexTooSml = -1;
//		int indexTooBig = 151;
//		
//		assertThrows(PokedexException.class, () -> {
//			pokedex.addPokemon(new Pokemon(indexTooSml, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
//        });
//		
//		assertThrows(PokedexException.class, () -> {
//			pokedex.addPokemon(new Pokemon(indexTooBig, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
//        });
//	}

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
	public void checkGetPokemons() {
		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 40, 100);

		List<Pokemon> pokemons = new ArrayList();

		pokedex.addPokemon(pokemon1);
		pokedex.addPokemon(pokemon2);

		assertEquals(pokemon1, pokedex.getPokemons().get(0));
		// assertEquals(pokemon2, pokedex.getPokemons().get(133));
	}

	class IndexComparator implements Comparator<Pokemon> {
		List<Pokemon> pokemons;

		public IndexComparator(List<Pokemon> pokemons) {
			this.pokemons = pokemons;
		}

		@Override
		public int compare(Pokemon p1, Pokemon p2) {
			return Integer.compare(p1.getIndex(), p2.getIndex());
		}
	}

	@Test
	public void checkGetPokemonsOrdered() {
		Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 40, 100);
		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

		List<Pokemon> pokemons = new ArrayList();

		pokedex.addPokemon(pokemon2);
		pokedex.addPokemon(pokemon1);

		Comparator<Pokemon> order = new IndexComparator(pokemons);

//		assertEquals(pokemon1, pokedex.getPokemons(order).get(0));
//		assertEquals(pokemon2, pokedex.getPokemons(order).get(1));

	}

}
