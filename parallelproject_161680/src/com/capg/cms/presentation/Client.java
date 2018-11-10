package com.capg.cms.presentation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
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
				System.out.println("Enter a Username");
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
				System.out.println("You need to Enter Account number and Password to view balance");
				System.out.println("-------------------------------------------------");
				System.out.println("enter account number");
				Long accountNo2 = sc.nextLong();

				System.out.println("Enter your Password");
				String password2 = sc.next();

				Account c = service.displayAccount(accountNo2);
				System.out.println("Availaible balance in " + c.getAccountNo() + " is Rs." + c.getBalance());

				break;

			case 3:
				Transaction transaction3 = new Transaction();
				System.out.println("You need to Enter Account Number, Password and Amount to be deposited");

				System.out.println("Enter your Account Number");
				Long accountNo3 = sc.nextLong();

				System.out.println("Enter your Password");
				String password3 = sc.next();

				System.out.println("Enter the amount to be deposited");
				Double depositAmount = sc.nextDouble();

				// Generating utrNo
				Random rnd1 = new Random();
				Integer utr = 10000000 + rnd1.nextInt(90000000);
				Long utrNo = (long) utr;
				transaction3.setUtrNo(utrNo);

				// Setting AccountNo
				transaction3.setAccountNoCr(accountNo3);

				// Setting Deposit Amount
				transaction3.setTransferAmt(depositAmount);

				// Setting Date and time.
				LocalDate date = LocalDate.now();
				transaction3.setDate(date);

				// Setting Transaction type.
				String Transactiontype = "Cr.";
				transaction3.setTransactiontype(Transactiontype);

				Transaction depositTransaction = service.deposit(accountNo3, depositAmount, transaction3);
				System.out.println("Transaction Details are:" + depositTransaction);

				break;

			case 4:
				Transaction transaction4 = new Transaction();
				System.out.println("You need to Enter Account Number, Password and Amount to be Withdrawn");

				System.out.println("Enter your Account Number");
				Long accountNo4 = sc.nextLong();

				System.out.println("Enter your Password");
				String password4 = sc.next();

				System.out.println("Enter the amount to be Withdrawn");
				Double withdrawAmount = sc.nextDouble();

				// Generating utrNo
				Random rnd2 = new Random();
				Integer utr1 = 10000000 + rnd2.nextInt(90000000);
				Long utrNo1 = (long) utr1;
				transaction4.setUtrNo(utrNo1);

				// Setting AccountNo
				transaction4.setAccountNoDr(accountNo4);

				// Setting Deposit Amount
				transaction4.setTransferAmt(withdrawAmount);

				// Setting Date and time.
				LocalDate date1 = LocalDate.now();
				transaction4.setDate(date1);

				// Setting Transaction type.
				String Transactiontype1 = "Dr.";
				transaction4.setTransactiontype(Transactiontype1);

				Transaction withdrawTransaction = service.withdraw(accountNo4, withdrawAmount, transaction4);
				System.out.println("Transaction Details are:" + withdrawTransaction);
				break;

			case 5:
				Transaction transaction5 = new Transaction();
				System.out.println(
						"You need to Enter Debit Account Number, Credit Account Number Password and Amount to be Transferred");

				System.out.println("Enter Debit Account Number");
				Long accountNo5Dr = sc.nextLong();

				System.out.println("Enter Credit Account Number");
				Long accountNo5Cr = sc.nextLong();

				System.out.println("Enter your Password");
				String password5 = sc.next();

				System.out.println("Enter the amount to be Transferred");
				Double transferAmount = sc.nextDouble();

				// Generating utrNo
				Random rnd3 = new Random();
				Integer utr2 = 10000000 + rnd3.nextInt(90000000);
				Long utrNo2 = (long) utr2;
				transaction5.setUtrNo(utrNo2);

				// Setting Debit AccountNo
				transaction5.setAccountNoDr(accountNo5Dr);

				// Setting Credit AccountNo
				transaction5.setAccountNoCr(accountNo5Cr);

				// Setting Deposit Amount
				transaction5.setTransferAmt(transferAmount);

				// Setting Date and time.
				LocalDate date2 = LocalDate.now();
				transaction5.setDate(date2);

				// Setting Transaction type.
				String Transactiontype2 = "Dr.";
				transaction5.setTransactiontype(Transactiontype2);

				Transaction transferTransaction = service.fundTransfer(accountNo5Cr, accountNo5Dr, transferAmount,
						transaction5);
				System.out.println("Transaction Details are:" + transferTransaction);
				break;

			case 6:
				System.out.println("You need to Enter your Account Number to view Transactions");

				System.out.println("enter your account number");
				Long accountNo6 = sc.nextLong();
				List<Transaction> transactionList = service.printTransactions(accountNo6);
				Iterator<Transaction> iterator = transactionList.iterator();
				while(iterator.hasNext())
				{
					System.out.println(iterator.next());
				}
				break;

			case 7:
				System.out.println("==================================================================\n");
				System.out.println("Thank You for using UTI Bank Limited's payment system.\n");
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