package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;


public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp(){
        this.pokemonFactory = Mockito.mock(IPokemonFactory.class);
        this.bulbizarre = new Pokemon(
                0,
                "Bulbizarre",
                126,
                126,
                90,
                613,
                64,
                4000,
                4,
                56);
        this.aquali = new Pokemon(
                133,
                "Aquali",
                186,
                168,
                260,
                2729,
                202,
                5000,
                4,
                100);
    }

    @Test
    public void canCreatePokemon(){

        // given
        int bulbizarreIndex = 0;
        int bulbizarreCp = 613;
        int bulbizarreHp = 64;
        int bulbizarreDust = 4000;
        int bulbizarreCandy = 4;

        //
        int aqualiIndex = 133;
        int aqualiCp = 2729;
        int aqualiHp = 202;
        int aqualiDust = 5000;
        int aqualiCandy= 4;

        // when
        Mockito.when(pokemonFactory.createPokemon(
                bulbizarreIndex,
                bulbizarreCp,
                bulbizarreHp,
                bulbizarreDust,
                bulbizarreCandy))
                .thenReturn(bulbizarre);


        Mockito.when(pokemonFactory.createPokemon(aqualiIndex,
                aqualiCp,
                aqualiHp,
                aqualiDust,
                aqualiCandy))
                .thenReturn(aquali);

        // then
        assertEquals(bulbizarre,pokemonFactory.createPokemon(
                bulbizarreIndex,
                bulbizarreCp,
                bulbizarreHp,
                bulbizarreDust,
                bulbizarreCandy));
        assertEquals(aquali,pokemonFactory.createPokemon(aqualiIndex,
                aqualiCp,
                aqualiHp,
                aqualiDust,
                aqualiCandy));
    }
}
