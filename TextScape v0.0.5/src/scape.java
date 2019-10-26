import java.io.File;
import events.*;
import functions.*;
import templates.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.util.*;

public class scape
{

	templates.player character = new templates.player();
	
	public static void main(String[] args) throws IOException
	{
		scape gameObj = new scape();
		welcomeScreen();
		gameObj.init(); 
		gameObj.gameStart();
		
	}
	
	public static void welcomeScreen() // Shows welcome message to game
	{
		ImageIcon icon = new ImageIcon("TextScape.png");
        JOptionPane.showMessageDialog(null, "Welcome to TextScape!", 
        "Welcome", JOptionPane.INFORMATION_MESSAGE, icon);
        Scanner scnr = new Scanner(System.in);

		System.out.println("-----------------------   ");
		System.out.println(" Welcome to TextScape!    ");
		System.out.println("    Version 0.0.5         ");
		System.out.println("----------------------- \n");
		System.out.println("Press enter to continue.  ");
		scnr.nextLine();
	}
	
	public void init() throws IOException {
		characterHandler.initialize(character);
	}

	// Game start
	
	public void gameStart() throws FileNotFoundException {
		boolean bossTime = false;
		
		while(bossTime == false) 
		{
				chooseDestination.occur(character);
		}
	}
	
}