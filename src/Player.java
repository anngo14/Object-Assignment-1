import java.util.ArrayList;
/**
 * Player object
 * @author Andrew Ngo
 *
 */
public class Player {
	
	private final String[] cardValues = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
	private ArrayList<PlayingCard> hand;
	private ArrayList<PlayingCard> wonCards;
	private String name;
	private int score;
	
	/**
	 * Constructor for Player object
	 * @param playerName name of the player to set 
	 */
	public Player(String playerName)
	{
		name = playerName;
		hand = new ArrayList<PlayingCard>();
		wonCards = new ArrayList<PlayingCard>();
		score = 0;
	}
	/**
	 * Sets the hand ArrayList<PlayingCard> of this Player object
	 * @param cards ArrayList<PlayingCard>
	 */
	public void setHand(ArrayList<PlayingCard> cards)
	{
		int numberOfCards = cards.size();
		PlayingCard cardToInsert;
		
		for(int i = 0; i < numberOfCards; i++)
		{
			cardToInsert = cards.get(i);
			hand.add(cardToInsert);
		}
	}
	/**
	 * Sets the won cards into a separate pile 
	 * @param cards ArrayList<PlayingCard>
	 */
	public void setWonCards(ArrayList<PlayingCard> cards)
	{
		int numberOfCardsToInsert = cards.size();
		PlayingCard cardToInsert;
		
		for(int i = 0; i < numberOfCardsToInsert; i++)
		{
			cardToInsert = cards.get(i);
			wonCards.add(cardToInsert);
		}
	}
	/**
	 * Sets the cards that each Player plays in a round 
	 * @param playerList ArrayList<Player>
	 * @return new ArrayList<PlayingCard> that holds all of the cards in play 
	 */
	public ArrayList<PlayingCard> setCardsInPlay(ArrayList<Player> playerList)
	{
		int numberOfPlayer = playerList.size();
		int indexOfHand = 0;
		PlayingCard cardInPlay;
		Player player;
		ArrayList<PlayingCard> cardsInPlay = new ArrayList<PlayingCard>();
	
		for(int i = 0; i < numberOfPlayer; i++)
		{
			player = playerList.get(i);
			cardInPlay = player.getHand().get(indexOfHand);
			cardsInPlay.add(cardInPlay);
			player.getHand().remove(indexOfHand);
		}
		
		return cardsInPlay;
	}
	/**
	 * Gets the Player's hand ArrayList
	 * @return ArrayList<PlayingCard>
	 */
	public ArrayList<PlayingCard> getHand()
	{
		return hand;
	}
	/**
	 * Gets the Player's name
	 * @return Player's name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Gets the ArrayList of PlayingCards that a Player has won
	 * @return ArrayList<PlayingCard>
	 */
	public ArrayList<PlayingCard> getWonCards()
	{
		return wonCards;
	}
	/**
	 * Gets the card value of a PlayingCard in a numerical format
	 * @param card PlayingCard to read
	 * @return number correlating to the card value
	 */
	public int getNumericalValue(PlayingCard card)
	{
		for(int i = 0; i < cardValues.length; i++)
		{
			if(card.getCardValue().compareTo(cardValues[i]) == 0)
			{
				return i+1;
			}
		}
		return 0;
	}
	/**
	 * Gets the score of the Player
	 * @return score value
	 */
	public int getScore()
	{
		int numberOfCards = this.wonCards.size();
		score = numberOfCards;
		return this.score;
	}
}
