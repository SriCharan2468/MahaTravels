package com.service;

//Manages user-related operations including new admin registration and user login. It also handles the tracking of invalid login attempts and locks the account after 5 failed attempts.
import com.model.User;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserService {
	private List<User> users;
	private Map<String, Integer> userInvalidLoginAttempt;

	public UserService(List<User> users, Map<String, Integer> userInvalidLoginAttempt) {
		this.users = users;
		this.userInvalidLoginAttempt = userInvalidLoginAttempt;
	}

	public void registerNewAdmin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----- New Admin User Registration -----");

		String name;
		do {
			System.out.print("Enter Name: ");
			name = scanner.nextLine();
			if (!isNotEmpty(name)) {
				System.out.println("Name cannot be empty.");
			}
		} while (!isNotEmpty(name));

		String mobileNumber;
		do {
			System.out.print("Enter Mobile number: ");
			mobileNumber = scanner.nextLine();
			if (!isValidMobileNumber(mobileNumber)) {
				System.out.println("Invalid mobile number. It must be exactly 10 digits long.");
			}
		} while (!isValidMobileNumber(mobileNumber));

		String email;
		do {
			System.out.print("Enter E-mail: ");
			email = scanner.nextLine();
			if (!isValidEmail(email)) {
				System.out.println("Invalid email format.");
			} else if (isUserExists(email)) {
				System.out.println("User with this email: " + email + " already exists");
				email = null; // Set to null to continue loop
			}
		} while (!isValidEmail(email) || email == null);

		String password;
		do {
			System.out.print("Enter Password: ");
			password = scanner.nextLine();
			if (!isValidPassword(password)) {
				System.out.println(
						"Password must be at least 8 characters long and contain at least one digit, one uppercase letter, and one special character.");
			}
		} while (!isValidPassword(password));

		User newUser = new User(name, mobileNumber, email, password, 0, "Active");
		users.add(newUser);
		System.out.println("***** Registration successful! *****");
	}

	public void registerNewAdmin1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----- New Admin User Registration -----");

		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		if (!isNotEmpty(name)) {
			System.out.println("Name cannot be empty.");
			return;
		}

		System.out.print("Enter Mobile number: ");
		String mobileNumber = scanner.nextLine();
		if (!isValidMobileNumber(mobileNumber)) {
			System.out.println("Invalid mobile number. It must be exactly 10 digits long.");
			return;
		}

		System.out.print("Enter E-mail: ");
		String email = scanner.nextLine();
		if (!isValidEmail(email)) {
			System.out.println("Invalid email format.");
			return;
		}

		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		if (!isValidPassword(password)) {
			System.out.println(
					"Password must be at least 8 characters long and contain at least one digit, one uppercase letter, and one special character.");
			return;
		}

		if (isUserExists(email)) {
			System.out.println("User with this email: " + email + " already exists");
			return;
		}

		User newUser = new User(name, mobileNumber, email, password, 0, "Active");
		users.add(newUser);
		System.out.println("***** Registration successful! *****");
	}

	private boolean isUserExists(String email) {
		for (User user : users) {
			if (user.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	public User login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----- User Login -----");

		System.out.print("Enter E-mail: ");
		String email = scanner.nextLine();

		System.out.print("Enter Password: ");
		String password = scanner.nextLine();

		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				Integer existingCount = userInvalidLoginAttempt.getOrDefault(email, 0);
				if (existingCount >= 5) {
					System.out.println("User account is locked due to multiple invalid login attempts.");
					return null;
				}
				if (user.getPassword().equals(password)) {
					System.out.println("\n***** Login Successful *****");
					System.out.println("Welcome " + user.getName());
					userInvalidLoginAttempt.put(email, 0); // Reset count after successful login
					return user;
				} else {
					userInvalidLoginAttempt.put(email, existingCount + 1);
					System.out.println(
							"\n Invalid Credentials. Attempt: " + (existingCount + 1) + " for email: " + email);
					return null; // Exit the method if password is incorrect
				}
			}
		}
		System.out.println("No user found with email: " + email);
		return null;
	}

	public void displayUserDetails(User user) {
		if (user != null) {
			System.out.println("\n----- User Details -----");
			System.out.println("Name: " + user.getName());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Mobile Number: " + user.getMobileNumber());
		} else {
			System.out.println("No user found.");
		}
	}

	public void updateUserDetails(User loggedInUser) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----- Update User Details -----");

		System.out.println("Logged-in User: " + loggedInUser.getName());

		String newName;
		do {
			System.out.print("Enter New Name: ");
			newName = scanner.nextLine();
			if (!isNotEmpty(newName)) {
				System.out.println("Name cannot be empty.");
			}
		} while (!isNotEmpty(newName));
		loggedInUser.setName(newName);

		String newMobileNumber;
		do {
			System.out.print("Enter New Mobile Number: ");
			newMobileNumber = scanner.nextLine();
			if (!isValidMobileNumber(newMobileNumber)) {
				System.out.println("Invalid mobile number. It must be exactly 10 digits long.");
			}
		} while (!isValidMobileNumber(newMobileNumber));
		loggedInUser.setMobileNumber(newMobileNumber);

		String newPassword;
		do {
			System.out.print("Enter New Password: ");
			newPassword = scanner.nextLine();
			if (!isValidPassword(newPassword)) {
				System.out.println(
						"Password must be at least 8 characters long and contain at least one digit, one uppercase letter, and one special character.");
			}
		} while (!isValidPassword(newPassword));
		loggedInUser.setPassword(newPassword);

		System.out.println("User details updated successfully!");
	}

	public void updateUserDetails1(User loggedInUser) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----- Update User Details -----");

		System.out.println("Logged-in User: " + loggedInUser.getName());

		System.out.print("Enter New Name: ");
		String newName = scanner.nextLine();
		if (!isNotEmpty(newName)) {
			System.out.println("Name cannot be empty.");
			return;
		}
		loggedInUser.setName(newName);

		System.out.print("Enter New Mobile Number: ");
		String newMobileNumber = scanner.nextLine();
		if (!isValidMobileNumber(newMobileNumber)) {
			System.out.println("Invalid mobile number. It must be exactly 10 digits long.");
			return;
		}
		loggedInUser.setMobileNumber(newMobileNumber);

		System.out.print("Enter New Password: ");
		String newPassword = scanner.nextLine();
		if (!isValidPassword(newPassword)) {
			System.out.println(
					"Password must be at least 8 characters long and contain at least one digit, one uppercase letter, and one special character.");
			return;
		}
		loggedInUser.setPassword(newPassword);

		System.out.println("User details updated successfully!");
	}

	private boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		return email.matches(emailRegex);
	}

	private boolean isValidPassword(String password) {
		String passwordRegex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
		return password.matches(passwordRegex);
	}

	private boolean isValidMobileNumber(String mobileNumber) {
		String mobileNumberRegex = "^\\d{10}$";
		return mobileNumber.matches(mobileNumberRegex);
	}

	private boolean isNotEmpty(String field) {
		return field != null && !field.trim().isEmpty();
	}

}
