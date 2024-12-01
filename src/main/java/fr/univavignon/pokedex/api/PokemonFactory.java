package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            double attack = metadata.getAttack();
            double defense = metadata.getDefense();
            double stamina = metadata.getStamina();

            // Calculate the IVs based on the CP and HP
            double iv = (cp * 0.5 + hp * 0.5) / (attack + defense + stamina);

            return new Pokemon(index, metadata.getName(), (int) attack, (int) defense, (int) stamina, cp, hp, dust, candy, iv);

        } catch (PokedexException e) {
            throw new RuntimeException("Failed to retrieve metadata for Pokemon index " + index, e);
        }
    }
}
