package com.capg.cms.service;

import java.util.List;

import com.capg.cms.dto.Account;
import com.capg.cms.dto.Transaction;
import com.capg.cms.exception.AccountException;

public interface ICustomerService {
	public boolean addCustomer(Account a) throws AccountException;
	public Account displayAccount(Long accountNo) throws AccountException;
	public Transaction deposit(Long accountNo, Double depositAmount, Transaction transaction) throws AccountException;
	public Transaction withdraw(Long accountNo , Double withdrawAmount, Transaction transaction) throws AccountException;
	public Transaction fundTransfer(Long accountNoCr, Long AccountNoDr, Double transferAmt, Transaction transaction) throws AccountException;
	public List<Transaction> printTransactions(Long accountNo) throws AccountException;
}