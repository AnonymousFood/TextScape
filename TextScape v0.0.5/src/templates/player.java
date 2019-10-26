package templates;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class player {
	public String name = "Ralmok";
	
	public int gold = 10;
	
	public int helmetDefence = 0;
	public int armorDefence = 0;
	public int bootsDefence = 0;
	public int weaponAttack = 0;
	public String helmetName = "None";
	public String armorName = "None";
	public String bootsName = "None";
	public String weaponName = "None";
	
	public int level = 1;
	public int healthLevel = 10;
	public int attackLevel = 1;
	public int defenceLevel = 1;
	
	public static void inventory(templates.player character) throws FileNotFoundException // Inventory
	{
		System.out.println("------------------------");
		System.out.println("You open your inventory.");
		System.out.println("1) Look at your stats");
		System.out.println("2) Look at your equipment");
		System.out.println("3) Continue");
		System.out.println("------------------------");
		
		boolean finished = false;
		while(finished == false)
		{
			try {
				Scanner scnr = new Scanner(System.in);
				int answer = scnr.nextInt();
				System.out.println();
				
				if(answer == 1) {
					System.out.println("----------------------");
					System.out.println("Total level: " + character.level);
					System.out.println("Health level: " + character.healthLevel);
					System.out.println("Attack level: " + character.attackLevel);
					System.out.println("Defense level: " + character.defenceLevel);
					System.out.println("----------------------");
					System.out.println("Press 1 for stats, 2 for equipment, or 3 to continue.");
				} else if(answer == 2) {
					System.out.println("----------------------");
					System.out.println("Helmet: " + character.helmetName + " (" + character.helmetDefence + " Defence)");
					System.out.println("Armor: " + character.armorName + " (" + character.armorDefence + " Defence)");
					System.out.println("Boots: " + character.bootsName + " (" + character.bootsDefence + " Defence)");
					System.out.println("Weapon: " + character.weaponName + " (" + character.weaponAttack + " Attack)");
					System.out.println("You have " + character.gold + " gold.");
					System.out.println("----------------------");
					System.out.println("Press 1 for stats, 2 for equipment, or 3 to continue.");
				} else if(answer == 3) {
					finished = true;
					System.out.println("You continue on your adventure. \n");
				} else {
					System.out.println("Please select 1, 2 or 3.");
				}
			} catch(InputMismatchException e) {
				System.out.println("Select 1, 2 or 3.");
			}
		}
	}
	
}
