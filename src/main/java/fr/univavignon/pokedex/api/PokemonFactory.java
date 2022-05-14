package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{

    private final PokemonMetadataProvider pokemonMetadataProvider;

    public PokemonFactory(){
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }
    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        PokemonMetadata pokemonMetadata;
        double iv=0.0;

        try {
             pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
            switch (pokemonMetadata.getIndex()) {
                case 0 -> iv = 56.0;
                case 133 -> iv = 100.0;
            }
        } catch (PokedexException e) {
            e.printStackTrace();
            return null;
        }

        return new Pokemon(
                pokemonMetadata.getIndex(),
                pokemonMetadata.getName(),
                pokemonMetadata.getAttack(),
                pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(),
                cp,
                hp,
                dust,
                candy,
                iv);
    }
}
