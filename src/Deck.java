import java.util.ArrayList;
/**
 * Deck Object that holds PlayingCards
 * @author Andrew Ngo
 *
 */
public class Deck {

	private ArrayList<PlayingCard> deck;
	private final int numberOfPlayingCards = 52;
	private final String[] cardValues = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
	
	/**
	 * Constructor of Deck object 
	 */
	public Deck() 
	{
		deck = new ArrayList<PlayingCard>();
		initializeDeck(deck);
	}
	/**
	 * Initializes the deck to hold 52 PlayingCards
	 * @param deckOfCards ArrayList<PlayingCard>
	 */
	public void initializeDeck(ArrayList<PlayingCard>deckOfCards)
	{
		initializeCards(deckOfCards, 0, numberOfPlayingCards/4, "HEARTS");
		initializeCards(deckOfCards, numberOfPlayingCards/4, numberOfPlayingCards/2, "DIAMONDS");
		initializeCards(deckOfCards, numberOfPlayingCards/2, 3*numberOfPlayingCards/4, "CLUBS");
		initializeCards(deckOfCards, 3*numberOfPlayingCards/4, numberOfPlayingCards, "SPADES");
	}
	/**
	 * Sets the deck of cards depending on the suit specified
	 * @param deckOfCards ArrayList<PlayingCard>
	 * @param from index to start at
	 * @param to index to end at
	 * @param suit suit to set the playing card 
	 */
	public void initializeCards(ArrayList<PlayingCard> deckOfCards, int from, int to, String suit)
	{
		int indexForCardValue = 0;
		for(int i = from; i < to; i++)
		{
			PlayingCard newCardToInsert = new PlayingCard();
			newCardToInsert.setSuit(suit);
			newCardToInsert.setCardValue(cardValues[indexForCardValue]);
			deckOfCards.add(i, newCardToInsert);
			indexForCardValue++;
		}
	}
	/**
	 * Shuffles the deck of cards in a random order
	 * @return new ArrayList<PlayingCard> of shuffled cards
	 */
	public ArrayList<PlayingCard> shuffleDeck()
	{
		ArrayList<PlayingCard> shuffledDeck = new ArrayList<PlayingCard>();
		ArrayList<Integer> referencedCards = new ArrayList<Integer>();
		PlayingCard cardToInsert;
		int indexToDeck = (int)(Math.random() * (numberOfPlayingCards));

		for(int i = 0; i < numberOfPlayingCards; i++)
		{
			while(referencedCards.contains(indexToDeck))
			{
				indexToDeck = (int)(Math.random() * (numberOfPlayingCards));
			}
			referencedCards.add(indexToDeck);
			
			cardToInsert = this.deck.get(indexToDeck);
			shuffledDeck.add(cardToInsert);
		}
		return shuffledDeck;
	}
	/**
	 * Sets the cards for each player
	 * @param players ArrayList<Player> of Players
	 * @param deckOfCards ArrayList<PlayingCard> of PlayingCards
	 */
	public void dealCards(ArrayList<Player> players, ArrayList<PlayingCard> deckOfCards)
	{
		int numberOfPlayers = players.size();
		int numberOfCardsPerPlayer = numberOfPlayingCards / numberOfPlayers;	
		int indexForDeckOfCards = 0;
		
		for(int i = 0; i < numberOfPlayers; i++)
		{
			ArrayList<PlayingCard> cardsToDeal = new ArrayList<PlayingCard>();
			for(int j = 0; j < numberOfCardsPerPlayer; j++)
			{
				PlayingCard cardToInsert = deckOfCards.get(indexForDeckOfCards);
				cardsToDeal.add(cardToInsert);
				indexForDeckOfCards++;
			}
			players.get(i).setHand(cardsToDeal);
		}
		dealExtraCards(players, deckOfCards, numberOfCardsPerPlayer);
	}
	/**
	 * Handles extra cards that have not been yet dealt
	 * @param players ArrayList<Players>
	 * @param extraCards ArrayList<PlayingCard> of remaining PlayingCards
	 * @param numberOfCardsPerPlayer the number of cards each player currently holds divided evenly
	 */
	public void dealExtraCards(ArrayList<Player> players, ArrayList<PlayingCard> extraCards, int numberOfCardsPerPlayer)
	{
		int numberOfExtraCards = numberOfPlayingCards - (numberOfCardsPerPlayer * players.size());
		int indexOfPlayer = 0;
		while(numberOfExtraCards > 0)
		{
			ArrayList<PlayingCard> cardsToDeal = new ArrayList<PlayingCard>();
			PlayingCard cardToInsert = extraCards.get(extraCards.size() - numberOfExtraCards);
			cardsToDeal.add(cardToInsert);
			players.get(indexOfPlayer).setHand(cardsToDeal);
			indexOfPlayer++;
			
			if(indexOfPlayer > players.size())
			{
				indexOfPlayer = 0;
			}
			numberOfExtraCards--;
		}
	}
	/**
	 * Returns the deck 
	 * @return ArrayList of PlayingCard
	 */
	public ArrayList<PlayingCard> getDeck()
	{
		return deck;
	}
}
