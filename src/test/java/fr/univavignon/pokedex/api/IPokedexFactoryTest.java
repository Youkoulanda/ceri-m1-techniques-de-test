package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
	IPokedexFactory pokedexFactory;
	PokemonMetadata aquali;
	PokemonMetadata bulbizarre;

	@Before
	public void init() {
		pokedexFactory = Mockito.mock(IPokedexFactory.class);
		bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);

	}

	@Test
	public void testCreatePokedex() {
		IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
		Mockito.doReturn(Mockito.mock(IPokedex.class)).when(pokedexFactory)
				.createPokedex(Mockito.any(pokemonMetadataProvider.getClass()), Mockito.any(pokemonFactory.getClass()));
		Assert.assertNotNull(pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class),
				Mockito.mock(IPokemonFactory.class)));
		Assert.assertEquals(Mockito.mock(IPokedex.class).getClass(), pokedexFactory
				.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class))
				.getClass());

	}

}
