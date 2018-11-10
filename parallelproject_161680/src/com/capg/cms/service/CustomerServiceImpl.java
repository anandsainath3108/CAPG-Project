package com.capg.cms.service;

import java.util.List;

import com.capg.cms.dao.CustomerDaoImpl;
import com.capg.cms.entity.Account;
import com.capg.cms.entity.Transaction;
import com.capg.cms.exception.AccountException;

public class CustomerServiceImpl implements ICustomerService{
       CustomerDaoImpl dao = new CustomerDaoImpl();
	@Override
	public boolean addCustomer(Account account) throws AccountException {
		// TODO Auto-generated method stub
		return dao.addCustomer(account);
	}

	@Override
	public Account displayAccount(Long accountNo) throws AccountException {
		// TODO Auto-generated method stub
		return dao.displayAccount(accountNo);
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


//Validating Name
public boolean validateName(String name) throws AccountException {

	if (name.matches("^[a-zA-Z]+$")) {
		return true;

	} else
		System.out.println("Name should consist only characters");
	return false;
}


//Validating Email
public boolean isValidEmailAddress(String email) throws AccountException {
	String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	java.util.regex.Matcher m = p.matcher(email);
	return m.matches();
}


//Validating Phone Number
public boolean validateNumber(String mobile) throws AccountException {

	if (mobile.matches("[0-9]{10}")) {
		return true;

	} else
		System.out.println("Enter a valid mobile number");
	return false;
}


//Validating Age
public boolean validateAge(int age) throws AccountException {
	if (age > 0 && age<125)
		return true;
	else
		System.out.println("Enter a valid age");
	return false;
}


//Validating ID Proof
public boolean validateId(String id) throws AccountException {
	if (id.matches("[0-9]{10}")) {
		return true;

	} else
		System.out.println("ID Number should consist of of 10 Digits/Characters");
	return false;
}


//validating Balance
public boolean validateBalance(double balance) throws AccountException {
	if (balance > 5000)
		return true;
	else
		System.out.println("Balance too low. Please maintain a minimum balance of Rs.5000");
	return false;
}


//Validating Password
public boolean validatePassword(String password, String passwordVer) {
	// TODO Auto-generated method stub
	boolean flag = false;
	if(password.length() >= 8 && password.equals(passwordVer)) {
	flag = true;
	}
	else {
		System.out.println("Password should be atleast 8 Characters long");
	}
	return flag;
}
}