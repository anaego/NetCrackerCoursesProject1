package etc;

/** A custom exception for the processing incorrect input values 
 * (i'll use it in getters/setters while checking for incorrect values) 
 * @author Anastasia
 */
public class IncorrectValueException extends Exception {
	
	/** So it wouldn't give me a warning 
	 */
	private static final long serialVersionUID = 1L;

	//Parameterless Constructor
    public IncorrectValueException() {}

    //Constructor that accepts a message
    public IncorrectValueException(String message)
    {
       super(message);
    }

}
