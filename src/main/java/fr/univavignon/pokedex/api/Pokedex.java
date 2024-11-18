package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

public class Pokedex  implements IPokedex{
    
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pokemon> getPokemons() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
