package com.project.bank_app.Main;

import java.util.*;

import com.project.bank_app.Entity.User;
import com.project.bank_app.Services.UserServices;
public class Main {

	private static Scanner scan = new Scanner(System.in);

	private static UserServices userServices = new UserServices();


	public static void main(String[] args) {

		Main main = new Main();

		while(true) {

			System.out.println("Enter your User Id");
			String userId = scan.next();

			System.out.println("Enter your Password");
			String password = scan.next();

			User user= userServices.loginCheck(userId, password);

			if(user!=null && user.getRole().equals("admin")){ 

				main.initadmin();		
			}
			else if(user!=null && user.getRole().equals("user")) {

				main.initCustomer(user);
			}
			else {

				System.out.println("Please check your Credentials");
			}
		}
	}

	private void initadmin()
	{
		boolean flag = true;

		while(flag) {

			System.out.println("1. Create User Account");
			System.out.println("2. Exit/logout");
			System.out.println("3. View All Transation");
			System.out.println("4. Check User Account Balance");
			System.out.println("Enter Your option");

			int enteredOption = scan.nextInt();

			switch(enteredOption) {

			case 1: createNewUserAccount();

			System.out.println();
			System.out.println("--------------- Task Completed ---------------------");

			break;

			case 2: flag = false;
			System.out.println("\"thank you for using our service...\" Successfully logged out");

			System.out.println();
			System.out.println("--------------- Task Completed ---------------------");

			break;

			case 3: System.out.println("Enter the User Id");
			String user = scan.next();
			viewAllTransation(user);

			break;

			default: System.out.println("Please enter valid option...");
			break;
			}
		}
	}

	private void initCustomer(User user)
	{
		boolean flag = true;

		while(flag) {

			System.out.println("1. Exit/logout");
			System.out.println("2. Check Account Balance");
			System.out.println("3. Fund Transfer ");
			System.out.println("4. See All Transation");

			int selectedOption = scan.nextInt();

			switch(selectedOption)
			{

			case 1: flag = false;

			System.out.println("\"Thank you for using our service\" Successfully logged out...");
			System.out.println();
			System.out.println("--------------- Request Successful ---------------------");
			break;

			case 2: Double balance = checkAccountBalance(user.getUserId());

			System.out.println("Your Account balance is : "+ balance);

			System.out.println();
			System.out.println("--------------- Request Successful ---------------------");

			break;

			case 3:  boolean Checkflag = true;

			while(Checkflag)
			{
				System.out.println("Enter User Id");
				String payee = scan.next();

				if(user.getUserId().equals(payee))
				{
					System.out.println("Please check both the Your Id -- "+ user.getUserId() + " and Receiver Id-- " + payee+ ", are same...");
					break;
				}
				else
				{
					User userVerfication = getUser(payee);

					if(userVerfication != null){

						Checkflag = false;

						System.out.println("Enter the Amount");
						double amount = scan.nextDouble();

						double Accountbalance = user.getAccountBalance();

						if( Accountbalance>= amount){

							transferAmount(user.getUserId(),payee,amount);
						}
						else {

							System.out.println("Insufficient Balance : "+ Accountbalance);
						}
					}
					else {

						System.out.println("Please Enter Valid User Id...");
					}
				}
			}
			break;
			case 4: viewAllTransation(user.getUserId());
			break;

			default: System.out.println("Please enter valid option...");
			break;
			}
		}
	}

	private void createNewUserAccount()
	{
		System.out.println("Enter your Id");
		String userId = scan.next();

		scan.nextLine();
		System.out.println("Enter your Name");
		String name = scan.nextLine();

		System.out.println("Enter your Contact Number");
		long contact = scan.nextLong();

		System.out.println("Enter your Password");
		String password = scan.next();

		scan.nextLine();
		System.out.println("Enter your Address");
		String address = scan.nextLine();

		Boolean result = userServices.createNewUserAccount(userId, name, password, contact, address);

		if(result){

			System.out.println("New User Created Successfully...");
		}
		else{

			System.out.println(" \"user is already Present.\" Creation Failed... ");
		}
	}

	private Double checkAccountBalance(String userId)
	{
		return userServices.checkAccountBalance(userId);
	}

	private User getUser(String userId)
	{
		return userServices.getUser(userId);
	}

	private void transferAmount(String userId, String payeeId, double amount)
	{
		boolean result = userServices.transferAmount(userId, payeeId, amount);

		if(result){
			System.out.println("Amount Transfer Successful...");
		}
		else{
			System.out.println("Amount Transfer Failed...");
		}
	}

	public void viewAllTransation(String userId)
	{
		userServices.viewAllTransation(userId);
	}

}
