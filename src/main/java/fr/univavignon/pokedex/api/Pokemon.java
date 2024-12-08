package fr.univavignon.pokedex.api;

/**
 * Pokemon class representing a specific Pokemon with its combat attributes.
 * Extends the PokemonMetadata class to include additional attributes like CP, HP, dust, candy, and IV.
 *
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

	/** Combat Point (CP) of the Pokemon. **/
	private final int cp;

	/** HP (Hit Points) of the Pokemon. **/
	private final int hp;

	/** Required dust for upgrading this Pokemon. **/
	private final int dust;

	/** Required candy for upgrading this Pokemon. **/
	private final int candy;

	/** IV (Individual Value) perfection percentage. **/
	private final double iv;

	/**
	 * Constructor to create a new Pokemon instance with the given parameters.
	 *
	 * @param index Pokemon index (unique identifier for the Pokemon).
	 * @param name Name of the Pokemon.
	 * @param attack Attack level of the Pokemon.
	 * @param defense Defense level of the Pokemon.
	 * @param stamina Stamina level of the Pokemon.
	 * @param cp Combat Points (CP) of the Pokemon.
	 * @param hp Hit Points (HP) of the Pokemon.
	 * @param dust Amount of dust required to upgrade this Pokemon.
	 * @param candy Amount of candy required to upgrade this Pokemon.
	 * @param iv IV perfection percentage (a value between 0 and 1).
	 */
	public Pokemon(
			final int index,
			final String name,
			final int attack,
			final int defense,
			final int stamina,
			final int cp,
			final int hp,
			final int dust,
			final int candy,
			final double iv) {
		// Call the parent constructor to initialize the common Pokemon metadata
		super(index, name, attack, defense, stamina);
		this.cp = cp;
		this.hp = hp;
		this.dust = dust;
		this.candy = candy;
		this.iv = iv;
	}

	/**
	 * Returns the Combat Point (CP) of the Pokemon.
	 *
	 * @return CP of the Pokemon.
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * Returns the Hit Points (HP) of the Pokemon.
	 *
	 * @return HP of the Pokemon.
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Returns the amount of dust required to upgrade this Pokemon.
	 *
	 * @return The dust required for upgrading the Pokemon.
	 */
	public int getDust() {
		return dust;
	}

	/**
	 * Returns the amount of candy required to upgrade this Pokemon.
	 *
	 * @return The candy required for upgrading the Pokemon.
	 */
	public int getCandy() {
		return candy;
	}

	/**
	 * Returns the Individual Value (IV) perfection percentage of the Pokemon.
	 *
	 * @return The IV perfection percentage, a value between 0 and 1.
	 */
	public double getIv() {
		return iv;
	}

}
