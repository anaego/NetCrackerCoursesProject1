package menu;

import main.MainProgram;
import main.MainProgram.MenuBranch;

/**Interface for the strategy pattern (for the menu) 
 * @author Anastasia
 */
public interface IMenuStrategy {
	
	MenuBranch menuAction(MenuBranch command);

}
