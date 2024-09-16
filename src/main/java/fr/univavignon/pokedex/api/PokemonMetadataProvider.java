package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    // Map to store PokemonMetadata objects indexed by Pokemon index
    private Map<Integer, PokemonMetadata> metadataMap;

    public PokemonMetadataProvider() {
        // Initialize the map
        metadataMap = new HashMap<>();
        // Add some example metadata (replace with your actual metadata)
        metadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        metadataMap.put(1, new PokemonMetadata(133, "Aquali", 186, 168, 260));
        metadataMap.put(2, new PokemonMetadata(25, "Pikachu", 100, 90, 300));
        // Add more metadata as needed
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Retrieve metadata from the map based on the index
        PokemonMetadata metadata = metadataMap.get(index);
        if (metadata == null) {
            throw new PokedexException("Pokemon metadata not found for index: " + index);
        }
        return metadata;
    }
}
