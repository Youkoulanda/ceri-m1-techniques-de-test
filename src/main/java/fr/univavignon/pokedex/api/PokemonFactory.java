package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    private IPokemonMetadataProvider metadataProvider;

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        // Retrieve metadata for the given index
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

        // Extract attributes from the metadata
        String name = metadata.getName();
        int attack = metadata.getAttack();
        int defense = metadata.getDefense();
        int stamina = metadata.getStamina();
        double iv = 56;

        // Create and return the new Pokemon instance
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy,iv);
    }
}
