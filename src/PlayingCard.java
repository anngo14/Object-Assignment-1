/**
 * PlayingCard object that contains a suit and a cardValue
 * @author Andrew Ngo
 *
 */
public class PlayingCard {
	
	private String suit;
	private String cardValue;
	
	/**
	 * Constructor of PlayingCard Object
	 */
	public PlayingCard() 
	{
		suit = "";
		cardValue = "";
	}
	/**
	 * Sets the suit of this PlayingCard
	 * @param suitOfPlayingCard suit to set to PlayingCard object
	 */
	public void setSuit(String suitOfPlayingCard)
	{
		suit = suitOfPlayingCard;
	}
	/**
	 * Sets the card value of this PlayingCard
	 * @param valueOfPlayingCard value to set to PlayingCard object
	 */
	public void setCardValue(String valueOfPlayingCard)
	{
		cardValue = valueOfPlayingCard;
	}
	/**
	 * Gets the suit of this PlayingCard
	 * @return suit of PlayingCard
	 */
	public String getSuit()
	{
		return suit;
	}
	/**
	 * Gets the card value of this PlayingCard
	 * @return card value of PlayingCard
	 */
	public String getCardValue()
	{
		return cardValue;
	}
}
