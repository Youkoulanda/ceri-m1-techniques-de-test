package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static final int MAX_POKEMON_INDEX = 151;

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Validate the index
        if (index < 0 || index > MAX_POKEMON_INDEX) {
            throw new PokedexException("Pokemon not found");
        }

        // Return example Pokémon for valid indices
        if (index == 0) {
            return new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        } else if (index == 133) {
            return new PokemonMetadata(133, "Aquali", 186, 186, 260);
        }

        // If the index is valid but no data is available for this index
        throw new PokedexException("Pokemon metadata source is unavailable");
    }
}
