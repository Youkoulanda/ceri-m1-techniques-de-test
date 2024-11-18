package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonFactory implements IPokemonFactory {


    static Map<Integer, PokemonMetadata> pokemonMap = new HashMap<>();


    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        populatePokemonMapMetada();
        PokemonMetadata pm = this.pokemonMap.get(index);
        return new Pokemon(index, pm.getName(), pm.getAttack(), pm.getDefense(), pm.getStamina(), cp, hp, dust, candy, hp);

    }


    private void populatePokemonMapMetada(){
        if (!pokemonMap.isEmpty()) {
            return;
        }

        PokemonMetadata bulbizarMetadata =  new PokemonMetadata(0, "Bulbizarre", 126 , 126, 90);
        PokemonMetadata AqualiMetadata =  new PokemonMetadata(133, "Aquali", 186, 168, 260);

        pokemonMap.put(0, bulbizarMetadata);
        pokemonMap.put(133, AqualiMetadata);
    }
    
}
