package com.capg.cms.presentation;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import com.capg.cms.entity.Account;
import com.capg.cms.entity.Transaction;
import com.capg.cms.exception.AccountException;
import com.capg.cms.service.CustomerServiceImpl;

public class Client {
	public static void main(String[] args) throws IOException, AccountException {
		// TODO Auto-generated method stub
		CustomerServiceImpl service = new CustomerServiceImpl();
		while (true) {

			System.out.println("------------------------------------------------------------------\n");
			System.out.println("Welcome to UTI Bank Limited\n");
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

			switch (Choice) {
			case 1:
				Account bean = new Account();

				
				// Validating Name
				String name;
				do {
					System.out.println("Enter Your Name");
					name = sc.next();
				} while (!service.validateName(name));
				bean.setName(name);

				
				// Validating E-mail-ID
				String email;
				do {
					System.out.println("Enter your email id");
					email = sc.next();
				} while (!service.isValidEmailAddress(email));
				bean.setEmailId(email);

				
				// Address
				System.out.println("Enter your Address");
				String addr = sc.next();
				bean.setAddr(addr);

				
				// ID Proof Number
				String id;
				do {
					System.out.println("Enter an ID Proof Number(10 digit id)");
					id = sc.next();
				} while (!service.validateId(id));
				bean.setIdProofNo(id);

				
				// Validating Mobile Number
				String mobile;
				do {
					System.out.println("Enter your Mobile Number");
					mobile = sc.next();
				} while (!service.validateNumber(mobile));
				bean.setMobileNo(mobile);

				
				// Validating Age
				Integer age;
				do {
					System.out.println("Enter your age");
					age = sc.nextInt();
				} while (!service.validateAge(age));
				bean.setAge(age);

				
				// Creating AccNo
				Random rnd = new Random();
				Integer accNo = 100000 + rnd.nextInt(900000);
				Long accountNo = (long) accNo;
				System.out.println(accountNo);
				bean.setAccountNo(accountNo);

				
				// Validating Username
				String username;
				System.out.println("Enter your Mobile Number");
				username = sc.next();
				bean.setUsername(username);

				
				// Validating Password
				String password, passwordVer;
				do {
					System.out.println("Create your Password");
					password = sc.next();
					System.out.println("Re-Enter your Password");
					passwordVer = sc.next();
				} while (!service.validatePassword(password, passwordVer));
				bean.setPassword(password);

				
				// Validating Balance
				double balance;
				do {
					System.out.println("Enter Account opening balance");
					balance = sc.nextInt();
				} while (!service.validateBalance(balance));
				bean.setBalance(balance);

				System.out.println(bean);

				
				// handing objects to bean object after taking input from user
				Long a = bean.getAccountNo();
				System.out.println("Your Account Number is:" + a);
				boolean isAdded = service.addCustomer(bean);
				break;

			
			case 2:
				System.out.println("Enter Account number and Password to show balance");
				System.out.println("--------------------------------------------");
				System.out.println("enter account number");
				Long accountNo2 = sc.nextLong();
				
				System.out.println("Enter your Password");
				String password2 = sc.next();

				Account c = service.displayAccount(accountNo2);
				System.out.println( "Availaible balance in "+c.getAccountNo()+" is Rs."+c.getBalance());

				break;

			
			case 3:
				Transaction transaction3 = new Transaction();
				System.out.println("Enter Account Number, Password and Amount to be deposited");

				System.out.println("Enter your Account Number");
				Long accountNo3 = sc.nextLong();

				System.out.println("Enter your Password");
				String password3 = sc.next();

				System.out.println("Enter the amount to be deposited");
				Double depositAmount = sc.nextDouble();

				Transaction depositTransaction = service.deposit(accountNo3, depositAmount, transaction3);
				System.out.println("Transaction Details are:" + depositTransaction);

				break;

			
			case 4:
				Transaction transaction4 = new Transaction();
				System.out.println("Enter Account Number, Password and Amount to be Withdrawn");

				System.out.println("Enter your Account Number");
				Long accountNo4 = sc.nextLong();

				System.out.println("Enter your Password");
				String password4 = sc.next();

				System.out.println("Enter the amount to be Withdrawn");
				Double withdrawAmount = sc.nextDouble();

				Transaction withdrawTransaction = service.withdraw(accountNo4, withdrawAmount, transaction4);
				System.out.println("Transaction Details are:" + withdrawTransaction);
				break;

			
			case 5:
				Transaction transaction5 = new Transaction();
				System.out.println(
						"Enter Debit Account Number, Credit Account Number Password and Amount to be Transferred");

				System.out.println("Enter Debit Account Number");
				Long accountNo5Dr = sc.nextLong();

				System.out.println("Enter Debit Account Number");
				Long accountNo5Cr = sc.nextLong();

				System.out.println("Enter your Password");
				String password5 = sc.next();

				System.out.println("Enter the amount to be Transferred");
				Double transferAmount = sc.nextDouble();

				Transaction transferTransaction = service.fundTransfer(accountNo5Cr, accountNo5Dr, transferAmount,
						transaction5);
				System.out.println("Transaction Details are:" + transferTransaction);
				break;

			
			case 6:
				System.out.println("enter account number and pin to print transactions");

				System.out.println("enter your account number");
				long accountNo6 = sc.nextLong();

				System.out.println("enter your pin");
				int password6 = sc.nextInt();
				break;
			
			
			case 7:
				System.out.println("==================================================================\n");
				System.out.println("Thank You for using UTI Bank Limited\n");
				System.out.println("==================================================================");
			    sc.close();
				System.exit(0);
				break;
			default:
				break;
			}

		}

	}

}