package airlineinfo;

import java.time.LocalDate;

/** Abstract class that contains some necessary properties/methods 
 * for establishing price coefficients for some order and such.
 * Provide abstract method for calculating the price of an order. 
 * @author Anastasia
 */
abstract class OrderRelated {
	
	protected double basicPrice;
	protected Flight flight;
	
	protected int minimumSeats;
	protected LocalDate maximumDate;

	protected double luggagePrice;
	protected float registerFirstPrice;
	protected float seatsFactorPrice;
	protected float dateFactorPrice;
	
	
	//getters and setters
	
	public double getBasicPrice() {
		return basicPrice;
	}
	
	
	public void setBasicPrice(double flightBasicPrice) {
		if (flightBasicPrice>=0.0d)
			basicPrice=flightBasicPrice;
		else
			System.out.println("Incorrect value");
	}
	
	
	public double getLuggagePrice() {
		return luggagePrice;
	}

	public void setLuggagePrice(double luggagePrice) {
		if (luggagePrice>=0.0d)
			this.luggagePrice = luggagePrice;
		else
			System.out.println("Incorrect value");
	}

	public float getRegisterFirstPrice() {
		return registerFirstPrice;
	}

	public void setRegisterFirstPrice(float registerFirstPrice) {
		if (registerFirstPrice>=0.0f)
			this.registerFirstPrice = registerFirstPrice;
		else
			System.out.println("Incorrect value");
	}

	
	public int getMinimumSeats() {
		return minimumSeats;
	}

	public void setMinimumSeats(int minimumSeats) {
		if (minimumSeats>=0.0f)
			this.minimumSeats = minimumSeats;
		else
			System.out.println("Incorrect value");
	}

	public LocalDate getMaximumDate() {
		return maximumDate;
	}

	public void setMaximumDate(LocalDate maximumDate) {
		this.maximumDate = maximumDate;
	}

	public float getSeatsFactorPrice() {
		return seatsFactorPrice;
	}

	public void setSeatsFactorPrice(float seatsFactorPrice) {
		if (seatsFactorPrice>=0.0f)
			this.seatsFactorPrice = seatsFactorPrice;
		else
			System.out.println("Incorrect value");
	}

	public float getDateFactorPrice() {
		return dateFactorPrice;
	}

	public void setDateFactorPrice(float dateFactorPrice) {
		if (dateFactorPrice>=0.0f)
			this.dateFactorPrice = dateFactorPrice;
		else
			System.out.println("Incorrect value");
	}
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		if (flight!=null)
			this.flight = flight;
		else
			System.out.println("Please set a valid flight");
	}
	

	//for calculating the price, taking luggage and stuff into account
	public abstract double calculatePrice(int seatsLeft, int luggageWeight, boolean registerFirst);


}
