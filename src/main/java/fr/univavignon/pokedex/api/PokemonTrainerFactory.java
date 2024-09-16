package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Create a new pokedex instance using the provided pokedex factory
        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory(new PokemonMetadataProvider()));

        // Create and return a new PokemonTrainer instance
        return new PokemonTrainer(name, team, pokedex);
    }
}
