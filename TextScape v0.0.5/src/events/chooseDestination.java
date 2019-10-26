package events;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import templates.player;

public class chooseDestination {
	public static void occur(templates.player character) throws FileNotFoundException // Decide where you go.
	{
		System.out.println("-------------------------");
		System.out.println(" What do you want to do? ");
		System.out.println("   1 ) Open Inventory    ");
		System.out.println("   2 ) Go to the Swamp   ");
		System.out.println("-------------------------");
		
		Scanner scnr = new Scanner(System.in);
		boolean correctAnswer = false;
		while(correctAnswer == false) {
			try {
				int answer = scnr.nextInt();
				
				if(answer == 1) {
					correctAnswer = true;
					player.inventory(character);
				} else if(answer == 2) {	
					correctAnswer = true;
					String enemyName = "Null";
					int encounter = (int) (Math.random() * 2);
					boolean win = false;
					
					switch (encounter) {
						case 0: enemyName = "Goblin";
						case 1: enemyName = "Bandit";
					}
					
					win = events.fight.occur(enemyName, character);
					if(win == true)
					{
					events.fightRewards.give(enemyName, character);
					} 
				}
			} catch(InputMismatchException e) {
				System.out.println("Incorrect answer.");
			}
		}
		
		


		

	}
}
