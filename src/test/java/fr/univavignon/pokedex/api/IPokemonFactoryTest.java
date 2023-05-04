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
	private int index = 133;
	String name = "Bulbizarre";
	int attack = 126;
	int defense = 126;
	int stamina = 90;
	
	@Before
	public void setup() {
		HashMap<Integer, PokemonMetadata> pokemonMetadata = new HashMap<Integer, PokemonMetadata>();
		pokemonMetadata.put(0, new PokemonMetadata(0, name, attack, defense, stamina));
		pokemonMetadata.put(index, new PokemonMetadata(index, "Aquali", 186, 168, 260));
		PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider(pokemonMetadata);
		pokemonFactory = new PokemonFactory(pokemonMetadataProvider);
	}
	
	@Test
	public void checkCreatePokemon() {
		
		pokemon = pokemonFactory.createPokemon(133, 613, 64, 4000, 4);
		
		assertEquals(pokemon.getName(), "Aquali");
		assertEquals(pokemon.getAttack(), 186);
		assertEquals(pokemon.getDefense(), 168);
		assertEquals(pokemon.getStamina(), 260);
		
	}
}
