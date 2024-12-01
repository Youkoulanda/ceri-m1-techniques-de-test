package fr.univavignon.pokedex.api;

/**
 * Concrete implementation of the IPokemonTrainerFactory interface.
 * Responsible for creating PokemonTrainer instances.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    private final IPokemonMetadataProvider metaProvider;
    private final IPokemonFactory pokemonFactory;

    public PokemonTrainerFactory(IPokemonMetadataProvider metaProvider, IPokemonFactory pokemonFactory) {
        if (metaProvider == null || pokemonFactory == null) {
            throw new IllegalArgumentException("Both metadataProvider and pokemonFactory cannot be null.");
        }
        this.metaProvider = metaProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name           Name of the created trainer.
     * @param team           Team of the created trainer.
     * @param pokedexFactory Factory to use for creating the associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be null or empty.");
        }
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null.");
        }
        if (pokedexFactory == null) {
            throw new IllegalArgumentException("PokedexFactory cannot be null.");
        }
        IPokedex pokedex = pokedexFactory.createPokedex(metaProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}
