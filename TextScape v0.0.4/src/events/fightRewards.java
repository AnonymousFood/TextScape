package events;

import java.util.Scanner;

public class fightRewards {

	templates.monster monster = new templates.monster();

	public static void give(String enemyName, templates.player character)
	{
		Scanner scnr = new Scanner(System.in);
		String answer;
		String rewardName = "Nothing";
		String rewardType = "";
		int rewardSlot = 0;
		int rewardStat = 0;
		int luck = (int) (Math.random() * 100 + 1);
		int gold = 0;
		boolean itemGet = false;

		if(enemyName.contentEquals("Goblin")) 
		{
			gold = (int) (Math.random() * 5);
			if(luck >= 20) {
				rewardName = "Wooden Helmet";
				rewardType = "def";
				rewardStat = 1;
				rewardSlot = 0;
				gold = (int) (Math.random() * 3) + 1;
				itemGet = true;
			} else if(luck >= 50) {
				rewardName = "Dagger";
				rewardType = "atk";
				rewardStat = 1;
				rewardSlot = 3;
				gold = (int) (Math.random() * 4) + 2;
				itemGet = true;
			}
		}
		
		character.gold = character.gold + gold;
		
		if (itemGet == true)
		{
			System.out.println("------------------------");
			System.out.println("You got " + rewardName + " (" + rewardStat + " " + rewardType + ")");
			System.out.println("You got " + gold + " gold!");
			System.out.println("------------------------ \n");
			
			System.out.println("--------------------------");
			switch(rewardSlot) {
			case(0):
				System.out.println("Do you want to replace " + character.helmetName + "(" + character.helmetDefence + " def)");
				System.out.println("With " + rewardName + "(" + rewardStat + " def)?");
				break;
			case(1):
				System.out.println("Do you want to replace " + character.armorName + "(" + character.armorDefence + " def)");
				System.out.println("With " + rewardName + "(" + rewardStat + " def)?");
				break;
			case(2):
				System.out.println("Do you want to replace " + character.bootsName + "(" + character.bootsDefence + " def)");
				System.out.println("With " + rewardName + "(" + rewardStat + " def)?");
				break;
			case(3):
				System.out.println("Do you want to replace " + character.weaponName + "(" + character.weaponAttack + " atk)");
				System.out.println("With " + rewardName + "(" + rewardStat + " atk)?");
				break;
				}

			System.out.println("--------------------------");
			System.out.println("       (yes / no)         ");
			
			answer = scnr.nextLine();
			answer = answer.toLowerCase();
			
			if(answer.contentEquals("yes"))
			{
				System.out.println("You replace your gear with the new item. \n");
				if(rewardSlot == 0) {
					character.helmetName = rewardName;
					character.helmetDefence = rewardStat;
				} else if(rewardSlot == 1) {
					character.armorName = rewardName;
					character.armorDefence = rewardStat;
				} else if(rewardSlot == 2) {
					character.bootsName = rewardName;
					character.bootsDefence = rewardStat;
				} else if(rewardSlot == 3) {
					character.weaponName = rewardName;
					character.weaponAttack = rewardStat;
				}
			} else {
				System.out.println("You leave the item behind. \n");
			}
		} else {
			System.out.println("The " + enemyName + " dropped nothing!");
		}
			
			System.out.println("Press enter to continue. \n");
			scnr.nextLine();
			System.out.println();

	}
	
	/*
	 * Slot 0 = Helmet
	 * Slot 1 = Armor
	 * Slot 2 = Boots
	 * Slot 3 = Weapon
	 */
}
