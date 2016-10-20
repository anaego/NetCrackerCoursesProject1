package airlineinfo;

import java.time.LocalDate;

/** Interface FlightRelated - describes some things 
 * related to a specific flight: getter/setter methods
 * for the properties that are needed when describing a flight
 * @author Anastasia
 */
public interface IFlightRelated {
	
	public String getPlane();

	public void setPlane(String plane);

	public LocalDate getDate();
	
	public void setDate(LocalDate flightDate);

}
