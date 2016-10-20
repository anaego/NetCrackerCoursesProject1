package main;

import java.time.LocalDate;

import airlineinfo.Flight;
import airlineinfo.Order;
import airlineinfo.Ticket;
import clientinfo.Client;
import clientinfo.Human;

/** Main class of a project, for demonstrating its work 
 * @author Anastasia
 */
public class MainProgram {

	public static void main(String[] args) {
		
		//We create objects necessary for the successful work: 
		//a client, their order, the flight they want to get to, and a ticket
		Client client = new Client("Petr Petrov");
		
		client.setLuggageWeight(10);
		client.setRegisterFirst(false);
		
		System.out.println("The client is " + client.getName() + " with " 
				+ client.getLuggageWeight() 
				+ " kgs of luggage and do they have first priority boarding? " 
				+ client.getRegisterFirst());
		
		Flight flight = new Flight(LocalDate.of(2016, 10, 31), 15, "Boing blabla");
		
		System.out.println("The flight is on " + flight.getDate() + ", the plane is " 
				+ flight.getPlane() + ", there are " + flight.getSeatsLeft() 
				+ " seat left");
		
		Order order = new Order(10, flight, 5, LocalDate.of(2016, 10, 25), 2, 5, 3, 3);
		
		
		Ticket ticket = new Ticket();
		ticket = client.orderTicket(order, flight);
		
		client.payForTicket(ticket);
		
		//Object counter through static
		System.out.println("");
		Integer objCount = Flight.counter + Order.counter + Ticket.counter + Client.counter 
				+ Human.counter;
		System.out.println("The number of objects is: " + objCount.toString());


	}

}
























