package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;



    @Before
    public void setUp(){
        this.pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    }

    @Test
    public void canCreateTrainer(){

        // given
        IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
        Team mystic = Team.MYSTIC;
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Arcanine",mystic,pokedex);

        // when
        Mockito
                .doReturn(pokemonTrainer)
                .when(this.pokemonTrainerFactory)
                .createTrainer("Arcanine",mystic,pokedexFactory);

        // then
        // Class check
        assertEquals(pokemonTrainer.getClass(),this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getClass());
        // Name check
        assertEquals("Arcanine",this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getName());
        // Team check
        assertEquals(mystic,this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getTeam());
        // Pokedex class check
        assertEquals(pokedex.getClass(),this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getPokedex().getClass());
        // Pokedex size check
        assertEquals(pokedex.size(),this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getPokedex().size());
    }

}
