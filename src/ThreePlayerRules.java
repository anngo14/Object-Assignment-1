import java.util.ArrayList;
/**
 * Rule Set for Three Player War
 * @author Andrew Ngo
 *
 */
public class ThreePlayerRules extends RuleSet{
	/**
	 * Constructor for Rule Set
	 */
	public ThreePlayerRules() 
	{
		super("ThreePlayers");
	}
	/**
	 * Handles a single round in the Game of War
	 */
	public void round(ArrayList<Player> playerList, ArrayList<PlayingCard> cardsInPlay)
	{
		PlayingCard cardInPlay;
		PlayingCard cardToCompare;
		PlayingCard secondCardToCompare;
		int numberOfPlayer = playerList.size();
		
		cardInPlay = cardsInPlay.get(0);
		cardToCompare = cardsInPlay.get(1);
		secondCardToCompare = cardsInPlay.get(2);
		System.out.println(playerList.get(0).getName() + " plays " + cardInPlay.getCardValue() + " of " + cardInPlay.getSuit() + " as up card");
		System.out.println(playerList.get(1).getName() + " plays " + cardToCompare.getCardValue() + " of " + cardToCompare.getSuit() + " as up card");
		System.out.println(playerList.get(2).getName() + " plays " + secondCardToCompare.getCardValue() + " of " + secondCardToCompare.getSuit() + " as up card");
		comparePlayersCards(playerList, cardsInPlay);	
	}
	/**
	 * Handles a Tie in the Game of War
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
		compareFinalTwoPlayersCards(playerList, cardsInPlay);
	}
	/**
	 * Compares all of the Player's cards to each other
	 */
	public void comparePlayersCards(ArrayList<Player> playerList, ArrayList<PlayingCard> cardsToAdd) 
	{
		if(compareCardValues(playerList.get(0), playerList.get(1), cardsToAdd.get(0), cardsToAdd.get(1)) == playerList.get(0))
		{
			compareTwoPlayers(playerList, cardsToAdd, 0, 2);
		}
		else
		{
			compareTwoPlayers(playerList, cardsToAdd, 1, 2);
		}
	}
	/**
	 * Compares Two Specific Player's cards to each other 
	 * @param playerList ArrayList<Player>
	 * @param cardsToAdd ArrayList<PlayingCard>
	 * @param indexOfFirst index for the first player
	 * @param indexOfSecond index for the second player
	 */
	public void compareTwoPlayers(ArrayList<Player> playerList, ArrayList<PlayingCard> cardsToAdd, int indexOfFirst, int indexOfSecond)
	{
		if(compareCardValues(playerList.get(indexOfFirst), playerList.get(indexOfSecond), cardsToAdd.get(indexOfFirst), cardsToAdd.get(indexOfSecond)) == playerList.get(indexOfFirst))
		{
			System.out.println(playerList.get(indexOfFirst).getName() + " wins the round");
			playerList.get(indexOfFirst).setWonCards(cardsToAdd);
		}
		else if(compareCardValues(playerList.get(indexOfFirst), playerList.get(indexOfSecond), cardsToAdd.get(indexOfFirst), cardsToAdd.get(indexOfSecond)) == playerList.get(indexOfSecond))
		{
			System.out.println(playerList.get(indexOfSecond).getName() + " wins the round");
			playerList.get(indexOfSecond).setWonCards(cardsToAdd);
		}
		else
		{
			System.out.println("War!");
			tieBreaker(playerList.get(indexOfFirst), playerList.get(indexOfSecond), cardsToAdd);
		}
	}
	/**
	 * Compares the Cards after a Tie has occurred
	 * @param playerList ArrayList<Player>
	 * @param cardsInPlay ArrayList<PlayingCard>
	 */
	public void compareFinalTwoPlayersCards(ArrayList<Player> playerList, ArrayList<PlayingCard> cardsInPlay)
	{
		PlayingCard firstCard = cardsInPlay.get(0);
		PlayingCard secondCard = cardsInPlay.get(1);
		
		if(compareCardValues(playerList.get(0), playerList.get(1), firstCard, secondCard) == playerList.get(0))
		{
			System.out.println(playerList.get(0).getName() + " wins the round");
			playerList.get(0).setHand(cardsInPlay);
		}
		else if(compareCardValues(playerList.get(0), playerList.get(1), firstCard, secondCard) == playerList.get(1))
		{
			System.out.println(playerList.get(1).getName() + " wins the round");
			playerList.get(1).setHand(cardsInPlay);
		}
		else if(compareCardValues(playerList.get(0), playerList.get(1), firstCard, secondCard) == null)
		{
			System.out.println("War!");
			tieBreaker(playerList.get(0), playerList.get(1), cardsInPlay);
		}
	}
	/**
	 * Determines the final winner for the game of War
	 */
	public void determineFinalWinner(ArrayList<Player> playerList) 
	{
		int numberOfPlayers = playerList.size();
		Player highestPlayer = playerList.get(0);
		
		for(int i = 0; i < numberOfPlayers; i++)
		{
			if(highestPlayer.getWonCards().size() < playerList.get(i).getWonCards().size())
			{
				highestPlayer = playerList.get(i);
			}
		}
		System.out.println(highestPlayer.getName() + " wins!");
	}
}
