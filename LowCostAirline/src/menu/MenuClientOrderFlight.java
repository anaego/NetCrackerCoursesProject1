package menu;

import java.util.Scanner;

import main.MainProgram;
import main.MainProgram.MenuBranch;

/** A menu branch where the client can order a ticket
 *  for the flight they chose earlier
 * @author Anastasia
 */
public class MenuClientOrderFlight implements IMenuStrategy {
	
	public MenuBranch menuAction(MenuBranch command) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please tell us how much luggage do you have (in kgs)");
		String answer = scanner.nextLine();
		try {
			MainProgram.currentClient.setLuggageWeight(Integer.parseInt(answer));
		} catch (NumberFormatException e) {
			System.out.println("You entered something wrong. Please try again");
			return MenuBranch.ORDERFLIGHT;
		}
		if (MainProgram.currentClient.getLuggageWeight()<0)
		{
			System.out.println("You entered something wrong. Please try again");
			return MenuBranch.ORDERFLIGHT;
		}
		
		System.out.println("Do you want to be able to choose your seat? (yes/no)");
		answer = scanner.nextLine();
		if (answer.compareToIgnoreCase("yes")==0){
			MainProgram.currentClient.setRegisterFirst(true);
		} else if (answer.compareToIgnoreCase("no")==0) {
			MainProgram.currentClient.setRegisterFirst(false);
		} else {
			System.out.println("You entered something wrong. Please try again");
			return MenuBranch.ORDERFLIGHT;
		}
		
		MainProgram.currentFlight.setSeatsLeft(MainProgram.currentFlight.getSeatsLeft()-1);
		MainProgram.currentClient.orderTicket(MainProgram.currentFlight);
		
		System.out.println("Do you want to pay now? (yes/no)");
		answer = scanner.nextLine();
		if (answer.compareToIgnoreCase("yes")==0) {			
			return MenuBranch.PAY;
		} else {
			return MenuBranch.BACK;
		}
		

	}

}
