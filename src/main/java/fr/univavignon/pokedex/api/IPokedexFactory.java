package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create IPokedex instance.
 * 
 * @author fv
 */
public interface IPokedexFactory {

	/**
	 * Creates a new Pokédex instance using the given
	 * <code>metadataProvider</code> and <code>pokemonFactory</code>.
	 * 
	 * @param metadataProvider Metadata provider the created Pokédex will use.
	 * @param pokemonFactory Pokémon factory the created pokedex will use.
	 * @return Created Pokédex instance.
	 */
	IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory);
	
}
