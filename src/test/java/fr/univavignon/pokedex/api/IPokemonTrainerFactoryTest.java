package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    private PokemonMetadata aquali;
    private PokemonMetadata bulbizarre;

    @Before
    public void init() {
        // Utilisation de l'implémentation réelle du fournisseur de métadonnées
        pokemonMetadataProvider = new PokemonMetadataProvider();

        // Initialisation des objets PokemonMetadata pour les tests
        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Test pour un Pokémon valide (index 0 : Bulbizarre)
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        Assert.assertEquals(bulbizarre.getIndex(), metadata.getIndex());
        Assert.assertEquals(bulbizarre.getName(), metadata.getName());
        Assert.assertEquals(bulbizarre.getAttack(), metadata.getAttack());
        Assert.assertEquals(bulbizarre.getDefense(), metadata.getDefense());
        Assert.assertEquals(bulbizarre.getStamina(), metadata.getStamina());

        // Test pour un autre Pokémon valide (index 133 : Aquali)
        metadata = pokemonMetadataProvider.getPokemonMetadata(133);
        Assert.assertEquals(aquali.getIndex(), metadata.getIndex());
        Assert.assertEquals(aquali.getName(), metadata.getName());
        Assert.assertEquals(aquali.getAttack(), metadata.getAttack());
        Assert.assertEquals(aquali.getDefense(), metadata.getDefense());
        Assert.assertEquals(aquali.getStamina(), metadata.getStamina());

        // Test pour un index invalide (index négatif)
        try {
            pokemonMetadataProvider.getPokemonMetadata(-189);
            Assert.fail("Exception attendue");
        } catch (PokedexException e) {
            Assert.assertEquals("Pokemon not found", e.getMessage());
        }

        // Test pour un index trop grand
        try {
            pokemonMetadataProvider.getPokemonMetadata(313);
            Assert.fail("Exception attendue");
        } catch (PokedexException e) {
            Assert.assertEquals("Pokemon not found", e.getMessage());
        }
    }
}
