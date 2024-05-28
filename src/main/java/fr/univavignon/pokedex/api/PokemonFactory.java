package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        PokemonMetadata metadata = getMetadataForPokemon(index);

        double iv = calculateIV(cp, hp, dust, candy);


        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, iv);
    }

    private PokemonMetadata getMetadataForPokemon(int index) {
        return new PokemonMetadata(index, "Pikachu", 55, 40, 35);
    }

    private double calculateIV(int cp, int hp, int dust, int candy) {
        return 100.0;
    }
}
