package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
	IPokedex pokedex;
	IPokemonTrainerFactory pokemonTrainerFactory;

	PokemonTrainer pTrainer;
	IPokedexFactory factory;

	@Before
	public void init() {
		pokedex = Mockito.mock(IPokedex.class);
		pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
		factory = Mockito.mock(IPokedexFactory.class);
		pTrainer = new PokemonTrainer("monTeam", Team.INSTINCT, pokedex);

	}

	@Test
	public void testCreateTrainer() {
		Mockito.doReturn(pTrainer).when(pokemonTrainerFactory).createTrainer("monTeam", Team.INSTINCT, factory);
		Assert.assertEquals(pTrainer.getClass(),
				pokemonTrainerFactory.createTrainer("monTeam", Team.INSTINCT, factory).getClass());
		Assert.assertEquals(pTrainer, pokemonTrainerFactory.createTrainer("monTeam", Team.INSTINCT, factory));
		Assert.assertEquals("monTeam",
				pokemonTrainerFactory.createTrainer("monTeam", Team.INSTINCT, factory).getName());
		Assert.assertEquals(Team.INSTINCT,
				pokemonTrainerFactory.createTrainer("monTeam", Team.INSTINCT, factory).getTeam());
		Assert.assertEquals(pokedex,
				pokemonTrainerFactory.createTrainer("monTeam", Team.INSTINCT, factory).getPokedex());
		Assert.assertEquals(pokedex.size(),
				pokemonTrainerFactory.createTrainer("monTeam", Team.INSTINCT, factory).getPokedex().size());
	}

}
