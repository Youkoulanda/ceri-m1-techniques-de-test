package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Concrete implementation of the IPokemonMetadataProvider interface.
 * Provides metadata for Pokemon based on their index.
 *
 * @author fv
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    // Maximum allowed Pokemon index value.
    private static final int MAX_POKEMON_INDEX = 151;

    // Map to store the metadata of Pokemon indexed by their index.
    private static final Map<Integer, PokemonMetadata> pokemonDataMap;

    // Static block to initialize the pokemon data map with some sample Pokemon.
    static {
        pokemonDataMap = new HashMap<>();
        pokemonDataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonDataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 186, 260));
    }

    /**
     * Retrieves the metadata for the specified Pokemon index.
     *
     * @param index The index of the Pokemon.
     * @return The metadata of the Pokemon.
     * @throws PokedexException If the index is out of bounds or metadata is unavailable.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Check if the index is within the valid range
        if (index < 0 || index > MAX_POKEMON_INDEX) {
            throw new PokedexException("Pokemon not found");
        }

        // Retrieve the metadata from the map
        PokemonMetadata metadata = pokemonDataMap.get(index);
        if (metadata != null) {
            return metadata;
        }

        // Throw exception if the metadata is unavailable
        throw new PokedexException("Pokemon metadata source is unavailable");
    }
}
