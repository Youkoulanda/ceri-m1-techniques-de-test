package fr.univavignon.pokedex.api;

public class PokedexFactory implements  IPokedexFactory {

    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        Pokedex pokedex = new Pokedex(); 
        return pokedex;

    }
    
}
