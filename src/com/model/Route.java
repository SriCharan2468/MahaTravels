package com.model;

//Represents a travel route with details like source, destination, travel date, fare, and available seats.
import java.time.LocalDate;

public class Route {
	private int routeId;
	private String source;
	private String destination;
	private LocalDate journeyDate;
	private double ticketPricePerPassenger;
	private int noOfSeatsAvailable;
	private String type;

	public Route(int routeId, String source, String destination, LocalDate journeyDate, double ticketPricePerPassenger,
			int noOfSeatsAvailable, String type) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.ticketPricePerPassenger = ticketPricePerPassenger;
		this.noOfSeatsAvailable = noOfSeatsAvailable;
		this.type = type;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public double getTicketPricePerPassenger() {
		return ticketPricePerPassenger;
	}

	public void setTicketPricePerPassenger(double ticketPricePerPassenger) {
		this.ticketPricePerPassenger = ticketPricePerPassenger;
	}

	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}

	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String result = "Route Details::\n  \t\tRoute Id: " + routeId + "\n  \t\tSource: " + source
				+ "\n  \t\tDestination: " + destination + "\n  \t\tJourney Date: " + journeyDate
				+ "\n  \t\tTicket Price Per Passenger: " + ticketPricePerPassenger + "\n  \t\tNo. of Seats Available: "
				+ noOfSeatsAvailable + "\n  \t\tBus Type: " + type;
		return result;
	}

}
