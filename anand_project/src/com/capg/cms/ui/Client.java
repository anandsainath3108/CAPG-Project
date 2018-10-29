package com.capg.cms.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import com.capg.cms.beans.Customer;
import com.capg.cms.service.CustomerServiceImp;


public class Client {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Customer c1 = new Customer();
		StringBuffer sb = new StringBuffer();
		StringBuffer sbT = new StringBuffer();
		CustomerServiceImp service = new CustomerServiceImp();
		
		while(true)
		{
			
		System.out.println("------------------------------------------------------------------\n");
		System.out.println("welcome to UTI Bank Limited\n");
		System.out.println("------------------------------------------------------------------");
		System.out.println("1. Create Account");
		System.out.println("2. Show Balance");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Fund Transfer");
		System.out.println("6. Print Transaction");
		System.out.println("7. Exit");

		Scanner sc = new Scanner(System.in);
		int Choice = sc.nextInt();

		switch (Choice) 
		{
		case 1: 
			Customer bean  = new Customer();
			//Validating Name
			String name;
			do
			{
			System.out.println("Enter Your Name");
			name = sc.next();
			}while(!service.validateName(name) );
			bean.setMobileNo(name);
			// Validating E-mail-ID
			String email;
			do
			{
			System.out.println("Enter your email id");
			email = sc.next();
			}while(!service.isValidEmailAddress(email));
			bean.setEmailId(email);
			// Address
			System.out.println("Enter your Address");
			String addr = sc.next();
			bean.setAddr(addr);
			
			//ID Proof Number
			String id;
			do
			{
			System.out.println("Enter an ID Proof Number(5 digit id)");
			id = sc.next();
			}
			while(!service.validateId(id));
			bean.setId(id);
			
			//Validating Mobile Number
			String mobile;
			do
			{
			System.out.println("Enter your Mobile Number");
			mobile = sc.next();
			}
			while(!service.validateNumber(mobile) );
			bean.setMobileNo(mobile);
			
			//Validating Age
			int age;
			do
			{
			System.out.println("Enter your age");
			age = sc.nextInt();
			}
			while(!service.validateAge(age));
			bean.setAge(age);
			
			//Creating AccNo
			Random rnd = new Random();
			int accountNo = 100000 + rnd.nextInt(900000);
			System.out.println(accountNo);
			bean.setAccountNo(accountNo);
			
			//Creating Pin
			Random rnd2 = new Random();
			int pin = 1000 + rnd.nextInt(9000);
			System.out.println(pin);
			bean.setPin(pin);
			
			//Validating Balance
			double balance;
			do
			{
			System.out.println("Enter Account opening balance");
			balance = sc.nextInt();
			}
			while(!service.validateBalance(balance));
			bean.setBalance(balance);
			
			System.out.println(bean);
			//handing objects to bean object after taking input from user
			long a = bean.getAccountNo();
			boolean isAdded = service.addCustomer(a, bean);
			break;
		
		case 2:
			System.out.println("Enter Account number and pin to show balance");
			System.out.println("--------------------------------------------");
			System.out.println("enter account number");
			long accountNo2 = sc.nextLong();
			
			System.out.println("enter pin");
			int pin2 = sc.nextInt();
		
			Customer c = service.displayCustomer(accountNo2, pin2);
			System.out.println("Rs. " + c.getBalance() + "added to account number " + c.getAccountNo());
				
			break;
		
		case 3:
			 Customer c11 = new Customer();
			System.out.println("enter account number and amount to be deposited");
			
			System.out.println("enter account no");
			long accountNo3 = sc.nextLong();
			
			System.out.println("enter amount to be deposited");
			double depositAmount = sc.nextDouble();
			
			Customer ac = service.deposit(accountNo3, depositAmount);
			System.out.println("Balance for account number "+ ac.getAccountNo() + " is now: " + ac.getBalance());
			
			service.printTransactions(ac);
			break;
			
		case 4:
			System.out.println("enter account number and pin to proceed");
			
			System.out.println("enter account number");
			long accountNo4 = sc.nextLong();

			System.out.println("enter pin");
			int pin4 = sc.nextInt();
			
			System.out.println("enter amount to be withdrawn");
			double withdrawAmount = sc.nextDouble();
			
			Customer c8 = service.withdraw(accountNo4 , pin4 , withdrawAmount, sb);
			System.out.println("Balance for account number "+ c8.getAccountNo() + " is now: " + c8.getBalance());
			break;

		case 5:
			System.out.println("enter your account number");
			long accountNo5 = sc.nextLong();
			
			System.out.println("enter your pin");
			int pin5 = sc.nextInt();
			
			System.out.println("enter account number to which you want to transfer amount");
			long accountNoTransfer = sc.nextLong();
			
			System.out.println("enter amount");
			double amountTransfer = sc.nextDouble();
			
			
			Customer c2 = service.fundTransfer(accountNo5 , pin5 , accountNoTransfer , amountTransfer, sb, sbT);
			//System.out.println("amount transfered to: " + c2.getAccountNo());
			System.out.println("amount transfered from : " + c2.getAccountNo() + " balance = " + c2.getBalance());
			//System.out.println("balance: " + c2.getBalance());
			
			break;
			
		case 6:
			System.out.println("enter account number and pin to print transactions");
			
			System.out.println("enter your account number");
			long accountNo6 = sc.nextLong();
			
			System.out.println("enter your pin");
			int pin6 = sc.nextInt();
		
		//	Customer c3 = service.printTransactions(accountNo6 , pin6);
			
			
			break;
		case 7:
			System.exit(0);
			System.out.println("==================================================================\n");
			System.out.println("Thank You for UTI Bank Limited\n");
			System.out.println("==================================================================");
			break;
		default:
			break;
		}

	}
		
	}

}
