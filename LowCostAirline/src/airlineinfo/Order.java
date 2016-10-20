package airlineinfo;

import java.time.LocalDate;

/** Order Flight serves for describing some things related to the 
 * client's order, and for calculating the final price
 * @author Anastasia
 */
public class Order extends OrderRelated {
	
	/** static variable for object counting
	 */
	public static int counter;
	
	/* Order constructor: 
	 * for initializing some info 
	 * and also for counting objects of type Order
	 */
	public Order(double basicPrice, Flight flight, int minimumSeats, LocalDate maximumDate, double luggagePrice,
			float registerFirstPrice, float seatsFactorPrice, float dateFactorPrice) {
		this.basicPrice = basicPrice;
		this.flight = flight;
		this.minimumSeats = minimumSeats;
		this.maximumDate = maximumDate;
		this.luggagePrice = luggagePrice;
		this.registerFirstPrice = registerFirstPrice;
		this.seatsFactorPrice = seatsFactorPrice;
		this.dateFactorPrice = dateFactorPrice;
		
		counter++;
	}
	
	
	//for 
	/** Method for calculating the price, taking luggage etc into account
	 * @param seatsLeft 
	 * @param luggageWeight; 
	 * @param registerFirst; 
	 */
	public double calculatePrice(int seatsLeft, int luggageWeight, boolean registerFirst) {
			
		double price = getBasicPrice();
		
		price = price + luggageWeight * getLuggagePrice();
			
		if (registerFirst == true) {
			price = price + getBasicPrice() * getRegisterFirstPrice();
		}
			
		if (seatsLeft < getMinimumSeats()) {
			price = price + getBasicPrice() * getSeatsFactorPrice();
		}
						
		if ( getMaximumDate().isBefore( LocalDate.now() ) ) {			
			price = price + getBasicPrice() * getDateFactorPrice();
		}
		
		return price;
	}


		//Overridden methods (automatically generated)
		
		/* Overridden hashCode(); 
		 * will always return the same result; 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(basicPrice);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + Float.floatToIntBits(dateFactorPrice);
			temp = Double.doubleToLongBits(luggagePrice);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((maximumDate == null) ? 0 : maximumDate.hashCode());
			result = prime * result + minimumSeats;
			result = prime * result + Float.floatToIntBits(registerFirstPrice);
			result = prime * result + Float.floatToIntBits(seatsFactorPrice);
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
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Order other = (Order) obj;
			if (Double.doubleToLongBits(basicPrice) != Double.doubleToLongBits(other.basicPrice))
				return false;
			if (Float.floatToIntBits(dateFactorPrice) != Float.floatToIntBits(other.dateFactorPrice))
				return false;
			if (Double.doubleToLongBits(luggagePrice) != Double.doubleToLongBits(other.luggagePrice))
				return false;
			if (maximumDate == null) {
				if (other.maximumDate != null)
					return false;
			} else if (!maximumDate.equals(other.maximumDate))
				return false;
			if (minimumSeats != other.minimumSeats)
				return false;
			if (Float.floatToIntBits(registerFirstPrice) != Float.floatToIntBits(other.registerFirstPrice))
				return false;
			if (Float.floatToIntBits(seatsFactorPrice) != Float.floatToIntBits(other.seatsFactorPrice))
				return false;
			return true;
		}

		/* Overridden toString(): 
		 * returns some info about the object parameters in a string; 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Order [basicPrice=" + basicPrice + ", minimumSeats=" + minimumSeats + ", maximumDate=" + maximumDate
					+ ", luggagePrice=" + luggagePrice + ", registerFirstPrice=" + registerFirstPrice
					+ ", seatsFactorPrice=" + seatsFactorPrice + ", dateFactorPrice=" + dateFactorPrice + "]";
		}
		

}