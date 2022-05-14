package fr.univavignon.pokedex.api;

public class PokedexFactory implements  IPokedexFactory{

    public PokedexFactory () {
        IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
    }
    /**
     * Creates a new pokedex instance using the given
     * <tt>metadataProvider</tt> and <tt>pokemonFactory</tt>.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory   Pokemon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex();
    }
}
