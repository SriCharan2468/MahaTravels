package com;

import com.service.UserService;
import com.service.InitializeRoutes;
import com.service.JourneyService;
import com.model.User;
import com.model.Route;
import com.model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static List<User> users = new ArrayList<>();
	private static List<Route> routes = InitializeRoutes.initializeRoutes();
	private static List<Order> orders = new ArrayList<>();
	private static Map<String, Integer> userInvalidLoginAttempt = new HashMap<>();
	private static UserService userService = new UserService(users, userInvalidLoginAttempt);
	private static JourneyService journeyService = new JourneyService(routes, orders);

	public static void main(String[] args) {

		if (displayCompanyLogo()) {
			showMenuOptions();

		} else {
			System.out.println("Failed to load company logo. Exiting...");
		}
	}

	private static boolean displayCompanyLogo() {
		try (BufferedReader reader = new BufferedReader(new FileReader("./Logo.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			return true;
		} catch (IOException e) {
			System.err.println("Error reading company logo file: " + e.getMessage());
			return false;
		}
	}

	private static void showMenuOptions() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean running = true;
		boolean isUserRegistered = false;
		User loggedInUser = null;

		while (running) {
			System.out.println("\nMenu Options:");
			if (!isUserRegistered) {
				System.out.println("1. New Admin User Registration");
				System.out.println("2. Exit");
			} else {
				if (loggedInUser == null) {
					System.out.println("1. Login");
					System.out.println("2. Register another Admin User");
					System.out.println("3. Exit");
				} else {
					System.out.println("1. Book tickets");
					System.out.println("2. Change booking date");
					System.out.println("3. Display User Details");
					System.out.println("4. Update User Details");
					System.out.println("5. Display Planned Journeys");
					System.out.println("6. Logout");
					System.out.println("7. Exit");
				}
			}

			System.out.print("Enter your choice: ");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				if (!isUserRegistered) {
					userService.registerNewAdmin();
					isUserRegistered = true;
				} else if (loggedInUser == null) {
					loggedInUser = userService.login();
				} else {
					journeyService.planJourney();
				}
				break;
			case 2:
				if (!isUserRegistered) {
					System.out.println("Exiting...");
					running = false;
				} else if (loggedInUser == null) {
					userService.registerNewAdmin();
				} else {
					journeyService.reScheduleJourney(scanner);
				}
				break;
			case 3:
				if (loggedInUser == null) {
					System.out.println("Exiting...");
					running = false;
				} else if (loggedInUser != null) {
					userService.displayUserDetails(loggedInUser);
				}
				break;
			case 4:
				if (loggedInUser != null) {
					userService.updateUserDetails(loggedInUser);
				} else {
					System.out.println("Please login first to update user details.");
				}
				break;
			case 5:
				if (loggedInUser != null) {
					journeyService.displayPlannedJourneys();
				} else {
					System.out.println("Please login first to display planned journeys.");
				}
				break;
			case 6:
				if (loggedInUser != null) {
					loggedInUser = null;
					System.out.println("Logged out successfully.");
				} else {
					System.out.println("You are not logged in.");
				}
				break;
			case 7:
				System.out.println("Exiting...");
				running = false;
				break;
			default:
				System.out.println("Invalid choice. Please enter a correct option.");
				break;
			}
		}

		scanner.close();
	}

}
