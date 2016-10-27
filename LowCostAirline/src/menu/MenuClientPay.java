package menu;

import main.MainProgram;
import main.MainProgram.MenuBranch;

/** A menu branch where the client can pay for their ticket 
 * @author Anastasia
 */
public class MenuClientPay implements IMenuStrategy {
	
	public MenuBranch menuAction(MenuBranch command) {
		
		MainProgram.currentClient.payForTicket();
		System.out.println("Your ticket is paid for! Have a safe flight");
		return MenuBranch.SAVEDECISION;
	}

}
