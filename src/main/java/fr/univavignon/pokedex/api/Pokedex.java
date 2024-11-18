package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex  implements IPokedex{


    private PokemonFactory pokemonFactory = new PokemonFactory();
    private  List<Pokemon> pokemons = new  ArrayList<>();

    
    @Override
    public int size() {
        return  this.pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        try {
            this.pokemons.add(pokemon);
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        Pokemon p = this.pokemons.stream().filter(po -> po.getIndex() == id).findFirst().get();
        return  p;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return  this.pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
       return  PokemonFactory.pokemonMap.get(index);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return  pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        
    }
    

    public void setPokemonFactory(PokemonFactory pokemonFactory){
        this.pokemonFactory = pokemonFactory;
    }
}
