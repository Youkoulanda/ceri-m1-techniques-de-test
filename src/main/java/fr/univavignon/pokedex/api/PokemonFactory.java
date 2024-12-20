package fr.univavignon.pokedex.api;

/**
 * Concrete implementation of the IPokemonFactory interface.
 * Responsible for creating Pokemon instances with the provided data.
 */
public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;

    /**
     * Constructs a PokemonFactory instance with the given metadata provider.
     *
     * @param metadataProvider The metadata provider used to retrieve Pokemon information.
     */
    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    /**
     * Creates a new Pokemon instance using the provided index and other parameters.
     * The method retrieves the Pokemon metadata and calculates the IVs (Individual Values)
     * based on the CP (Combat Power) and HP (Health Points).
     *
     * @param index The index of the Pokemon.
     * @param cp The combat power of the Pokemon.
     * @param hp The health points of the Pokemon.
     * @param dust The amount of dust associated with the Pokemon.
     * @param candy The amount of candy associated with the Pokemon.
     * @return The created Pokemon instance.
     * @throws RuntimeException If the metadata retrieval fails for the given Pokemon index.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            // Retrieve metadata for the given Pokemon index
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            double attack = metadata.getAttack();
            double defense = metadata.getDefense();
            double stamina = metadata.getStamina();

            // Calculate the IVs based on CP and HP
            double iv = (cp * 0.5 + hp * 0.5) / (attack + defense + stamina);

            // Create and return a new Pokemon instance
            return new Pokemon(index, metadata.getName(), (int) attack, (int) defense, (int) stamina, cp, hp, dust, candy, iv);

        } catch (PokedexException e) {
            // Throw runtime exception if metadata retrieval fails
            throw new RuntimeException("Failed to retrieve metadata for Pokemon index " + index, e);
        }
    }
}
