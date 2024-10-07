package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create PokemonTrainer instance.
 * 
 * @author fv
 */
public interface IPokemonTrainerFactory {

	/**
	 * Creates and returns a PokemonTrainer instance.
	 * 
	 * @param name Name of the created trainer.
	 * @param team Team of the created trainer.
	 * @param pokedexFactory Factory to use for creating associated pokedex instance.
	 * @return Created trainer instance.
	 */
	PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory);
	
}
