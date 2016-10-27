package menu;

import java.util.Scanner;

import airlineinfo.Flight;
import main.HelpDateFormatter;
import main.MainProgram;
import main.MainProgram.MenuBranch;

/** A menu branch where the list of available flights is displayed;
 *  The client can choose one and order a ticket for it
 * @author Anastasia
 */
public class MenuClientNewClient implements IMenuStrategy {
	
	public MenuBranch menuAction(MenuBranch command) {
		
		Scanner scanner = new Scanner(System.in);
		String answer;		
		
		System.out.println("You can order a ticket to one of those flights (enter a number of the flight): ");
		
		//Display all the flights if they have order information and some seats left
		Integer i = 0;
		for (Flight flight : MainProgram.flightList) {
			i++;
			if (flight.getOrder()!=null && flight.getSeatsLeft()>0) {
				System.out.println(i.toString() + ". " + flight.getDestination() 
						+ " on " + HelpDateFormatter.DateFormatter(flight.getDate()));
			}
		}
		
		answer = scanner.nextLine();
		Integer chosenFlight;
				
		try {
		    chosenFlight = Integer.parseInt(answer);
		  } catch (NumberFormatException e) {
			  System.out.println("You entered something wrong");
		    return MenuBranch.NEWCLIENT;
		  }
				
		if (chosenFlight > i) {
			System.out.println("Please enter the correct value");
			return MenuBranch.NEWCLIENT;
		} else {
			i=0;
			MainProgram.currentFlight = null;
			for (Flight flight : MainProgram.flightList) {
				if (flight.getOrder()!=null) {
					i++;
				}
				if (i==chosenFlight) {
					MainProgram.currentFlight = flight;
					System.out.println("Do you want to order a ticket for this flight? (yes/no)");
					answer = scanner.nextLine();					
					if (answer.compareToIgnoreCase("yes")==0) {
						return MenuBranch.ORDERFLIGHT;
					} else {
						return MenuBranch.BACK;
					}					
				}
			}
			
			//if the program went there something is definitely wrong
			System.out.println("Something went wrong. Please try again later");
			return MenuBranch.BACK;
									
		}
		
	}

}
