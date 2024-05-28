package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

    @BeforeEach
    public void setUp() throws PokedexException {
        pokemonFactory = mock(IPokemonFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokedex = mock(IPokedex.class);

        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 56, 4000, 4, 56);

        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);

        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(bulbizarre);

        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        when(pokedex.getPokemons()).thenReturn(pokemonList);
    }

    @Test
    public void testAddPokemon() {
        int index = pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 56, 4000, 4, 56));
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemonCP() throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(0);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(4, pokemon.getCp());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals("Bulbizarre", pokemons.get(0).getName());
    }
}
