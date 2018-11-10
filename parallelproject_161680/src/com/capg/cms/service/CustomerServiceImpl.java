package com.capg.cms.service;

import java.util.List;

import com.capg.cms.dto.Account;
import com.capg.cms.dto.Transaction;
import com.capg.cms.exception.AccountException;

public class CustomerServiceImpl implements ICustomerService{

	@Override
	public boolean addCustomer(Account a) throws AccountException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account displayAccount(Long accountNo) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction deposit(Long accountNo, Double depositAmount, Transaction transaction) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction withdraw(Long accountNo, Double withdrawAmount, Transaction transaction)
			throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction fundTransfer(Long accountNoCr, Long AccountNoDr, Double transferAmt, Transaction transaction)
			throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> printTransactions(Long accountNo) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}



public boolean validateName(String name) throws AccountException {

	if (name.matches("^[a-zA-Z]+$")) {
		return true;

	} else
		System.out.println("Name should consist only characters");
	return false;
}

public boolean isValidEmailAddress(String email) throws AccountException {
	String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	java.util.regex.Matcher m = p.matcher(email);
	return m.matches();
}

public boolean validateNumber(String mobile) throws AccountException {

	if (mobile.matches("[0-9]{10}")) {
		return true;

	} else
		System.out.println("Enter a valid mobile number");
	return false;
}

public boolean validateAge(int age) throws AccountException {
	if (age > 0 && age<125)
		return true;
	else
		System.out.println("Enter a valid age");
	return false;
}

public boolean validateId(String id) throws AccountException {
	if (id.matches("[0-9]{10}")) {
		return true;

	} else
		System.out.println("ID Number should consist of of 10 Digits/Characters");
	return false;
}

public boolean validateBalance(double balance) throws AccountException {
	if (balance > 5000)
		return true;
	else
		System.out.println("Balance too low. Please maintain a minimum balance of Rs.5000 ");
	return false;
}
}
