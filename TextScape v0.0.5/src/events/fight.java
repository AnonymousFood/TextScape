package events;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class fight {

	public static boolean occur(String enemyName, templates.player character) throws FileNotFoundException
	{
		boolean fight = true;
		boolean win;
		int health = character.healthLevel;
		int characterMaxHit = character.attackLevel +  + character.weaponAttack + 2;
		int answer;
		int damage;
		Scanner scnr = new Scanner(System.in);
		
		File enemyFile = new File("src/monsters/" + enemyName);
		Scanner enemyReader = new Scanner(enemyFile);
		int enemyHealth = enemyReader.nextInt();
		int enemyMaxHit = enemyReader.nextInt();
		
		
		System.out.println("---------------------------------");
		System.out.println("You are approached by a " + enemyName + ".");
		System.out.println("They have " + enemyHealth + " health.");
		System.out.println("--------------------------------- \n");
		System.out.println("Press enter to continue.");
		scnr.nextLine();
		System.out.println();
		
		while(fight == true)
		{
		
		System.out.println("-----------BATTLE-------------");
		System.out.println("------------------------------");
		System.out.println("Health: " + health + " Enemy Health: " + enemyHealth);
		System.out.println("Max hit: " + characterMaxHit);
		System.out.println("------------------------------");
		System.out.println("-----------OPTIONS------------");
		System.out.println("1) Attack");
		System.out.println("2) Run Away");
		

		answer = scnr.nextInt();
		System.out.println();
				if(answer == 1)
				{
						damage = (int) (Math.random() * (character.attackLevel +  + character.weaponAttack + 3));
						enemyHealth = enemyHealth - damage;
						System.out.println("------------------------------");
						System.out.println("You hit the " + enemyName + " for " + damage + " damage.");
						
						if(enemyHealth > 0)
						{
							damage = (int) (Math.random() * enemyMaxHit + 1);
							health = health - damage;
							System.out.println("You are hit for " + damage);
							System.out.println("------------------------------ \n");
							System.out.println("Press enter to continue. \n");
							scnr.nextLine();
							scnr.nextLine();
						} else {
							System.out.println("------------------------------");
							System.out.println("You win! \n");
							System.out.println("Press enter to continue. \n");
							scnr.nextLine();
							scnr.nextLine();
							return win = true;
						}
						
							if(health < 1)
							{
								System.out.println("You died. \n");
								
								character.helmetDefence = 0;
								character.armorDefence = 0;
								character.bootsDefence = 0;
								character.weaponAttack = 0;
								character.helmetName = "None";
								character.armorName = "None";
								character.bootsName = "None";
								character.weaponName = "None";
								
								System.out.println("Press enter to continue. \n");
								scnr.nextLine();
								return win = false;
							}
					
				} else if(answer == 2) {
					System.out.println("You are a coward. \n");
					System.out.println("Press enter to continue. \n");
					scnr.nextLine();
					System.out.println();
					return win = false;
				} else {
					System.out.println("Incorrect answer.");
				}
		}
		return win = false;
	}
}
