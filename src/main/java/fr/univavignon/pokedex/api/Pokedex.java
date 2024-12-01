package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of the IPokedex interface.
 * This class manages a collection of captured Pokémon and their metadata.
 */
public class Pokedex implements IPokedex {


    private final List<Pokemon> pokemons;
    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;

    /**
     * Default constructor for the Pokedex.
     * Initializes the Pokémon list and the metadata provider and factory.
     *
     * @param metadataProvider The metadata provider that the Pokedex will use.
     * @param pokemonFactory The Pokémon factory that the Pokedex will use.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemons = new ArrayList<>();
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Returns the total number of Pokémon in the Pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Adds a Pokémon to the Pokedex and returns its unique index.
     *
     * @param pokemon The Pokémon to add.
     * @return The index of the added Pokémon.
     * @throws IllegalArgumentException if the Pokémon is null.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        if (pokemon == null) {
            throw new IllegalArgumentException("The Pokémon to add cannot be null.");
        }
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    /**
     * Retrieves a Pokémon by its unique ID.
     *
     * @param id The unique ID of the Pokémon.
     * @return The corresponding Pokémon.
     * @throws PokedexException if the ID is invalid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("The provided ID is invalid: " + id);
        }
        return pokemons.get(id);
    }

    /**
     * Returns an immutable list of all Pokémon in the Pokedex.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /**
     * Returns an immutable list sorted according to a provided comparator.
     *
     * @param order Comparator to sort the Pokémon.
     * @return Sorted and immutable list.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);
        return Collections.unmodifiableList(sortedList);
    }

    /**
     * Creates a Pokémon with the provided attributes.
     * This method is not yet implemented.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        throw new UnsupportedOperationException("Pokémon creation is not yet implemented.");
    }

    /**
     * Returns the metadata of a given Pokémon.
     * This method is not yet implemented.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        throw new UnsupportedOperationException("Retrieving metadata is not yet implemented.");
    }
}
