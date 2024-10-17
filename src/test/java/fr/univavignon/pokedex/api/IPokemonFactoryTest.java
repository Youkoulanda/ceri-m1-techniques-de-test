package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setup() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemonBulbizarre() {
        Pokemon expectedPokemon = new Pokemon(0, "Bulbizarre", 134, 134, 98, 613, 64, 4000, 4, 0.56);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(expectedPokemon);
        Pokemon createdPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(createdPokemon);
        assertEquals(0, createdPokemon.getIndex());
        assertEquals("Bulbizarre", createdPokemon.getName());
        assertEquals(613, createdPokemon.getCp());
        assertEquals(64, createdPokemon.getHp());
        assertEquals(4000, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
        assertEquals(134, createdPokemon.getAttack());
        assertEquals(134, createdPokemon.getDefense());
        assertEquals(98, createdPokemon.getStamina());
    }

    @Test
    public void testCreatePokemonAquali() {
        Pokemon expectedPokemon = new Pokemon(0, "Aquali", 201, 201, 275, 2729, 202, 5000, 4, 1);
        when(pokemonFactory.createPokemon(0, 2729, 202, 5000, 4)).thenReturn(expectedPokemon);
        Pokemon createdPokemon = pokemonFactory.createPokemon(0, 2729, 202, 5000, 4);

        assertNotNull(createdPokemon);
        assertEquals(0, createdPokemon.getIndex());
        assertEquals("Aquali", createdPokemon.getName());
        assertEquals(2729, createdPokemon.getCp());
        assertEquals(202, createdPokemon.getHp());
        assertEquals(5000, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
        assertEquals(201, createdPokemon.getAttack());
        assertEquals(201, createdPokemon.getDefense());
        assertEquals(275, createdPokemon.getStamina());
    }
}