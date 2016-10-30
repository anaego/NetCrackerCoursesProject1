package menu;

import java.util.Scanner;
import clientinfo.Client;
import etc.HelpDateFormatter;
import main.MainProgram;
import main.MainProgram.MenuBranch;

/**The first menu branch where customer must enter their name  
 * If they're already in the clients list it's checked whether they have a ticket etc 
 * They're offered to order a ticket, or pay for it, or save the ticket to a file
 * @author Anastasia
 */
public class Menu1ClientCourse implements IMenuStrategy {
	
	public MenuBranch menuAction(MenuBranch command) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("---Starting the new session---");
		System.out.println("Enter your name please");
		String answer = scanner.nextLine();
		boolean haveClient = false;
		
		for (Client client : MainProgram.clientList ) {

			if (answer.compareToIgnoreCase(client.getName())==0) {
				
				haveClient=true;
				MainProgram.currentClient = client;
				
				if (client.getTicket() != null) {
					System.out.println("You have a ticket ordered! " 
							+ HelpDateFormatter.DateFormatter(client.getTicket().getDate() )
							+ ", for" + client.getTicket());
					
					if (client.getTicket().isPaidFor()==true) {
						System.out.println("Your ticket is paid for. Have a safe flight!");
						return MenuBranch.SAVEDECISION;
						
					} else {						
						System.out.println("Do you want to pay for the ticket now? (yes/no)");
						answer = scanner.nextLine();
						if (answer.compareToIgnoreCase("yes")==0) {
							return MenuBranch.PAY;
						}
						
						System.out.println("Do you want to change booking? (yes/no)");
						answer = scanner.nextLine();
						if (answer.compareToIgnoreCase("yes")==0)
							return MenuBranch.NEWCLIENT;
						else
							return MenuBranch.BACK;
					}
				} else {
					return MenuBranch.NEWCLIENT;
				}
				
			}
		}
		
		if (haveClient==false) {
			Client newClient = new Client(answer);			
			MainProgram.clientList.add(newClient);
			MainProgram.currentClient = newClient;
			return MenuBranch.NEWCLIENT;			
		}
		
		System.out.println("Something has gone wrong. Please start again");
		return MenuBranch.BACK;
	
		
	}

}
