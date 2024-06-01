package com;

import com.service.UserService;
import com.service.JourneyService;
import com.model.User;
import com.model.Route;
import com.model.Order;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static List<Route> routes = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static Map<String, Integer> userInvalidLoginAttempt = new HashMap<>();
    private static UserService userService = new UserService(users, userInvalidLoginAttempt);
    private static JourneyService journeyService = new JourneyService(routes, orders);

    public static void main(String[] args) {
    	initializeRoutes();

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
            return true; // Logo loaded successfully
        } catch(IOException e) {
            System.err.println("Error reading company logo file: " + e.getMessage());
            return false; // Logo loading failed
        }
    }
    private static void initializeRoutes() {
        routes.add(new Route(101, "Nellore", "Hyderabad", LocalDate.now(), 1000, 40, "seater"));
        routes.add(new Route(102, "Nellore", "Hyderabad", LocalDate.now(), 1500, 40, "sleeper"));
        routes.add(new Route(103, "Nellore", "Hyderabad", LocalDate.now().plusDays(1), 1000, 40, "seater"));
        routes.add(new Route(104, "Nellore", "Hyderabad", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
        routes.add(new Route(105, "Nellore", "Chennai", LocalDate.now(), 500, 40, "seater"));
        routes.add(new Route(106, "Nellore", "Chennai", LocalDate.now(), 1000, 40, "sleeper"));
        routes.add(new Route(107, "Nellore", "Chennai", LocalDate.now().plusDays(1), 500, 40, "seater"));
        routes.add(new Route(108, "Nellore", "Chennai", LocalDate.now().plusDays(1), 1000, 40, "sleeper"));
        routes.add(new Route(109, "Nellore", "Bangalore", LocalDate.now(), 1000, 40, "seater"));
        routes.add(new Route(110, "Nellore", "Bangalore", LocalDate.now(), 1500, 40, "sleeper"));
        routes.add(new Route(111, "Nellore", "Bangalore", LocalDate.now().plusDays(1), 1000, 40, "seater"));
        routes.add(new Route(112, "Nellore", "Bangalore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
        routes.add(new Route(113, "Hyderabad", "Nellore", LocalDate.now(), 1000, 40, "seater"));
        routes.add(new Route(114, "Hyderabad", "Nellore", LocalDate.now(), 1500, 40, "sleeper"));
        routes.add(new Route(115, "Hyderabad", "Nellore", LocalDate.now().plusDays(1), 1000, 40, "seater"));
        routes.add(new Route(116, "Hyderabad", "Nellore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
        routes.add(new Route(117, "Hyderabad", "Chennai", LocalDate.now(), 1500, 40, "seater"));
        routes.add(new Route(118, "Hyderabad", "Chennai", LocalDate.now(), 2000, 40, "sleeper"));
        routes.add(new Route(119, "Hyderabad", "Chennai", LocalDate.now().plusDays(1), 1500, 40, "seater"));
        routes.add(new Route(120, "Hyderabad", "Chennai", LocalDate.now().plusDays(1), 2000, 40, "sleeper"));
        routes.add(new Route(121, "Hyderabad", "Bangalore", LocalDate.now(), 1200, 40, "seater"));
        routes.add(new Route(122, "Hyderabad", "Bangalore", LocalDate.now(), 1500, 40, "sleeper"));
        routes.add(new Route(123, "Hyderabad", "Bangalore", LocalDate.now().plusDays(1), 1200, 40, "seater"));
        routes.add(new Route(124, "Hyderabad", "Bangalore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
        routes.add(new Route(125, "Chennai", "Nellore", LocalDate.now(), 500, 40, "seater"));
        routes.add(new Route(126, "Chennai", "Nellore", LocalDate.now(), 700, 40, "sleeper"));
        routes.add(new Route(127, "Chennai", "Nellore", LocalDate.now().plusDays(1), 500, 40, "seater"));
        routes.add(new Route(128, "Chennai", "Nellore", LocalDate.now().plusDays(1), 700, 40, "sleeper"));
        routes.add(new Route(129, "Chennai", "Hyderabad", LocalDate.now(), 1500, 40, "seater"));
        routes.add(new Route(130, "Chennai", "Hyderabad", LocalDate.now(), 2000, 40, "sleeper"));
        routes.add(new Route(131, "Chennai", "Hyderabad", LocalDate.now().plusDays(1), 1500, 40, "seater"));
        routes.add(new Route(132, "Chennai", "Hyderabad", LocalDate.now().plusDays(1), 2000, 40, "sleeper"));
        routes.add(new Route(133, "Chennai", "Bangalore", LocalDate.now(), 1000, 40, "seater"));
        routes.add(new Route(134, "Chennai", "Bangalore", LocalDate.now(), 1500, 40, "sleeper"));
        routes.add(new Route(135, "Chennai", "Bangalore", LocalDate.now().plusDays(1), 1000, 40, "seater"));
        routes.add(new Route(136, "Chennai", "Bangalore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
        routes.add(new Route(137, "Bangalore", "Nellore", LocalDate.now(), 1000, 40, "seater"));
        routes.add(new Route(138, "Bangalore", "Nellore", LocalDate.now(), 1500, 40, "sleeper"));
        routes.add(new Route(139, "Bangalore", "Nellore", LocalDate.now().plusDays(1), 1000, 40, "seater"));
        routes.add(new Route(140, "Bangalore", "Nellore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
        routes.add(new Route(141, "Bangalore", "Chennai", LocalDate.now(), 1000, 40, "seater"));
        routes.add(new Route(142, "Bangalore", "Chennai", LocalDate.now(), 1500, 40, "sleeper"));
        routes.add(new Route(143, "Bangalore", "Chennai", LocalDate.now().plusDays(1), 1000, 40, "seater"));
        routes.add(new Route(144, "Bangalore", "Chennai", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
        routes.add(new Route(145, "Bangalore", "Hyderabad", LocalDate.now(), 1000, 40, "seater"));
        routes.add(new Route(146, "Bangalore", "Hyderabad", LocalDate.now(), 1500, 40, "sleeper"));
        routes.add(new Route(147, "Bangalore", "Hyderabad", LocalDate.now().plusDays(1), 1000, 40, "seater"));
        routes.add(new Route(148, "Bangalore", "Hyderabad", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));

    }


    private static void showMenuOptions() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean running = true;

        while (running) {
            System.out.println("\nMenu Options:");
            System.out.println("1. New Admin User Registration");
            System.out.println("2. Login");
            System.out.println("3. Plan journey");
            System.out.println("4. Reschedule booking date");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
            case 1:
                userService.registerNewAdmin();
                break;
            case 2:
                userService.login();
                break;
            case 3:
                journeyService.planJourney();
                break;
            case 4:
                journeyService.reScheduleJourney();
                break;
            case 5:
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
