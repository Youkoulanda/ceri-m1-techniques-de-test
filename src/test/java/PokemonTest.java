import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.pokedex.api.*;

/**
 * Classe de test bidon pour verifier le bon fonctionnement de maven
 */
public class PokemonTest {

    @Test
    public void testPokemon() {
        Pokemon pm = new Pokemon(1, "TestPokemon", 3, 3, 3, 3, 3, 3, 5, 3);
        int resultat = pm.getCandy();
        assertEquals(5, resultat);
    }
}