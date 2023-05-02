package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

//@Category(IPokemonFactory.class)
public class IPokemonFactoryTest {
	
	private IPokemonFactory pokemonFactory;
	private IPokemonFactory pokemonFactoryMock;
	private Pokemon pokemon;
	private int index;
	String name = "Bulbizarre";
	int attack = 126;
	int defense = 126;
	int stamina = 90;
	
	@Before
	public void setup() {
		HashMap<Integer, PokemonMetadata> pokemonMetadata = new HashMap<Integer, PokemonMetadata>();
		pokemonMetadata.put(0, new PokemonMetadata(0, name, attack, defense, stamina));
		pokemonMetadata.put(0, new PokemonMetadata(133, "Aquali", 186, 168, 260));
		PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider(pokemonMetadata);
		pokemonFactoryMock = new PokemonFactory(pokemonMetadataProvider);
	}
	
	@Test
	public void checkCreatePokemon() {
		
		pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		
		assertEquals(pokemon.getCp(), 613);
		assertEquals(pokemon.getHp(), 64);
		assertEquals(pokemon.getDust(), 4000);
		assertEquals(pokemon.getCandy(), 4);
		assertEquals(pokemon.getIv(), 56, 0.001);
		
	}
}
