package com.capg.cms.dto;

import java.time.LocalDate;

public class Transaction {

	private Long utrNo;
	private Long accountNoCr;
	private Long accountNoDr;
	private Double transferAmt;
	private Double balance;
	private LocalDate date;
	private String Transactiontype;
	public Long getUtrNo() {
		return utrNo;
	}
	public void setUtrNo(Long utrNo) {
		this.utrNo = utrNo;
	}
	public Long getAccountNoCr() {
		return accountNoCr;
	}
	public void setAccountNoCr(Long accountNoCr) {
		this.accountNoCr = accountNoCr;
	}
	public Long getAccountNoDr() {
		return accountNoDr;
	}
	public void setAccountNoDr(Long accountNoDr) {
		this.accountNoDr = accountNoDr;
	}
	public Double getTransferAmt() {
		return transferAmt;
	}
	public void setTransferAmt(Double transferAmt) {
		this.transferAmt = transferAmt;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTransactiontype() {
		return Transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		Transactiontype = transactiontype;
	}
	
	@Override
	public String toString() {
		return "Transaction [utrNo=" + utrNo + ", accountNoCr=" + accountNoCr + ", accountNoDr=" + accountNoDr
				+ ", transferAmt=" + transferAmt + ", balance=" + balance + ", date=" + date + ", Transactiontype="
				+ Transactiontype + "]";
	}
	
}
