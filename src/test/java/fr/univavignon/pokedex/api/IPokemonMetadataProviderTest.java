package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
	IPokemonMetadataProvider pokemonMetadataProvider;

	PokemonMetadata aquali;
	PokemonMetadata bulbizarre;

	@Before
	public void init() {
		pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
	}

	@Test
	public void testGetPokemonMetadata() throws PokedexException {

		Mockito.doReturn(aquali).when(pokemonMetadataProvider).getPokemonMetadata(133);
		Mockito.doReturn(bulbizarre).when(pokemonMetadataProvider).getPokemonMetadata(0);
		Assert.assertEquals(bulbizarre, pokemonMetadataProvider.getPokemonMetadata(0));
		Assert.assertEquals(aquali, pokemonMetadataProvider.getPokemonMetadata(133));
		Mockito.doThrow(new PokedexException("L'index fourni n'existe pas ")).when(pokemonMetadataProvider)
				.getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));
		Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-189));
		Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(313));
	}

}
