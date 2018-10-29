package com.capg.cms.dao;

import java.util.HashMap;
import java.util.Map;

import com.capg.cms.beans.Customer;

public class CustomerDAOImp implements ICustomerDAO {

	Map<Long, Customer> acc = new HashMap<Long, Customer>();
	Map<Long, StringBuffer> transaction = new HashMap<Long, StringBuffer>();

	@Override
	public boolean addCustomer(long accNo, Customer c) {
		// TODO Auto-generated method stub

		boolean isAdded = false;

		// add - predefined method of collections, returns boolean value
		acc.put(accNo, c);
		System.out.println("Details of Account added:" + acc);
        return isAdded;

	}

	@Override
	public Customer displayCustomer(long accountNo, int pin) {
		// TODO Auto-generated method stub

		Customer cust = null;
		for (Customer acc1 : acc.values()) {
			if (acc1.getAccountNo() == accountNo && acc1.getPin() == pin) {
				cust = acc1;

			} else
				System.out.println("Enter valid Pin/Account number");

		}

		return cust;
	}

	public Customer deposit(long accountNo, double depositAmount) {
		// TODO Auto-generated method stub

		Customer cust = null;

		for (Customer acc : acc.values()) {
			if (acc.getAccountNo() == accountNo) {
			}

		}

		for (Customer acc : acc.values()) {
			if (acc.getAccountNo() == accountNo)

			{

				double amt = acc.getBalance();

				amt = amt + depositAmount;
				acc.setBalance(amt);
				System.out.println(".......");
				System.out.println(transaction);

				cust = acc;
			}
		}

		return cust;
	}

	public Customer withdraw(long accountNo, int pin, double withdrawAmount, StringBuffer sb) {

		Customer cust = null;

		for (Customer acc : acc.values()) {
			if (acc.getAccountNo() == accountNo) {
				double amt = acc.getBalance();
				if (withdrawAmount < amt) {
					amt = amt - withdrawAmount;
					acc.setBalance(amt);
					cust = acc;
				}
			}
		}
		return cust;
	}

	public Customer fundTransfer(long accountNo, int pin, long accountNoTransfer, double amountTransfer,
			StringBuffer sb, StringBuffer sbT) {
		Customer cust = null;

		for (Customer acc1 : acc.values()) {
			if (acc1.getAccountNo() == accountNo
					&& acc1.getPin() == pin )

			{
				double amt = acc1.getBalance();
				if (amountTransfer < amt) {
					double from = acc1.getBalance();
					from = from - amountTransfer;

					for (Customer acc2 : acc.values()) {
						if (acc.containsKey(accountNoTransfer) && acc.containsKey(accountNo)) {
							double to = acc2.getBalance();
							to = to + amountTransfer;
							acc2.setBalance(to);
							acc1.setBalance(from);
							cust = acc2;

						} else {
							System.out.println("Enter correct Credit/Debit AccountNumber to be transferred");
						}
					}

				}
			}
		}

		return cust;
	}

	public Customer printTransactions(Customer ac) {
		Customer cust = null;
		long a = ac.getAccountNo();
		StringBuffer s = new StringBuffer();
		s = ac.getSb();
		s.append("balance is now ");
		s.append(ac.getBalance());
		ac.setSb(s);
		transaction.put(a, s);
		System.out.println("inside print transaction");
		for (StringBuffer transaction1 : transaction.values()) {

			transaction.entrySet().stream().forEach(System.out::println);
			System.out.println("Transactions are given below");
			System.out.println(transaction);
		}
		return cust;
	}

	/*
	 * @Override public Customer printTransactions(Customer ac) { // TODO
	 * Auto-generated method stub return null; }
	 */

}
