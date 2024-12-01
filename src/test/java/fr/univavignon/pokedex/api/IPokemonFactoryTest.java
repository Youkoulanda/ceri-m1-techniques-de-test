package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class IPokemonFactoryTest {

    private Pokedex pokedex;
    private PokemonFactory pokemonFactory;

    private Pokemon bulbizarre;
    private Pokemon aquali;
    private List<Pokemon> pokemons;

    @Before
    public void init() {

        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);

        pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
    }

    @Test
    public void testCreatePokemonSuccess() {
        int index = 0;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;

        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);

        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }
}
