package com.capg.cms.service;

import com.capg.cms.beans.Customer;

public interface ICustomerService {
	
	
	
	//public boolean addCustomer(Customer c);
	public Customer displayCustomer(int cid);
	boolean addCustomer(long accNo, Customer c);
	public Customer printTransactions(Customer c);
	public Customer deposit(long accountNo, double depositAmount);
	public Customer withdraw(long accountNo, int pin , double withdrawAmount, StringBuffer sb);
	

}
