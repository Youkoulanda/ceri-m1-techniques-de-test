package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;


/**
 * A static map that associates an integer index with a Pokémon name.
 * The map is initialized once and cannot be modified.
 */

public class RocketPokemonFactory implements IPokemonFactory {
    /**
     * A static map of Pokémon indices to their names.
     * <p>
     * Example: -1 -> "Ash's Pikachu", 0 -> "MISSINGNO", 1 -> "Bulbasaur".
     * </p>
     * <p>Note: The map is unmodifiable.</p>
     * <p>TODO: Add more Pokémon mappings.</p>
     */

    private static Map<Integer, String> index2name;
    static {
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        //TODO : Gotta map them all !
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
    }

    /**
     * Generates a random statistical value.
     * <p>
     * This method simulates a large number of random binary events (0 or 1)
     * and computes the average of their sum over a specific range.
     * </p>
     *
     * @return The average value of random binary numbers generated, divided by 10000.
     */
    public static int generateRandomStat() {
        int total = 0;
        for(int i=0; i < 1000000; i++)
        {
            Random rn = new Random();
            int r = rn.nextInt(2);
            total = total + r;
        }
        return total / 10000;
    }

    /**
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Un objet de type Pokemon.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name;
        if(!index2name.containsKey(index)) {
            name = index2name.get(0);
        } else {
            name = index2name.get(index);
        }
        int attack;
        int defense;
        int stamina;
        double iv;
        if(index < 0) {
            attack = 1000;
            defense = 1000;
            stamina = 1000;
            iv = 0;
        } else {
            attack = RocketPokemonFactory.generateRandomStat();
            defense = RocketPokemonFactory.generateRandomStat();
            stamina = RocketPokemonFactory.generateRandomStat();
            iv = 1;
        }
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }

}