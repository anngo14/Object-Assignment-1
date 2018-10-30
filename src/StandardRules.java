import java.util.ArrayList;
/**
 * Standard Rules for the Game of War
 * @author Andrew Ngo
 *
 */
public class StandardRules extends RuleSet{
	/**
	 * Constructor of RuleSet
	 */
	public StandardRules()
	{
		super("Standard");
	}
	/**
	 * Handles how a round of War is implemented
	 */
	public void round(ArrayList<Player> playerList, ArrayList<PlayingCard> cardsInPlay)
	{
		PlayingCard cardInPlay;
		PlayingCard cardToCompare;
		int numberOfPlayer = playerList.size();
		
		for(int i = 0; i < numberOfPlayer - 1; i++)
		{
			cardInPlay = cardsInPlay.get(i);
			cardToCompare = cardsInPlay.get(i+1);
			System.out.println(playerList.get(i).getName() + " plays " + cardInPlay.getCardValue() + " of " + cardInPlay.getSuit() + " as up card");
			System.out.println(playerList.get(i+1).getName() + " plays " + cardToCompare.getCardValue() + " of " + cardToCompare.getSuit() + " as up card");
			comparePlayersCards(playerList, cardsInPlay);
		}	
	}
	/**
	 * Compares each Player's Cards
	 */
	public void comparePlayersCards(ArrayList<Player> playerList, ArrayList<PlayingCard> cardListToAdd)
	{
		PlayingCard firstCard = cardListToAdd.get(0);
		PlayingCard secondCard = cardListToAdd.get(1);
		
		if(compareCardValues(playerList.get(0), playerList.get(1), firstCard, secondCard) == playerList.get(0))
		{
			System.out.println(playerList.get(0).getName() + " wins the round");
			playerList.get(0).setHand(cardListToAdd);
		}
		else if(compareCardValues(playerList.get(0), playerList.get(1), firstCard, secondCard) == playerList.get(1))
		{
			System.out.println(playerList.get(1).getName() + " wins the round");
			playerList.get(1).setHand(cardListToAdd);
		}
		else if(compareCardValues(playerList.get(0), playerList.get(1), firstCard, secondCard) == null)
		{
			System.out.println("War!");
			tieBreaker(playerList.get(0), playerList.get(1), cardListToAdd);
		}
	}
	/**
	 * Determines the winner of the Game
	 */
	public void determineFinalWinner(ArrayList<Player> playerList)
	{
		int numberOfPlayers = playerList.size();
		Player highestHandPlayer = playerList.get(0);
		for(int i = 0 ; i < numberOfPlayers; i++)
		{
			if(highestHandPlayer.getHand().size() < playerList.get(i).getHand().size())
			{
				highestHandPlayer = playerList.get(i);
			}
		}
		System.out.println(highestHandPlayer.getName() + " wins!");
	}
}
