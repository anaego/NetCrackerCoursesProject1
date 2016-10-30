package airlineinfo;

import java.io.Serializable;
import java.util.GregorianCalendar;

import etc.IncorrectValueException;

/** Class Ticket - represents tickets for some flight. 
 * properties: price is for the final price for the ticket, with all the factors taken into account; 
 * paidFor - whether the client has paid for this ticket. 
 * Date and plane describe the date of the flight and the plane model. 
 * @author Anastasia
 */
public class Ticket implements IFlightRelated, Serializable {
	
	private Double price;
	private GregorianCalendar date;
	private String plane;
	private boolean paidFor;
	private String destination;
	
	/** static variable for object counting
	 */
	public static int counter;
	
	/* Ticket constructor: 
	 * for counting objects of type Ticket
	 */
	public Ticket()
	{
		counter++;
	}

	//getters and setters
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double ticketPrice) {
		try {
			price = ticketPrice;
			if (price <= 0.0d)
					throw new IncorrectValueException("Incorrect price value." 
							+ " Please change it.");
		} catch(IncorrectValueException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		try {
			this.date=date;
			if (this.date.before( new GregorianCalendar() ))
					throw new IncorrectValueException("You can't set an old flight date!" 
							+ " Please change the flight date.");
		} catch(IncorrectValueException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getPlane() {
		if (plane!=null)
			return plane;
		else
			return "unknown plane";
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public boolean isPaidFor() {
		return paidFor;
	}

	public void setPaidFor(boolean paidFor) {
		this.paidFor = paidFor;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	//Overridden methods (automatically generated)

	/* Overridden hashCode():
	 * will always return the same result; 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (paidFor ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* Overridden equals(): 
	 * compare the properties of the objects 
	 * and some other stuff; 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (paidFor != other.paidFor)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	/* Overridden toString(): 
	 * returns some info about the object parameters in a string; 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [price=" + price + ", paidFor=" + paidFor + "]";
	}

	
	

	
	

	
	
}
