package menu;

import main.MainProgram;
import main.MainProgram.MenuBranch;

/** For the implementation of the strategy patern (for the menu)
 * 
 * @author Anastasia
 *
 */
public class MenuSwitch {
	
	private IMenuStrategy menuStrategy;
	
	public MenuSwitch(IMenuStrategy menuStrategy) {
		this.menuStrategy = menuStrategy;
	}
	
	public void setMenuAction(IMenuStrategy menuStrategy) {
		this.menuStrategy = menuStrategy;
	}
	
	public MenuBranch menuAction(MenuBranch command) {
		return menuStrategy.menuAction(command);
	}

}
