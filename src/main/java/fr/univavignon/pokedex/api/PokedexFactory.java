package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // Create a new Pokedex instance using the provided metadata provider and pokemon factory
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
