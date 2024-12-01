package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static final int MAX_POKEMON_INDEX = 151;
    private static final Map<Integer, PokemonMetadata> pokemonDataMap;

    static {
        pokemonDataMap = new HashMap<>();
        pokemonDataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonDataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 186, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > MAX_POKEMON_INDEX) {
            throw new PokedexException("Pokemon not found");
        }

        PokemonMetadata metadata = pokemonDataMap.get(index);
        if (metadata != null) {
            return metadata;
        }

        throw new PokedexException("Pokemon metadata source is unavailable");
    }
}
