package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

    private final List<Pokemon> pokemonList;

    public Pokedex() {
        pokemonList = new ArrayList<>();
        Pokemon  bulbizarre = new Pokemon(0,
                "Bulbizarre",
                126,
                126,
                90,
                613,
                64,
                4000,
                4,
                56.0
        );

        Pokemon  aquali =  new Pokemon(
                133,
                "Aquali",
                186,
                186,
                260,
                2729,
                202,
                5000,
                4,
                100.0
        );

        pokemonList.add(bulbizarre);
        pokemonList.add(aquali);
    }
    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return pokemonList.size();
    }

    /**
     * Adds the given <tt>pokemon</tt> to this pokedex and returns
     * it unique index.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return size()+1;
    }

    /**
     * Locates the pokemon identified by the given <tt>id</tt>.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {

        Pokemon pokemon;
        try {
            pokemon = pokemonList.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Invalid given index");
        }
        return pokemon;
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     *
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemonList);
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given <tt>order</tt>.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemonList = new ArrayList<>(pokemonList);
        sortedPokemonList.sort(order);
        return Collections.unmodifiableList(sortedPokemonList);
    }

    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return new PokemonFactory().createPokemon(index,cp,hp,dust,candy);
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <tt>index</tt>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return new PokemonMetadataProvider().getPokemonMetadata(index);
    }
}
