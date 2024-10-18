package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;
    private ArrayList<Pokemon> pokemons;

    @Before
    public void Init() {
        pokedex = Mockito.mock(IPokedex.class);

        // Initialisation des Pokémon
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);

        pokemons = new ArrayList<>();
        // Ajout des Pokémon à la liste
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
    }

    @Test
    public void testSize() {
        // Simulation de la taille du Pokedex
        Mockito.doReturn(pokemons.size()).when(pokedex).size();

        // Vérification que la taille de la liste est bien 2
        Assert.assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        // Simulation de l'ajout d'un Pokémon
        Mockito.doReturn(pokemons.size() + 1).when(pokedex).addPokemon(Mockito.any(Pokemon.class));

        // Vérification de l'ajout d'un Pokémon, la taille de la liste doit être 3
        Assert.assertEquals(3, pokedex.addPokemon(new Pokemon(2, "Pikachu", 200, 200, 4000, 200, 10000, 0, 0, 100.0)));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Simulation de la récupération des Pokémon par ID
        Mockito.doReturn(aquali).when(pokedex).getPokemon(133);
        Mockito.doReturn(bulbizarre).when(pokedex).getPokemon(0);

        // Vérification que le Pokémon avec l'ID 0 est bien Bulbizarre
        Assert.assertEquals(bulbizarre, pokedex.getPokemon(0));
        Assert.assertEquals(aquali, pokedex.getPokemon(133));

        // Simulation d'une exception pour un index inexistant (valeurs entre 0 et 150)
        Mockito.doThrow(new PokedexException("Le Pokémon avec cet index n'existe pas")).when(pokedex)
                .getPokemon(Mockito.intThat(i -> i < 0 || i > 150));

        // Vérification des exceptions pour des indices invalides
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(300));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-2));
    }

    @Test
    public void testGetPokemons() {

        // Création d'une liste non modifiable des Pokémon
        List<Pokemon> unmodifiableList = Collections.unmodifiableList(pokemons);

        // Simulation du retour de la liste non modifiable
        Mockito.doReturn(unmodifiableList).when(pokedex).getPokemons();

        // Vérification que les tailles des listes sont identiques
        Assert.assertEquals(pokemons.size(), pokedex.getPokemons().size());

        // Vérification que les objets sont bien placés avec leurs indices
        Assert.assertEquals(aquali, pokedex.getPokemons().get(1));

        Assert.assertEquals(pokemons.get(0), pokedex.getPokemons().get(0));

        Assert.assertEquals(unmodifiableList.getClass(), pokedex.getPokemons().getClass());
    }
}
