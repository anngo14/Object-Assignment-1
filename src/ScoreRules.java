import java.util.ArrayList;
/**
 * Score Rules for the Game of War
 * @author Andrew Ngo
 *
 */
public class ScoreRules extends RuleSet{
	/**
	 * Constructor for Rule Set
	 */
	public ScoreRules()
	{
		super("Score");
	}
	/**
	 * Handles a single round for the Game of War
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
			printScore(playerList);
		}	
	}
	/**
	 * Prints the score of each Player
	 * @param playerList ArrayList<Player>
	 */
	public void printScore(ArrayList<Player> playerList)
	{
		System.out.print("Score is " + playerList.get(0).getName() + " is " + playerList.get(0).getScore());
		System.out.println(", " + playerList.get(1).getName() + " is " + playerList.get(1).getScore());
	}
	public void comparePlayersCards(ArrayList<Player> playerList, ArrayList<PlayingCard> cardsToAdd) 
	{
		PlayingCard firstCard = cardsToAdd.get(0);
		PlayingCard secondCard = cardsToAdd.get(1);
		
		if(compareCardValues(playerList.get(0), playerList.get(1), firstCard, secondCard) == playerList.get(0))
		{
			System.out.println(playerList.get(0).getName() + " wins the round");
			playerList.get(0).setWonCards(cardsToAdd);
		}
		else if(compareCardValues(playerList.get(0), playerList.get(1), firstCard, secondCard) == playerList.get(1))
		{
			System.out.println(playerList.get(1).getName() + " wins the round");
			playerList.get(1).setWonCards(cardsToAdd);
		}
		else if(compareCardValues(playerList.get(0), playerList.get(1), firstCard, secondCard) == null)
		{
			System.out.println("War!");
			tieBreaker(playerList.get(0), playerList.get(1), cardsToAdd);
		}
	}
	/**
	 * Determines the Final Winner of the Game of War
	 */
	public void determineFinalWinner(ArrayList<Player> playerList) {

		Player highestScorePlayer = playerList.get(0);
		
		if(highestScorePlayer.getScore() < playerList.get(1).getScore())
		{
			highestScorePlayer = playerList.get(1);
		}
		if(playerList.get(0).getScore() == playerList.get(1).getScore())
		{
			System.out.println("Tie Game!");
		}
		else
		{
			System.out.println(highestScorePlayer.getName() + " wins!");
		}
		
	}
}
