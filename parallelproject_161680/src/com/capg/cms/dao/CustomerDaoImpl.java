package com.capg.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.capg.cms.entity.Account;
import com.capg.cms.entity.Transaction;
import com.capg.cms.exception.AccountException;
import com.capg.cms.utility.JPAUtil;

public class CustomerDaoImpl implements ICustomerDAO {
	EntityManager entityManager = null;
	@Override
	public boolean addCustomer(Account account1) throws AccountException {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(account1);
			entityManager.getTransaction().commit();
			flag = true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			// TODO: Log to file
			throw new AccountException(e.getMessage());
		} finally {
			entityManager.close();
		}
      return flag;
	}

	@Override
	public Account displayAccount(Long accountNo) throws AccountException {
		// TODO Auto-generated method stub
		Account account = null;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			account = entityManager.find(Account.class, accountNo);
			return account;
		} catch (PersistenceException e) {
			e.printStackTrace();
			// TODO: Log to file
			throw new AccountException(e.getMessage());
		} finally {
			entityManager.close();
		}
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