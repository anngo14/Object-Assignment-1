import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestPlayingCard {

	@Test
	public void testCardEquals()
	{
		PlayingCard testCard = new PlayingCard();
		testCard.setSuit("HEARTS");
		testCard.setCardValue("ACE");
		
		assertEquals("HEARTS", testCard.getSuit());
		assertEquals("ACE", testCard.getCardValue());
	}
	
}
