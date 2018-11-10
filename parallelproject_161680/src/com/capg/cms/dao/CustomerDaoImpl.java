package com.capg.cms.dao;

import java.util.List;

import com.capg.cms.dto.Account;
import com.capg.cms.dto.Transaction;
import com.capg.cms.exception.AccountException;

public class CustomerDaoImpl implements ICustomerDAO {

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

}
