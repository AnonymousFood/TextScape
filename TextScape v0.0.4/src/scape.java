import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.util.*;
import templates.*;

public class scape
{
	templates.player character = new templates.player();
	
	public static void main(String[] args) throws IOException
	{
		scape thing = new scape();
		welcomeScreen();
		// characterSelect(); Currently W.I.P
		thing.loadCharacter();
		thing.inventory();
		
	}
	
	public static void welcomeScreen() // Shows welcome message to game
	{
		ImageIcon icon = new ImageIcon("TextScape.png");
        JOptionPane.showMessageDialog(null, "Welcome to TextScape!", 
        "Welcome", JOptionPane.INFORMATION_MESSAGE, icon);
        Scanner scnr = new Scanner(System.in);

		System.out.println("-----------------------   ");
		System.out.println(" Welcome to TextScape!    ");
		System.out.println("    Version 0.0.4         ");
		System.out.println("----------------------- \n");
		System.out.println("Press enter to continue.  ");
		scnr.nextLine();
	}
	
	// Initialization stage
	
	/*
	public static void characterSelect() throws IOException // Select Character
	{
	
		System.out.println("--------------------------------------");
		System.out.println("       Create a new character?        ");
		System.out.println("        1: New Character              ");
		System.out.println("        2: Existing Character         ");
		System.out.println("--------------------------------------");
	
	}
	
	public static String newCharacter() throws IOException // Used to create a new character (W.I.P)
	{
		File nameList = new File("characters/name");
		FileWriter writer = new FileWriter(nameList); 
		Scanner scnr = new Scanner(System.in); 
		
		System.out.println("Type the name of your character");
		String name = scnr.nextLine();
		writer.write(name);
		writer.flush();
		writer.close();
		
		return name;
	}
	*/
	
	public void loadCharacter() throws FileNotFoundException
	{
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("-----------------------------------");
		System.out.println("What is the name of your character?");
		System.out.println("        (Case sensitive)           ");
		System.out.println("-----------------------------------");
		
		String name = scnr.nextLine();
		File characterData = new File("src/players/" + name);
		Scanner file = new Scanner(characterData);
		
		while(file.hasNext())
		{
			character.name = file.next();
			character.gold = file.nextInt();
			character.helmetDefence = file.nextInt();
			character.armorDefence = file.nextInt();
			character.bootsDefence = file.nextInt();
			character.weaponAttack = file.nextInt();
			character.helmetName = file.next();
			character.armorName = file.next();
			character.bootsName = file.next();
			character.weaponName = file.next();
			character.level = file.nextInt();
			character.healthLevel = file.nextInt();
			character.attackLevel = file.nextInt();
			character.defenceLevel = file.nextInt();
		}
		
		System.out.println("Successfully loaded character for " + name + ". \n");
	}
	
	// Game start
	
	public void inventory() throws FileNotFoundException // Inventory
	{
		System.out.println("------------------------");
		System.out.println("You open your inventory.");
		System.out.println("1) Look at your stats");
		System.out.println("2) Look at your equipment");
		System.out.println("3) Continue");
		System.out.println("------------------------");
		

		Scanner scnr = new Scanner(System.in);
		boolean validAnswer = false;
		while(validAnswer == false)
		{
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
				randomEvent();
			} else {
				System.out.println("Please select 1, 2 or 3.");
			}
		}
	}
	
	public void randomEvent() throws FileNotFoundException // Decide where you go.
	{
		String enemyName = "Goblin";
		boolean win = false;
		Scanner scnr = new Scanner(System.in);

		win = events.fight.occur(enemyName, character);
		
		if(win == true)
		{
		events.fightRewards.give(enemyName, character);
		} else {
		inventory();
		}
	inventory();
	}
	
}
