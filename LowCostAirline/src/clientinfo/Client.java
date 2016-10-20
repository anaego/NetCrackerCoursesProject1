package clientinfo;

import airlineinfo.Flight;
import airlineinfo.Order;
import airlineinfo.Ticket;

/** Client class - represents a client of the airline.
 * Contains info about their luggage and whether the order the first priority boarding right.
 * @author Anastasia
 */
public class Client extends Human {
	
	private int luggageWeight;
	private boolean registerFirst;
	
	/** static variable for object counting
	 */
	public static int counter;
	
	/** Constructor for Client; 
	 * @param name - for establishing the client's name;
	 * also for counting objects of type Client
	 */
	public Client(String name) {
		super(name);
		
		counter++;
	}
	
	//getters and setters
	
	public int getLuggageWeight() {
		return luggageWeight;
	}
	
	public void setLuggageWeight(int clientLuggageWeight) {
		
		if (clientLuggageWeight>=0) 
			luggageWeight=clientLuggageWeight;
		else
			System.out.println("Incorrect luggage weight value");
	}
	
	public boolean getRegisterFirst() {
		return registerFirst;
	}
	
	public void setRegisterFirst(boolean clientRegisterFirst) {
		registerFirst=clientRegisterFirst;
	}
	
	
	/** Method for ordering the ticket - creating the ticket object 
	 * with a set price; 
	 * @param flightInfo - Flight type object with information about the flight; 
	 * @param orderInfo - Order type object with info about the price coefficients and such
	 * @return
	 */
	public Ticket orderTicket(Order orderInfo, Flight flightInfo) {
		
		Ticket ticket = new Ticket();
				
		if (flightInfo.getSeatsLeft()!=0) {
			
			ticket.setDate(flightInfo.getDate());
			ticket.setPlane(flightInfo.getPlane());
						
			ticket.setPrice( orderInfo.calculatePrice(flightInfo.getSeatsLeft(), getLuggageWeight(), getRegisterFirst()) );
			
			System.out.println("The ticket is ordered");
			System.out.println("The price is " + ticket.getPrice());			
		} else {
			System.out.println("There are no seats left on this flight");
		}		
		
		return ticket;
	}
	
	/**Method for paying for the ticket; 
	 * !currently i have no idea how it should be done (bank transaction???); 
	 * @param ticket - information about the ticket the client is paying for
	 */
	public void payForTicket(Ticket ticket) {
		
		//bank transaction???
		
		ticket.setPaidFor(true);
				
		System.out.print("The ticket is paid for");
	}

	//Overridden methods (automatically generated)
	
	/* Overridden hashCode(); 
	 * will always return the same result; 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + luggageWeight;
		result = prime * result + (registerFirst ? 1231 : 1237);
		return result;
	}

	/* Overridden equals(): 
	 * compare the properties of the objects; 
	 * and some other stuff; 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (luggageWeight != other.luggageWeight)
			return false;
		if (registerFirst != other.registerFirst)
			return false;
		return true;
	}

	/* Overridden toString(): 
	 * returns some info about the object parameters in a string; 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [luggageWeight=" + luggageWeight + ", registerFirst=" + registerFirst + "]";
	}

	
	

	

}
