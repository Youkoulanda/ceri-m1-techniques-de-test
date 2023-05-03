package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{

	IPokemonMetadataProvider pokemonMetadataProvider;
	IPokemonFactory pokemonFactory;
	
	public PokemonTrainerFactory(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
		this.pokemonMetadataProvider = pokemonMetadataProvider;
		this.pokemonFactory = pokemonFactory;
	}
	
	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		
		Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
		
		PokemonTrainer pokemonTrainer  = new PokemonTrainer(name, team, pokedex);
		
		return pokemonTrainer;
	}

	
}
