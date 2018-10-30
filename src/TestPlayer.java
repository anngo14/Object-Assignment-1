import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void testPlayerCreate()
	{
		Player testPlayer = new Player("TESTER");
		assertNotNull(testPlayer);
	}
	
	@Test
	public void testPlayerNameSet()
	{
		Player testPlayer = new Player("TESTER");
		assertEquals("TESTER", testPlayer.getName());
	}
	
	@Test
	public void testScoreChange()
	{
		Game war = new Game("Score");
		Player firstPlayer = new Player("BOB");
		Player secondPlayer = new Player("SUE");
		
		war.addPlayers(firstPlayer);
		war.addPlayers(secondPlayer);
		
		war.setUpGame();
		war.startGame();
		
		assertTrue(firstPlayer.getScore() > 0);
		assertTrue(secondPlayer.getScore() > 0);
	}
	
	@Test
	public void testNumericalConvert()
	{
		Player firstPlayer = new Player("BOB");
		PlayingCard testCard = new PlayingCard();
		
		testCard.setCardValue("FIVE");
		assertTrue(firstPlayer.getNumericalValue(testCard) == 5);
	}
}
