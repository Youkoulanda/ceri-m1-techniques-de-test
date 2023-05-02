package fr.univavignon.pokedex.api;

import java.util.HashMap;

public class PokemonMetadataProvider  implements IPokemonMetadataProvider{
	
	HashMap<Integer, PokemonMetadata> metaDataDic;

	public PokemonMetadataProvider(HashMap<Integer, PokemonMetadata> metaDataDic) {
		metaDataDic = new HashMap<Integer, PokemonMetadata>();
	}
	
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {	
		
		if(index < 0 || index > 150) {
			throw new PokedexException("Index is not valid");
		}
		
		if(!metaDataDic.containsKey(index)) {
			throw new PokedexException("Could not find pokemon");
		}
		
		return	metaDataDic.get(index);
	}


}
