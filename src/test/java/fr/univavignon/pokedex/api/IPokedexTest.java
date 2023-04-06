package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {

	IPokedex pokedex;
	Pokemon bulbizarre;
	Pokemon aquali;
	ArrayList<Pokemon> pokemons;

	@Before
	public void init() {

		pokedex = Mockito.mock(IPokedex.class);
		// Initialisation des Pokymons
		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
		aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
		pokemons = new ArrayList<>();
		// Ajout des pokymons à la liste
		pokemons.add(bulbizarre);
		pokemons.add(aquali);

	}

	@Test
	public void testSize() {
		//
		Mockito.doReturn(pokemons.size()).when(pokedex).size();
		// Verification de la taille de liste est bien 2
		Assert.assertEquals(2, pokedex.size());
	}

	@Test
	public void testAddPokemon() {
		Mockito.doReturn(pokemons.size() + 1).when(pokedex).addPokemon(Mockito.any(Pokemon.class));
		// Verfication de l'ajout d'un pokymone, alors la taille de la liste est 3
		Assert.assertEquals(3, pokedex.addPokemon(new Pokemon(2, "Pikasu", 200, 200, 4000, 200, 10000, 0, 0, 100.0)));
	}

	@Test
	public void testGetPokemon() throws PokedexException {
		// get le pokymone à partir de le id 133, et il retourn Aquali
		Mockito.doReturn(aquali).when(pokedex).getPokemon(133);
		Mockito.doReturn(bulbizarre).when(pokedex).getPokemon(0);
		// Verification que c'est bien bulbizarre avec l'indice 0
		Assert.assertEquals(bulbizarre, pokedex.getPokemon(0));
		Assert.assertEquals(aquali, pokedex.getPokemon(133));
		// Exception en cas d'un indice qui n'existe pas (liste des poky est comprise
		// entre 0 et 150)
		Mockito.doThrow(new PokedexException("Le Pokymone avec cet index n'existe pas")).when(pokedex)
				.getPokemon(Mockito.intThat(i -> i < 0 || i > 150));
		// Exception en cas de test avec un indice d'un poky qui n'existe pas (les
		// valeurs positives et negatives)
		Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(300));
		Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-2));

	}

	@Test
	public void testGetPokemons() {
		// Creation d'une liste non modifable des pokymons
		List<Pokemon> unmodifiableList = Collections.unmodifiableList(pokemons);
		// return la list unmodifiable
		Mockito.doReturn(unmodifiableList).when(pokedex).getPokemons();
		// Verification des deux list qu'elles sont pareilles
		Assert.assertEquals(pokemons.size(), pokedex.getPokemons().size());
		// Vrification que les objets sont bien placé avec leurs indice
		Assert.assertEquals(aquali, pokedex.getPokemons().get(1));
		Assert.assertEquals(pokemons.get(0), pokedex.getPokemons().get(0));
		Assert.assertEquals(unmodifiableList.getClass(), pokedex.getPokemons().getClass());

	}

}
