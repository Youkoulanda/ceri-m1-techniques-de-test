package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create Pokemon instance.
 * 
 * @author fv
 */
public interface IPokemonFactory {

	/**
	 * Creates a Pokémon instance computing it IVs.
	 * 
	 * @param index Pokemon index.
	 * @param cp Pokemon CP.
	 * @param hp Pokemon HP.
	 * @param dust Required dust for upgrading pokemon.
	 * @param candy Required candy for upgrading Pokémon.
	 * @return Created Pokémon instance.
	 */
	Pokemon createPokemon(int index, int cp, int hp, int dust, int candy);
	
}
