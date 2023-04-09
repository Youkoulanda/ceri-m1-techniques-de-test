package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
	private IPokemonMetadataProvider provider;

	public PokemonFactory(IPokemonMetadataProvider provider) {
		this.provider = provider;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
		PokemonMetadata metadata = provider.getPokemonMetadata(index);
		double iv = Math.random() * 100;
		return new Pokemon(index, 
				metadata.getName(), 
				metadata.getAttack(),
				metadata.getDefense(),
				metadata.getStamina(),
				cp,
				hp, 
				dust,
				candy,
				iv);
	}
}
