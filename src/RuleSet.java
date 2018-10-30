import java.util.ArrayList;
/**
 * Abstract class for the different Game rules
 * @author Andrew Ngo
 *
 */
public abstract class RuleSet {

	private String ruleSetID;
	
	/**
	 * Constructor that sets the ruleSetId
	 * @param ruleID
	 */
	public RuleSet(String ruleID)
	{
		this.ruleSetID = ruleID;
	}
	/**
	 * Gets the rule ID
	 * @return the ruleSetID
	 */
	public final String getRuleID()
	{
		return this.ruleSetID;
	}
	/**
	 * Handles the Tie
	 * @param firstPlayer Player object
	 * @param secondPlayer Player object
	 * @param cardsInPlay ArrayList<PlayingCard>
	 */
	public void tieBreaker(Player firstPlayer, Player secondPlayer, ArrayList<PlayingCard> cardsInPlay)
	{
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(firstPlayer);
		playerList.add(secondPlayer);
		
		PlayingCard firstCardFaceDown = firstPlayer.getHand().get(0);
		firstPlayer.getHand().remove(0);
		PlayingCard secondCardFaceDown = secondPlayer.getHand().get(0);
		secondPlayer.getHand().remove(0);
		PlayingCard firstCardFaceUp = firstPlayer.getHand().get(0);
		firstPlayer.getHand().remove(0);
		PlayingCard secondCardFaceUp = secondPlayer.getHand().get(0);
		secondPlayer.getHand().remove(0);
		
		printPlayerHands(firstPlayer, secondPlayer, firstCardFaceUp, secondCardFaceUp);
		addWarCards(cardsInPlay, firstCardFaceUp, secondCardFaceUp, firstCardFaceDown, secondCardFaceDown);
		comparePlayersCards(playerList, cardsInPlay);
	}
	/**
	 * Prints the cards and Players that have been played in a two person game of war
	 * @param firstPlayer Player object
	 * @param secondPlayer Player object
	 * @param firstCardFaceUp PlayingCard object
	 * @param secondCardFaceUp PlayingCard object
	 */
	public final void printPlayerHands(Player firstPlayer, Player secondPlayer, PlayingCard firstCardFaceUp, PlayingCard secondCardFaceUp)
	{
		System.out.println(firstPlayer.getName() + " plays " + firstCardFaceUp.getCardValue() + " of " + firstCardFaceUp.getSuit() + " as up card");
		System.out.println(secondPlayer.getName() + " plays " + secondCardFaceUp.getCardValue() + " of " + secondCardFaceUp.getSuit() + " as up card");
	}
	/**
	 * Adds the cards from a Tie to the pile of PlayingCards
	 * @param cardsInPlay ArrayList<PlayingCard>
	 * @param first PlayingCard object
	 * @param second PlayingCard object
	 * @param third PlayingCard object
	 * @param fourth PlayingCard object
	 */
	public final void addWarCards(ArrayList<PlayingCard> cardsInPlay, PlayingCard first, PlayingCard second, PlayingCard third, PlayingCard fourth)
	{
		cardsInPlay.add(0, first);
		cardsInPlay.add(1, second);
		cardsInPlay.add(third);
		cardsInPlay.add(fourth);
	}
	/**
	 * Compares two cards in play
	 * @param firstPlayer Player object
	 * @param secondPlayer Player object
	 * @param firstCard PlayingCard object
	 * @param secondCard PlayingCard object
	 * @return Player who has the higher PlayingCard
	 */
	public final Player compareCardValues(Player firstPlayer, Player secondPlayer, PlayingCard firstCard, PlayingCard secondCard)
	{
		int numericalFirstCardValue = firstPlayer.getNumericalValue(firstCard);
		int numericalSecondCardValue = secondPlayer.getNumericalValue(secondCard);
		
		if(numericalFirstCardValue > numericalSecondCardValue)
		{
			return firstPlayer;
		}
		else if(numericalFirstCardValue < numericalSecondCardValue)
		{
			return secondPlayer;
		}
		return null;
	}
	/**
	 * Abstract method to implement handles one round of war
	 * @param playerList ArrayList<Player>
	 * @param cardsInPlay ArrayList<PlayingCard>
	 */
	public abstract void round(ArrayList<Player> playerList, ArrayList<PlayingCard> cardsInPlay);
	
	/**
	 * Abstract method to implement compares all players and all cards in play
	 * @param playerList ArrayList<Player>
	 * @param cardsToAdd ArrayList<PlayingCards>
	 */
	public abstract void comparePlayersCards(ArrayList<Player> playerList, ArrayList<PlayingCard> cardsToAdd);
	
	/**
	 * Abstract method to implement determines the final winner of the game of war
	 * @param playerList ArrayList<Player>
	 */
	public abstract void determineFinalWinner(ArrayList<Player> playerList);
	
}
