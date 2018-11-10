package com.capg.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
			// TODO: Log to file
			throw new AccountException(e.getMessage());
		} finally {

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
			// TODO: Log to file
			throw new AccountException(e.getMessage());
		} finally {

		}
	}

	@Override
	public Transaction deposit(Long accountNo, Double depositAmount, Transaction transaction) throws AccountException {
		// TODO Auto-generated method stub
		Account account = null;

		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			account = entityManager.find(Account.class, accountNo);
			Double newBalance = account.getBalance() + depositAmount;
			account.setBalance(newBalance);
			transaction.setBalance(newBalance);

			// Depositing the amount in the account
			entityManager.merge(account);
			entityManager.getTransaction().commit();

			// Noting the transaction
			Transaction transaction1 = addTransaction(transaction);

			return transaction1;
		} catch (PersistenceException e) {
			// TODO: Log to file
			throw new AccountException(e.getMessage());
		} finally {

		}
	}

	@Override
	public Transaction withdraw(Long accountNo, Double withdrawAmount, Transaction transaction)
			throws AccountException {
		// TODO Auto-generated method stub
		Account account = null;
		Transaction transaction1;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			account = entityManager.find(Account.class, accountNo);
			if (account.getBalance() - withdrawAmount > 5000) {
				Double newBalance = account.getBalance() - withdrawAmount;
				account.setBalance(newBalance);
				transaction.setBalance(newBalance);

				// Depositing the amount in the account
				entityManager.merge(account);
				entityManager.getTransaction().commit();

				// Noting the transaction
				transaction1 = addTransaction(transaction);

				return transaction1;
			} else {
				Transaction transaction2 = null;
				return transaction2;
			}
		} catch (PersistenceException e) {
			// TODO: Log to file
			throw new AccountException(e.getMessage());
		} finally {

		}
	}

	@Override
	public Transaction fundTransfer(Long accountNoCr, Long AccountNoDr, Double transferAmt, Transaction transaction)
			throws AccountException {
		// TODO Auto-generated method stub
		Account account, account1 = null;
		Transaction transaction1;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();

			// Dr. Account
			account = entityManager.find(Account.class, AccountNoDr);
			if (account.getBalance() - transferAmt > 5000) {
				Double newBalance = account.getBalance() - transferAmt;
				account.setBalance(newBalance);
				transaction.setBalance(newBalance);

				// Debit the amount in the accountDr
				entityManager.merge(account);

				// Cr. Account
				account1 = entityManager.find(Account.class, accountNoCr);
				Double newBalance1 = account1.getBalance() + transferAmt;
				account1.setBalance(newBalance1);

				// Credit the amount in the accountCr
				entityManager.merge(account1);
				entityManager.getTransaction().commit();

				// Noting the transaction
				transaction1 = addTransaction(transaction);

				return transaction1;
			} else {
				Transaction transaction2 = null;
				return transaction2;
			}
		} catch (PersistenceException e) {
			// TODO: Log to file
			throw new AccountException(e.getMessage());
		} finally {

		}

	}

	@Override
	public List<Transaction> printTransactions(Long accountNo) throws AccountException {
		// TODO Auto-generated method stub
		EntityManager entityManager = JPAUtil.getEntityManager();
		String jql = "select e from Transaction e where e.accountNoCr=:paccountNo or e.accountNoDr=:paccountNo";
		TypedQuery<Transaction> typedQuery = entityManager.createQuery(jql, Transaction.class);
		typedQuery.setParameter("paccountNo", accountNo);
		List<Transaction> transactionList = typedQuery.getResultList();
	    return transactionList;
	}

	@Override
	public Transaction addTransaction(Transaction transaction) throws AccountException {
		// TODO Auto-generated method stub
		Transaction transaction1 = null;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(transaction);
			entityManager.getTransaction().commit();
			transaction1 = transaction;
		} catch (PersistenceException e) {
			e.printStackTrace();
			// TODO: Log to file
			throw new AccountException(e.getMessage());
		} finally {

		}
		return transaction1;
	}
}
