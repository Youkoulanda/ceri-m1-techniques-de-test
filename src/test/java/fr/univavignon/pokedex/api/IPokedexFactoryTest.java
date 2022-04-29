package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp(){
        this.pokedexFactory = Mockito.mock(IPokedexFactory.class);

    }

    @Test
    public void canCreatePokedex(){

        //given
        IPokemonMetadataProvider pokemonMetadataProvider= Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

        //when
        Mockito
                .doReturn(Mockito.mock(IPokedex.class))
                .when(this.pokedexFactory)
                .createPokedex(Mockito.any(pokemonMetadataProvider.getClass()),Mockito.any(pokemonFactory.getClass()));


        //then
        assertEquals(Mockito.mock(IPokedex.class).getClass(),pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class),Mockito.mock(IPokemonFactory.class)).getClass());
    }
}
