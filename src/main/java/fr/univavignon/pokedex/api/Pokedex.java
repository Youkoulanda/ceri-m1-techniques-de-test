package fr.univavignon.pokedex.api;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implémentation concrète de l'interface IPokedex.
 * Cette classe permet de stocker et gérer des informations sur les Pokémon capturés.
 */

public abstract class Pokedex implements IPokedex,IPokedexFactory,IPokemonFactory,IPokemonTrainerFactory,IPokemonMetadataProvider{

    private final List<Pokemon> pokemons;

    /**
     * Constructeur de la classe Pokedex.
     */

    public Pokedex() {
        this.pokemons = new ArrayList<>();
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1; // Retourne l'index du Pokémon ajouté
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Index invalide pour le Pokémon.");
        }
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);
        return Collections.unmodifiableList(sortedList);
    }

    // Implémentations des méthodes de IPokemonMetadataProvider
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        throw new UnsupportedOperationException("Méthode non implémentée.");
    }

    // Implémentations des méthodes de IPokemonFactory
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        throw new UnsupportedOperationException("Méthode non implémentée.");
    }
}
