package  fr.univavignon.pokedex.api;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Pokedex implements IPokedex {
    private final HashMap<Integer, Pokemon> pokemons = new HashMap<>();
    private final IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        int id = pokemons.size();
        pokemons.put(id, pokemon);
        return id;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (!pokemons.containsKey(id)) {
            throw new PokedexException("Pokemon not found");
        }
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons.values());
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        return pokemons.values().stream().sorted(order).collect(Collectors.toList());
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, 0); // IV is not provided, so it's set to 0
        } catch (PokedexException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
