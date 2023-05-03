package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {
	
	IPokemonMetadataProvider metadataProvider;
	IPokemonFactory pokemonFactory;
	
	public PokedexFactory(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		this.metadataProvider = metadataProvider;
		this.pokemonFactory = pokemonFactory;
	}

	@Override
	public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		
		Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
		
		return pokedex;
	}
	
}
