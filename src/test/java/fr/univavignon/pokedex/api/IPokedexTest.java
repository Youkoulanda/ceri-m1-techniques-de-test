package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IPokedexTest {


    @Test
    public void emptyList(){
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Mockito.when(pokedex.size()).thenReturn(0);
        assertTrue(pokedex.size() == 0);
    }


    @Test
    public void addPokemonTest(){
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon Bulbizarre = new Pokemon(0,"Bulbizarre",126,126, 	90,613, 	64,4000,4, 	56);
        pokedex.addPokemon(Bulbizarre);
        Mockito.when(pokedex.size()).thenReturn(1);
        assertTrue(pokedex.size() == 1);
    }


    @Test
    public void getPokemonTest() throws PokedexException {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon Bulbizarre = new Pokemon(0,"Bulbizarre",126,126, 	90,613, 	64,4000,4, 	56);
        //pokedex.addPokemon(Bulbizarre);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(Bulbizarre);
        assertTrue( pokedex.getPokemon(0).getName().equals(Bulbizarre.getName()));
    }

    @Test
    public void testGetPokemonValidId() throws PokedexException {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbasaur);

        Pokemon retrieved = pokedex.getPokemon(0);
        assertEquals("Bulbasaur", retrieved.getName());
        assertEquals(126, retrieved.getAttack());
    }


     @Test
    public void testGetPokemons() {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon vaporeon = new Pokemon(133, "Vaporeon", 186, 168, 260, 2729, 202, 5000, 4, 100);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbasaur);
        pokemons.add(vaporeon);

        Mockito.when(pokedex.getPokemons()).thenReturn(pokemons);

        List<Pokemon> retrieved = pokedex.getPokemons();
        assertEquals(2, retrieved.size());
        assertTrue(retrieved.containsAll(pokemons));
    }

    @Test
    public void getPokemonsComparator(){
        IPokedex  pokedex = Mockito.mock(IPokedex.class);
        Pokemon Bulbizarre = new Pokemon(0,"Bulbizarre",126,126, 	90,613, 	64,4000,4, 	56);
        Pokemon Aquali = new Pokemon(133,"Aquali",186,168, 	260,2729, 	202,5000,4, 	100);


        List<Pokemon> pokemons = new  ArrayList<>();
        pokemons.add(Bulbizarre);
        pokemons.add(Aquali);



        Comparator<Pokemon> comparator = new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon o1, Pokemon o2) {
                return o1.getAttack() - o2.getAttack();
            }
        };

        Mockito.when(pokedex.getPokemons(comparator)).thenReturn(pokemons);
        assertTrue(pokedex.getPokemons(comparator).containsAll(pokemons));


    }



}
