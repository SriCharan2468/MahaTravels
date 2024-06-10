package com.model;

//Represents an admin user with properties like name, email, password, mobile number, gender, failed login count, and account status.
public class User {
	private String name;
	private String mobileNumber;
	private String email;
	private String password;
	private int failedCount;
	private String accountStatus;

	public User(String name, String mobileNumber, String email, String password, int failedCount,
			String accountStatus) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.failedCount = failedCount;
		this.accountStatus = accountStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		String result = "User Details::\n  Name: " + name + "\n  MobileNumber: " + mobileNumber + "\n  E-mail: " + email
				+ "\n  Password: " + password + "\n  Failed Count: " + failedCount + "\n  Account Status: "
				+ accountStatus;
		return result;
	}

}
