package airlineinfo;

import java.time.LocalDate;

/** Class Ticket - represents tickets for some flight. 
 * properties: price is for the final price for the ticket, with all the factors taken into account; 
 * paidFor - whether the client has paid for this ticket. 
 * Date and plane describe the date of the flight and the plane model. 
 * @author Anastasia
 */
public class Ticket implements IFlightRelated {
	
	private double price;
	private LocalDate date;
	private String plane;
	private boolean paidFor;
	
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
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double ticketPrice) {	
		if (ticketPrice>=0.0d) 
			price=ticketPrice;
		else
			System.out.println("Incorrect value");
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		if (date.isAfter(LocalDate.now())) 
			this.date = date;
		else
			System.out.println("Incorrect date value");
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		if (plane!=null) 
			this.plane = plane;
		else
			System.out.println("Incorrect plane value");
	}

	public boolean isPaidFor() {
		return paidFor;
	}

	public void setPaidFor(boolean paidFor) {
		this.paidFor = paidFor;
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
