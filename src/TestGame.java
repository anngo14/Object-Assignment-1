

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class TestGame {
	
	
	@Test
	public void testStandardRoundNumber()
	{
		Game war = new Game("Standard");
		Player firstPlayer = new Player("BOB");
		Player secondPlayer = new Player("SUE");
		war.addPlayers(firstPlayer);
		war.addPlayers(secondPlayer);
		
		war.setUpGame();
		war.startGame();
		int round = war.getRoundNumber();
		assertTrue(round <= 100);
	}
	
	@Test
	public void testScoreSum()
	{
		Game war = new Game("Score");
		int firstPlayerScore, secondPlayerScore;
		Player firstPlayer = new Player("BOB");
		Player secondPlayer = new Player("SUE");
		war.addPlayers(firstPlayer);
		war.addPlayers(secondPlayer);
		
		war.setUpGame();
		war.startGame();
		firstPlayerScore = firstPlayer.getScore();
		secondPlayerScore = secondPlayer.getScore();
		assertEquals(52, (firstPlayerScore + secondPlayerScore));
	}
	
	@Test
	public void testThreePlayersExist()
	{
		Game war = new Game("ThreePlayers");
		Player firstPlayer = new Player("BOB");
		Player secondPlayer = new Player("SUE");
		Player thirdPlayer = new Player("MAX");
		war.addPlayers(firstPlayer);
		war.addPlayers(secondPlayer);
		war.addPlayers(thirdPlayer);
		
		war.setUpGame();
		int numberOfPlayers = war.getPlayers();
		assertEquals(numberOfPlayers, 3);
	}
	
	@Test
	public void testGameInitialization()
	{
		Game standard = new Game("Standard");
		Game score = new Game("Score");
		Game threePlayer = new Game("ThreePlayers");
		
		assertNotNull(standard);
		assertNotNull(score);
		assertNotNull(threePlayer);
	}
	
	@Test
	public void testGameNullRuleSet()
	{
		String ruleTest = "TEST";
		Game war = new Game(ruleTest);
		assertNull(war.initializeRuleSet(ruleTest));
	}
}
