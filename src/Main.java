import java.util.Scanner;

/**
 * Main Driver for the Game of War 
 * @author Andrew Ngo
 *
 */
public class Main {
	
	/**
	 * Main method that creates and runs the Game of War depending on the user input for the rule set
	 * @param args String[]
	 */
	public static void main(String[] args) {
		System.out.print("Enter a Rule Set (Standard, Score, ThreePlayers): ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		Game war = new Game(input);
		Player firstPlayer = new Player("BOB");
		Player secondPlayer = new Player("SUE");
		Player thirdPlayer = new Player("MAX");		
		
		war.addPlayers(firstPlayer);
		war.addPlayers(secondPlayer);
		if(input.compareTo("ThreePlayers") == 0)
		{
			war.addPlayers(thirdPlayer);
		}
		
		war.setUpGame();
		war.startGame();	
	}

}
