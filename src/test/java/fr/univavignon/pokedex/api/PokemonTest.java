// package fr.univavignon.pokedex.api;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotEquals;

// import org.junit.Test;

// public class PokemonTest {

//      @Test
//     public void testPokemonConstructorAndGetters() {
//         // Création d'une instance de Pokemon
//         Pokemon pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90, 500, 60, 3000, 3, 56.0);

//         // Vérification des attributs hérités de PokemonMetadata
//         assertEquals(1, pokemon.getIndex());
//         assertEquals("Bulbasaur", pokemon.getName());
//         assertEquals(126, pokemon.getAttack());
//         assertEquals(126, pokemon.getDefense());
//         assertEquals(90, pokemon.getStamina());

//         // Vérification des attributs spécifiques à Pokemon
//         assertEquals(500, pokemon.getCp());
//         assertEquals(60, pokemon.getHp());
//         assertEquals(3000, pokemon.getDust());
//         assertEquals(3, pokemon.getCandy());
//         assertEquals(56.0, pokemon.getIv(), 0.0);
//     }

//     // @Test
//     // public void testPokemonEquality() {
//     //     // Création de deux instances identiques de Pokemon
//     //     Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 500, 60, 3000, 3, 56.0);
//     //     Pokemon pokemon2 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 500, 60, 3000, 3, 56.0);

//     //     // Vérification que les deux instances sont égales
//     //     assertEquals(pokemon1, pokemon2);
//     // }

//     @Test
//     public void testPokemonInequality() {
//         // Création de deux instances différentes de Pokemon
//         Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 500, 60, 3000, 3, 56.0);
//         Pokemon pokemon2 = new Pokemon(2, "Ivysaur", 156, 158, 120, 600, 70, 3500, 4, 70.0);

//         // Vérification que les deux instances ne sont pas égales
//         assertNotEquals(pokemon1, pokemon2);
//     }

    
// }
