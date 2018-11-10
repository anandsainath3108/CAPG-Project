package com.capg.cms.exception;

public class AccountException extends Exception {
	
	private String status;
	
	public AccountException() {
		this.status="Unable to Perform the transaction. Please try sometime later";
	}
	
	public AccountException(String status) {
		super(status);
	}
	
	public String getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		return "EmployeeException [status=" + status + "]";
	}

}