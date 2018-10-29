package com.capg.cms.beans;

import com.capg.cms.exception.CustomerNotFound;

public class Customer {

	String name;
	String id;
	int age;
	String mobileNo;
	String emailId;
	long accountNo;
	String addr;
	int pin;
	double balance;
	StringBuffer sb = new StringBuffer("hhhh");
	
	public String getMobileNo() {
		return mobileNo;
	}

	public StringBuffer getSb() {
		return sb;
	}

	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getEmailId() {
		return emailId;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public String getAddr() {
		return addr;
	}

	public int getPin() {
		return pin;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", age=" + age + ", mobileNo=" + mobileNo + ", emailId="
				+ emailId + ", accountNo=" + accountNo + ", addr=" + addr + ", pin=" + pin + ", balance=" + balance
				+ ", sb=" + sb + "]";
	}
}
