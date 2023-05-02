package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
	
	PokemonMetadataProvider pokemonMetadataprovider;
	
	public PokemonFactory(PokemonMetadataProvider pokemonMetadataprovider){
		this.pokemonMetadataprovider = pokemonMetadataprovider;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {	
		
		Pokemon pokemon;
		
		try {
			String name = pokemonMetadataprovider.getPokemonMetadata(index).getName();
			int attack = pokemonMetadataprovider.getPokemonMetadata(index).getAttack();
			int defense = pokemonMetadataprovider.getPokemonMetadata(index).getDefense();
			int stamina = pokemonMetadataprovider.getPokemonMetadata(index).getStamina();
			double iv = 0.9;
			
			pokemon = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
			
		} catch (PokedexException e) {
			e.printStackTrace();
			return null;
		}	
		
		return pokemon;
	}

}
