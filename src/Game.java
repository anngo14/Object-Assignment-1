import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * Game class to set up the game of war
 * @author Andrew Ngo
 *
 */
public class Game {

	private ArrayList<Player> playerList;
	private Deck deckOfCards;
	private RuleSet referee;
	private ArrayList<PlayingCard> cardsInPlay;
	private ArrayList<PlayingCard> shuffledDeck;
	private int roundNumber;
	
	/**
	 * Constructor for Game 
	 * @param ruleID Specified rule set for the game
	 */
	public Game(String ruleID)
	{
		playerList = new ArrayList<Player>();
		deckOfCards = new Deck();
		referee = initializeRuleSet(ruleID);
		cardsInPlay = new ArrayList<PlayingCard>();	
		shuffledDeck = new ArrayList<PlayingCard>();	
		roundNumber = 0;
	}
	/**
	 * Sets the rule set for the Game object
	 * @param rule Rules to set Game object 
	 * @return new ruleSet extended class
	 */
	public RuleSet initializeRuleSet(String rule)
	{
		if(rule.compareTo("Standard") == 0)
		{
			StandardRules referee = new StandardRules();
			return referee;
		}
		else if(rule.compareTo("Score") == 0)
		{
			ScoreRules referee = new ScoreRules();
			return referee;
		}
		else if(rule.compareTo("ThreePlayers") == 0)
		{
			ThreePlayerRules referee = new ThreePlayerRules();
			return referee;
		}
		else
		{
			return null;
		}
	}
	/**
	 * Initializes the PlayingCards for the Game
	 */
	public void setUpGame()
	{
		shuffledDeck = deckOfCards.shuffleDeck();
		deckOfCards.dealCards(playerList, shuffledDeck);
	}
	/**
	 * Adds Player to the Game object
	 * @param newPlayer Player object to add
	 */
	public void addPlayers(Player newPlayer)
	{
		playerList.add(newPlayer);
	}
	/**
	 * Gets the round number of the Game object
	 * @return round number
	 */
	public int getRoundNumber()
	{
		return this.roundNumber;
	}
	/**
	 * Starts the Game of War
	 */
	public void startGame()
	{
		Player player = new Player("Temporary Player");
		while(gameOver(roundNumber) == false)
		{			
			cardsInPlay = player.setCardsInPlay(this.playerList);
			referee.round(this.playerList, cardsInPlay);
			roundNumber++;
		}
		referee.determineFinalWinner(this.playerList);
		
	}
	/**
	 * Returns the number of Players in the game object
	 * @return number of Players in the ArrayList playerList
	 */
	public int getPlayers()
	{
		int numberOfPlayers = this.playerList.size();
		return numberOfPlayers;
	}
	/**
	 * Determines if the Game should stop or continue
	 * @param roundNumber number of Rounds of war that have occurred 
	 * @return boolean true or false 
	 */
	public boolean gameOver(int roundNumber)
	{
		int numberOfPlayers = this.playerList.size();
		Player player;
		for(int i = 0; i < numberOfPlayers; i++)
		{
			player = this.playerList.get(i);
			if(player.getHand().isEmpty() || roundNumber == 100)
			{
				System.out.println("Game Over!");
				return true;
			}
		}
		return false;
	}
}
