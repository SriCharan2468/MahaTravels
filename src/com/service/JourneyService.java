package com.service;

//Manages journey-related operations like planning a journey, generating bills, and rescheduling journeys. It leverages the Route and Order classes to facilitate these operations.
import com.model.Journey;
import com.model.Order;
import com.model.Route;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.DayOfWeek;

public class JourneyService {
	private List<Route> routes;
	private List<Order> orders;

	public JourneyService(List<Route> routes, List<Order> orders) {
		this.routes = routes;
		this.orders = orders;
	}

	public void planJourney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----- Plan Journey -----");
		System.out.println();

		System.out.println("Sources Available :: Nellore, Hyderabad, Chennai, Bangalore");
		System.out.println("Destinations Available :: Nellore, Hyderabad, Chennai, Bangalore");
		System.out.println();

		// Getting journey details from the user
		System.out.print("Enter source: ");
		String source = scanner.nextLine();

		System.out.print("Enter destination: ");
		String destination = scanner.nextLine();

		System.out.print("Enter journey date (YYYY-MM-DD): ");
		String journeyDateString = scanner.nextLine();
		LocalDate journeyDate = LocalDate.parse(journeyDateString, DateTimeFormatter.ISO_LOCAL_DATE);

		System.out.print("Enter number of passengers: ");
		int noOfPassengers = scanner.nextInt();
		scanner.nextLine(); // Consume the leftover newline

		System.out.println("Please Wait, Searching for routes...");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Finding matching routes
		List<Route> matchingRoutes = getRoutes(source, destination, journeyDate, noOfPassengers);
		if (!matchingRoutes.isEmpty()) {
			System.out.println("Available Routes: ");
			for (int i = 0; i < matchingRoutes.size(); i++) {
				System.out.println((i + 1) + ": " + matchingRoutes.get(i));
			}
			System.out.print("Select a route (number): ");
			int routeNumber = scanner.nextInt();
			Route selectedRoute = matchingRoutes.get(routeNumber - 1);

			// Creating an order
			Order newOrder = createOrder(journeyDate, noOfPassengers, selectedRoute);
			orders.add(newOrder);
			selectedRoute.setNoOfSeatsAvailable(selectedRoute.getNoOfSeatsAvailable() - noOfPassengers);
			System.out.println("Journey planned successfully..!");
			System.out.println(
					"Payment of Rs." + newOrder.getOrderAmount() + "/- Should be made while boarding the Bus..!");
			System.out.println("Order Details :: ");
			System.out.println(newOrder);
		} else {
			System.out.println("No available routes found for the given details.");
		}
	}

	public void reScheduleJourney(Scanner scanner) {
		System.out.println("\n----- Re-Schedule Journey -----");

		try {
			System.out.print("Enter your Order ID: ");
			int orderId = Integer.parseInt(scanner.nextLine());

			Order orderToReschedule = findOrderById(orderId);
			if (orderToReschedule != null) {
				System.out.print("Enter new journey date (YYYY-MM-DD): ");
				String newDateStr = scanner.nextLine();
				LocalDate newDate = LocalDate.parse(newDateStr, DateTimeFormatter.ISO_LOCAL_DATE);

				List<Route> availableRoutes = getRoutes(orderToReschedule.getRoute().getSource(),
						orderToReschedule.getRoute().getDestination(), newDate,
						orderToReschedule.getRequestedJourneyPlan().getNumberOfPassengers());

				if (!availableRoutes.isEmpty()) {
					Route oldRoute = orderToReschedule.getRoute();
					oldRoute.setNoOfSeatsAvailable(oldRoute.getNoOfSeatsAvailable()
							+ orderToReschedule.getRequestedJourneyPlan().getNumberOfPassengers());

					Route newRoute = availableRoutes.get(0);
					newRoute.setNoOfSeatsAvailable(newRoute.getNoOfSeatsAvailable()
							- orderToReschedule.getRequestedJourneyPlan().getNumberOfPassengers());
					orderToReschedule.getRequestedJourneyPlan().setJourneyDate(newDate);
					orderToReschedule.setRoute(newRoute);
					System.out.println("Journey rescheduled successfully..!");
					System.out.println("Updated Order Details :: ");
					System.out.println(orderToReschedule);
				} else {
					System.out.println("No available routes for the new journey date.");
				}
			} else {
				System.out.println("Order not found.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid order ID.");
		} catch (Exception e) {
			System.out.println("An error occurred while rescheduling the journey: " + e.getMessage());
		}
	}

	public void displayPlannedJourneys() {
		System.out.println("\n----- Planned Journeys -----");
		if (orders.isEmpty()) {
			System.out.println("No journeys have been planned yet.");
		} else {
			for (Order order : orders) {
				System.out.println(order);
			}
		}
	}

	private List<Route> getRoutes(String source, String destination, LocalDate date, int numberOfPassengers) {
		List<Route> matchingRoutes = new ArrayList<>();
		for (Route route : this.routes) {
			if (route.getSource().equalsIgnoreCase(source) && route.getDestination().equalsIgnoreCase(destination)
					&& route.getJourneyDate().isEqual(date) && route.getNoOfSeatsAvailable() >= numberOfPassengers) {
				matchingRoutes.add(route);
			}
		}
		return matchingRoutes;
	}

	private Order createOrder(LocalDate date, int passengers, Route selectedRoute) {
		Order newOrder = new Order();
		double bookingCost = selectedRoute.getTicketPricePerPassenger() * passengers;

		newOrder.setOrderAmount(bookingCost);
		newOrder.setRoute(selectedRoute);
		newOrder.setRequestedJourneyPlan(new Journey(date, passengers));
		newOrder.setOrderStatus("created");
		newOrder.setOrderId(orders.size() + 1);

		return newOrder;
	}

	private Order findOrderById(int orderId) {
		for (Order order : orders) {
			if (order.getOrderId() == orderId) {
				return order;
			}
		}
		return null;
	}
}
