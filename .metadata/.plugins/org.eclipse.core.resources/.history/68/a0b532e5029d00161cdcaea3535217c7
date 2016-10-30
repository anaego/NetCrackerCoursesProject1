package clientinfo;

import java.io.Serializable;

import airlineinfo.Flight;
import airlineinfo.Ticket;
import main.IncorrectValueException;

/** Client class - represents a client of the airline.
 * Contains info about their luggage and whether the order the first priority boarding right.
 * @author Anastasia
 */
public class Client extends Human implements Comparable<Client>, Serializable {
	
	private int luggageWeight;
	private boolean registerFirst;
	private transient Ticket ticket;
	
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
		try {
			luggageWeight=clientLuggageWeight;
			if (luggageWeight <= 0)
					throw new IncorrectValueException("Incorrect luggageWeight value." 
							+ " Please change it.");
		} catch(IncorrectValueException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean getRegisterFirst() {
		return registerFirst;
	}
	
	public void setRegisterFirst(boolean clientRegisterFirst) {
		registerFirst=clientRegisterFirst;
	}
	
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	

	/** Method for ordering the ticket - creating the ticket object 
	 * with a set price; 
	 * @param flightInfo - Flight type object with information about the flight; 
	 * @param orderInfo - Order type object with info about the price coefficients and such
	 * @return
	 */
	public Ticket orderTicket(Flight flightInfo) {
		
		Ticket ticket = new Ticket();
				
		if (flightInfo.getSeatsLeft()!=0) {
			
			ticket.setDate(flightInfo.getDate());
			ticket.setPlane(flightInfo.getPlane());
			ticket.setDestination(flightInfo.getDestination());
						
			ticket.setPrice( flightInfo.getOrder().calculatePrice(flightInfo.getSeatsLeft(), getLuggageWeight(), getRegisterFirst()) );
			
			System.out.println("The ticket is ordered");
			System.out.println("The price is " + ticket.getPrice());	
			
			this.setTicket(ticket);
		} else {
			System.out.println("There are no seats left on this flight");
		}		
		
		return ticket;
	}
	
	/**Method for paying for the ticket; 
	 * !currently i have no idea how it should be done (bank transaction???); 
	 * @param ticket - information about the ticket the client is paying for
	 */
	public void payForTicket() {
		
		//bank transaction???
		if (this.getTicket()!=null)
		{
			if (getTicket().isPaidFor() == false) {
				ticket.setPaidFor(true);
				System.out.println("The ticket is paid for");
			} else {
				System.out.println("You already paid for the ticket! Have a safe flight");
			}
			
		} else {
			System.out.println("You have to order a ticket first");
		}
			
			
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

	@Override
	public int compareTo(Client compareClient) {
		
		return this.getName().compareToIgnoreCase(compareClient.getName());

	}

	
	

	

}
