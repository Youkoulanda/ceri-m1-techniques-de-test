package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Test;

public class RocketPokemonFactoryTest {

    @Test
    public void testCreatePokemonWithValidIndex() {
        RocketPokemonFactory factory = new RocketPokemonFactory();
        Pokemon pokemon = factory.createPokemon(1, 500, 100, 2000, 50);

        assertEquals("Pokemon index should be 1", 1, pokemon.getIndex());
        assertEquals("Pokemon name should be 'Bulbasaur'", "Bulbasaur", pokemon.getName());
        assertTrue("Pokemon attack should be between 0 and 100", pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue("Pokemon defense should be between 0 and 100", pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue("Pokemon stamina should be between 0 and 100", pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals("Pokemon CP should be 500", 500, pokemon.getCp());
        assertEquals("Pokemon HP should be 100", 100, pokemon.getHp());
        assertEquals("Pokemon dust should be 2000", 2000, pokemon.getDust());
        assertEquals("Pokemon candy should be 50", 50, pokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        RocketPokemonFactory factory = new RocketPokemonFactory();
        Pokemon pokemon = factory.createPokemon(-1, 500, 100, 2000, 50);

        assertEquals("Pokemon index should be -1", -1, pokemon.getIndex());
        assertEquals("Pokemon name should be 'Ash's Pikachu'", "Ash's Pikachu", pokemon.getName());
        assertEquals("Pokemon attack should be 1000", 1000, pokemon.getAttack());
        assertEquals("Pokemon defense should be 1000", 1000, pokemon.getDefense());
        assertEquals("Pokemon stamina should be 1000", 1000, pokemon.getStamina());
        assertEquals("Pokemon IV should be 0", 0, pokemon.getIv(), 0);
    }

    @Test
    public void testCreatePokemonWithMissingIndex() {
        RocketPokemonFactory factory = new RocketPokemonFactory();
        Pokemon pokemon = factory.createPokemon(999, 500, 100, 2000, 50);

        assertEquals("Pokemon index should be 999", 999, pokemon.getIndex());
        assertEquals("Pokemon name should default to 'MISSINGNO'", "MISSINGNO", pokemon.getName());
        assertTrue("Pokemon attack should be between 0 and 100", pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue("Pokemon defense should be between 0 and 100", pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue("Pokemon stamina should be between 0 and 100", pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
    }

    @Test
    public void testRandomStatGeneration() {
        int stat = RocketPokemonFactory.generateRandomStat();
        assertTrue("Generated stat should be between 0 and 100", stat >= 0 && stat <= 100);
    }

}