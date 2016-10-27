package menu;

import java.util.Scanner;

import main.MainProgram;
import main.MainProgram.MenuBranch;

/** A menu branch where the client can choose to save their ticket to a file
 * 
 * @author Anastasia
 *
 */
public class MenuClientSaveDecision implements IMenuStrategy {
	
	public MenuBranch menuAction(MenuBranch command) {
		
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Do you want to save it to a file? (yes/no)");
		String answer = scanner.nextLine();
		if (answer.compareToIgnoreCase("yes")==0) 
			return  MenuBranch.SAVETICKET;
		else if (answer.compareToIgnoreCase("no")==0)
			return MenuBranch.BACK;
		else {
			System.out.println("Please enter either yes or no");
			return MenuBranch.SAVEDECISION;
		}
	}

}
