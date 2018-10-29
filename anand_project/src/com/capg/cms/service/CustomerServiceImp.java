package com.capg.cms.service;

import com.capg.cms.beans.Customer;
import com.capg.cms.dao.CustomerDAOImp;

import java.io.BufferedReader;
import java.util.regex.Matcher;

public class CustomerServiceImp implements ICustomerService {

	CustomerDAOImp dao = new CustomerDAOImp();

	@Override
	public boolean addCustomer(long accNo, Customer c) {
		// TODO Auto-generated method stub
		return dao.addCustomer(accNo, c);
	}

	// @Override
	public Customer displayCustomer(long accountNo, int pin) {
		// TODO Auto-generated method stub
		return dao.displayCustomer(accountNo, pin);
	}

	public Customer deposit(long accountNo, double depositAmount) {
		// TODO Auto-generated method stub
		return dao.deposit(accountNo, depositAmount);
	}

	public Customer withdraw(long accountNo, int pin, double withdrawAmount, StringBuffer sb) {
		// TODO Auto-generated method stub
		return dao.withdraw(accountNo, pin, withdrawAmount, sb);
	}

	public Customer fundTransfer(long accountNo, int pin, long accountNoTransfer, double amountTransfer,
			StringBuffer sb, StringBuffer sbT) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(accountNo, pin, accountNoTransfer, amountTransfer, sb, sbT);
	}

	public boolean validateData(Customer c) {

		boolean flag = false;
		return flag;
	}

	public Customer printTransactions(Customer ac) {
		return dao.printTransactions(ac);
	}

	@Override
	public Customer displayCustomer(int cid) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean validateName(String name) {

		if (name.matches("^[a-zA-Z]+$")) {
			return true;

		} else
			System.out.println("Name should consist only characters");
		return false;
	}

	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public boolean validateNumber(String mobile) {

		if (mobile.matches("[0-9]{10}")) {
			return true;

		} else
			System.out.println("Enter a valid mobile number");
		return false;
	}

	public boolean validateAge(int age) {
		if (age > 0)
			return true;
		else
			System.out.println("Enter a valid age");
		return false;
	}

	public boolean validateId(String id) {
		if (id.matches("[0-9]{5}")) {
			return true;

		} else
			System.out.println("ID Number should consist of of 5 Digits/Characters");
		return false;
	}

	public boolean validateBalance(double balance) {
		if (balance > 5000)
			return true;
		else
			System.out.println("Balance too low ");
		return false;
	}

}
