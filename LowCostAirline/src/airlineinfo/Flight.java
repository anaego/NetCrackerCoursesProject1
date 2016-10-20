package airlineinfo;

import java.time.LocalDate;

/** Class Flight represents a flight that the client can choose.
 * properties: date - flight date, seatsLeft - how many 
 * seats are left; plane - the name of the plane model. 
 * @author Anastasia
 */
public class Flight {
	
	private LocalDate date;
	private String plane;
	private int seatsLeft;
	
	/** static variable for object counting
	 */
	public static int counter;
	
	
	/* Flight constructor: 
	 * for initializing some flight info 
	 * and also for counting objects of type Flight
	 */
	public Flight(LocalDate flightDate, int flightSeatsLeft, String plane) {
		setDate(flightDate);
		setSeatsLeft(flightSeatsLeft);
		setPlane(plane);
		
		counter++;
	}
	
	//getters and setters
	
	public String getPlane() {
		if (plane!=null)
			return plane;
		else
			return "unknown plane";
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate flightDate) {
		if (flightDate.isAfter(LocalDate.now()))
			date=flightDate;
		else
			System.out.println("You can't set an old flight date!");
	}
	
	public int getSeatsLeft() {
		return seatsLeft;
	}
	
	public void setSeatsLeft(int flightSeatsLeft) {
		if (flightSeatsLeft>=0) 
			seatsLeft=flightSeatsLeft;
		else
			System.out.println("Incorrect value");
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((plane == null) ? 0 : plane.hashCode());
		result = prime * result + seatsLeft;
		return result;
	}

	/* Overridden equals(): 
	 * compares the properties of the objects; 
	 * and some other stuff.
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
		Flight other = (Flight) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (plane == null) {
			if (other.plane != null)
				return false;
		} else if (!plane.equals(other.plane))
			return false;
		if (seatsLeft != other.seatsLeft)
			return false;
		return true;
	}

	/* Overridden toString():
	 * returns some info about the object parameters in a string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flight [date=" + date + ", plane=" + plane + ", seatsLeft=" + seatsLeft + "]";
	}
	
	


	
	
	
}