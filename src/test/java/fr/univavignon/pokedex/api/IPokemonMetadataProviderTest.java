import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.api.PokedexException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private static IPokemonMetadataProvider metadataProvider;
    private static PokemonMetadata expectedMetadata;

    @BeforeEach
    public void setup() {
        // Initialize the expected metadata for Bulbizarre
        expectedMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        System.out.println("expectedMetadata Created");
        // Mock the IPokemonMetadataProvider interface
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        System.out.println("Mock initialized");

        try {
            when(metadataProvider.getPokemonMetadata(0)).thenReturn(expectedMetadata);
            when(metadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid pokemon index"));
            when(metadataProvider.getPokemonMetadata(152)).thenThrow(new PokedexException("Invalid pokemon index"));
        } catch (PokedexException e) {
            System.out.println("Error during the when setup");
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturnBulbizarreIndex() throws PokedexException {
        // Call the method to test
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);

        // Assert the expected results
        assertEquals(expectedMetadata.getIndex(), result.getIndex());
    }

    @Test
    public void shouldReturnBulbizarreName() throws PokedexException {
        // Call the method to test
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);

        // Assert the expected results
        assertEquals(expectedMetadata.getName(), result.getName());
    }

    @Test
    public void shouldReturnBulbizarreAttack() throws PokedexException {
        // Call the method to test
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);

        // Assert the expected results
        assertEquals(expectedMetadata.getAttack(), result.getAttack());
    }

    @Test
    public void shouldReturnBulbizarreDefense() throws PokedexException {
        // Call the method to test
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);

        // Assert the expected results
        assertEquals(expectedMetadata.getDefense(), result.getDefense());
    }

    @Test
    public void shouldReturnBulbizarreStamina() throws PokedexException {
        // Call the method to test
        PokemonMetadata result = metadataProvider.getPokemonMetadata(0);

        // Assert the expected results
        assertEquals(expectedMetadata.getStamina(), result.getStamina());
    }



}
