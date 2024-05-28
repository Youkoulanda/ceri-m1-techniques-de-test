package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;

    private PokemonFactory pokemonFactory;
    @BeforeEach
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);

        trainerFactory = new PokemonTrainerFactoryImpl(metadataProvider, pokemonFactory);
        when(pokedexFactory.createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class))).thenReturn(pokedex);

    }

    @Test
    public void testCreateTrainer() {
        String trainerName = "Ash Ketchum";
        Team team = Team.VALOR;

        PokemonTrainer trainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);


        assertNotNull(trainer, "Trainer should not be null");
        assertEquals(trainerName, trainer.getName(), "Trainer name should match the provided name");
        assertEquals(team, trainer.getTeam(), "Trainer team should match the provided team");

    }
}
