package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PokemonFactoryTest {
    @Test
    public void testCreatePokemon() {
        PokemonFactory factory = new PokemonFactory();

        // Test creation of Bulbizarre
        Pokemon bulbizarre = factory.createPokemon(0, 500, 60, 3000, 3);

        assertNotNull("The created Pokemon should not be null", bulbizarre);
        assertEquals("Index should be 0", 0, bulbizarre.getIndex());
        assertEquals("Name should be 'Bulbizarre'", "Bulbizarre", bulbizarre.getName());
        assertEquals("Attack should be 126", 126, bulbizarre.getAttack());
        assertEquals("Defense should be 126", 126, bulbizarre.getDefense());
        assertEquals("Stamina should be 90", 90, bulbizarre.getStamina());
        assertEquals("CP should be 500", 500, bulbizarre.getCp());
        assertEquals("HP should be 60", 60, bulbizarre.getHp());
        assertEquals("Dust should be 3000", 3000, bulbizarre.getDust());
        assertEquals("Candy should be 3", 3, bulbizarre.getCandy());
    }

    @Test
    public void testCreatePokemonAquali() {
        PokemonFactory factory = new PokemonFactory();

        // Test creation of Aquali
        Pokemon aquali = factory.createPokemon(133, 1000, 100, 5000, 5);

        assertNotNull("The created Pokemon should not be null", aquali);
        assertEquals("Index should be 133", 133, aquali.getIndex());
        assertEquals("Name should be 'Aquali'", "Aquali", aquali.getName());
        assertEquals("Attack should be 186", 186, aquali.getAttack());
        assertEquals("Defense should be 168", 168, aquali.getDefense());
        assertEquals("Stamina should be 260", 260, aquali.getStamina());
        assertEquals("CP should be 1000", 1000, aquali.getCp());
        assertEquals("HP should be 100", 100, aquali.getHp());
        assertEquals("Dust should be 5000", 5000, aquali.getDust());
        assertEquals("Candy should be 5", 5, aquali.getCandy());
    }

    @Test
    public void testPopulatePokemonMapMetada() {
        PokemonFactory factory = new PokemonFactory();

        // Access the private map through reflection
        factory.createPokemon(0, 0, 0, 0, 0); // Populate the map

        assertNotNull("Pokemon map should not be empty", PokemonFactory.pokemonMap);
        assertTrue("Pokemon map should contain Bulbizarre", PokemonFactory.pokemonMap.containsKey(0));
        assertTrue("Pokemon map should contain Aquali", PokemonFactory.pokemonMap.containsKey(133));

        PokemonMetadata bulbizarre = PokemonFactory.pokemonMap.get(0);
        PokemonMetadata aquali = PokemonFactory.pokemonMap.get(133);

        assertEquals("Bulbizarre metadata should be correct", "Bulbizarre", bulbizarre.getName());
        assertEquals("Aquali metadata should be correct", "Aquali", aquali.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testCreatePokemonInvalidIndex() {
        PokemonFactory factory = new PokemonFactory();

        // Attempt to create a Pokemon with an invalid index
        factory.createPokemon(999, 500, 60, 3000, 3);
    }
}
