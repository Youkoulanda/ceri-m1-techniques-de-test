package fr.univavignon.pokedex.api;

/**
 * Implementation of the IPokedexFactory interface.
 * This class is responsible for creating an instance of Pokedex using a
 * metadata provider and a Pokémon factory.
 *
 * @author fv
 */
public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new instance of Pokedex using the provided metadata provider
     * and Pokémon factory.
     *
     * @param metadataProvider The metadata provider that the Pokedex will use.
     * @param pokemonFactory The Pokémon factory that the Pokedex will use.
     * @return The created Pokedex instance.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
