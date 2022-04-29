package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;
    private PokemonMetadata bulbizarre;
    private PokemonMetadata aquali;




    @Before
    public void setUp(){

        this.metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        this.bulbizarre = new PokemonMetadata(
                0,
                "Bulbizarre",
                126,
                126,
                90
                );
        this.aquali = new PokemonMetadata(
                133,
                "Aquali",
                186,
                168,
                260);


    }

    @Test
    public void getPokemonMetadata() throws PokedexException {

        // given
        int bulbizarreIndex = 0;
        int aqualiIndex = 133;
        int firstInvalidIndex = -4;
        int secondInvalidIndex = 160;


        // when
        Mockito.doReturn(this.bulbizarre)
                .when(metadataProvider)
                .getPokemonMetadata(bulbizarreIndex);
        Mockito.doReturn(this.aquali)
                .when(metadataProvider)
                .getPokemonMetadata(aqualiIndex);
        Mockito.doThrow(new PokedexException("invalid given index"))
                .when(metadataProvider)
                .getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));

        // then
        assertEquals(this.bulbizarre,metadataProvider.getPokemonMetadata(bulbizarreIndex));
        assertEquals(this.aquali,metadataProvider.getPokemonMetadata(aqualiIndex));
        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(firstInvalidIndex));
        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(secondInvalidIndex));


    }
}
