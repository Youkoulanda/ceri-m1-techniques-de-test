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
	private Pokemon pokemon2;
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
		
		pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		pokemon2 = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
	
		assertEquals(Pokemon.class, pokemon.getClass());
		assertEquals(Pokemon.class, pokemon2.getClass());
		
		assertEquals(pokemon.getCp(), 613);
		assertEquals(pokemon.getHp(), 64);
		assertEquals(pokemon.getDust(), 4000);
		assertEquals(pokemon.getCandy(), 4);
		
		assertEquals(pokemon2.getName(), "Aquali");
		assertEquals(pokemon2.getAttack(), 186);
		assertEquals(pokemon2.getDefense(), 168);
		assertEquals(pokemon2.getStamina(), 260);
		
	}
}
