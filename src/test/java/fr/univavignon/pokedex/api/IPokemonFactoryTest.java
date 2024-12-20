package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class IPokemonFactoryTest {

    private RocketPokemonFactory rocketPokemonFactory;
    private Pokedex pokedex;
    private PokemonFactory pokemonFactory;

    /**
     * Initialization of objects needed for the tests.
     * This method is executed before each test.
     */
    @Before
    public void init() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

        // Création locale de la factory et du pokédex
        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Création des objets Pokémon pour les tests
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);

        // Ajout des Pokémon à la liste et au Pokédex
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        // Création locale de la factory Rocket
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    /**
     * Test for successful Pokémon creation.
     * This test verifies that the Pokémon's attributes are correctly assigned.
     */
    @Test
    public void testCreatePokemonSuccess() {
        int index = 0;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;

        // Creating a Pokémon using the factory
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Verifying the values returned by the Pokémon
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

    /**
     * Test for Pokémon creation with an unknown index.
     * The returned Pokémon should have the name "MISSINGNO" for an invalid index.
     */
    @Test
    public void testCreatePokemonWithUnknownIndex() {
        int index = 99;
        int cp = 500;
        int hp = 50;
        int dust = 3000;
        int candy = 3;

        // Creating a Pokémon with an unknown index
        Pokemon pokemon = rocketPokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Verifying the values of the created Pokémon
        assertNotNull(pokemon);
        assertEquals("MISSINGNO", pokemon.getName());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }

    /**
     * Test for the creation of Ash's Pikachu with a special index (-1).
     * This test verifies if the returned Pokémon is "Ash's Pikachu" with the correct stats.
     */
    @Test
    public void testCreateAshsPikachu() {
        int index = -1;
        int cp = 1000;
        int hp = 100;
        int dust = 5000;
        int candy = 10;

        // Creating Ash's Pikachu using the factory
        Pokemon pokemon = rocketPokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Verifying the values returned by the Pokémon
        assertNotNull(pokemon);
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }

    /**
     * Test for the generateRandomStat method.
     * This test verifies that the method returns a value within the expected range.
     */
    @Test
    public void testGenerateRandomStat() {
        // Test for generating a random statistic
        int stat = RocketPokemonFactory.generateRandomStat();

        // Verify that the statistic is between 0 and 100
        assertTrue(stat >= 0 && stat <= 100);
    }
}
