package functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.Scanner;

public class characterHandler {

	public static void initialize(templates.player character) throws IOException // Select Character
	{
		Scanner file = new Scanner(System.in);
		Scanner scnr = new Scanner(System.in);
		String characterName = "Null";
	
		System.out.println("---------------------------------");
		System.out.println("   Create or Load a character?   ");
		System.out.println("       Create   |   Load         ");
		System.out.println("---------------------------------");
	
		String answer = scnr.nextLine(); // Gets answer
		answer = answer.toLowerCase();
		
		boolean correctAns = false;
		while(correctAns == false) { // Only lets you pass if you choose a correct answer
			if(answer.contentEquals("create")) // Creates a new Character File
			{
				try {
					System.out.println("Type the name of your character");
					characterName = scnr.nextLine();
					
			        var source = new File("src/players/playerData");
			        var dest = new File("src/players/" + characterName);
		
			        Files.copy(source.toPath(), dest.toPath());
			        
					File characterData = new File("src/players/" + characterName);
					file = new Scanner(characterData);
					
					System.out.println("\nSuccessfully created character for " + characterName + "...");
					correctAns = true;
				} catch(FileAlreadyExistsException e) {
					System.out.println(characterName + " already exists. Load that character?");
					
					answer = scnr.nextLine();
					answer = answer.toLowerCase();
					
					if(answer.contentEquals("yes") || answer.contentEquals("y"))
					{
						File characterData = new File("src/players/" + characterName);
						file = new Scanner(characterData);
						correctAns = true;
					}
				}
		
			} else if(answer.contentEquals("load")) { // Loads an existing Character File	
				correctAns = true;
				boolean fileFound = false;
				
				System.out.println("-----------------------------------");
				System.out.println("What is the name of your character?");
				System.out.println("        (Case sensitive)           ");
				System.out.println("-----------------------------------");
				
				while(fileFound == false)
				{
					try {
						characterName = scnr.nextLine();
						File characterData = new File("src/players/" + characterName);
						file = new Scanner(characterData);
						
						System.out.println("\nSuccessfully found character for " + characterName + "...");
						fileFound = true;
						
					} catch (FileNotFoundException e) {
						System.out.println("-----------------------------------");
						System.out.println("       Character Not Found         ");
						System.out.println("  Please enter name of character   ");
						System.out.println("-----------------------------------");
					}
				}
				
			} else {
				System.out.println("Please type Create or Load");
			}
		}
			
			while(file.hasNext()) // Loads file in to Character Object
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

			System.out.println("Successfully loaded character data... \n");
	}
	
}
