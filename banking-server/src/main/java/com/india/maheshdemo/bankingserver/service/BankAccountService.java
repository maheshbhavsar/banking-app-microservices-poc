package com.india.maheshdemo.bankingserver.service;

import java.util.List;

import com.india.maheshdemo.bankingserver.dto.Transaction;

public interface BankAccountService {

	public Double withdraw(double amount, String accountNumber);
	
	public Double deposit(double amount, String accountNumber);
	
	public List<Transaction> getTransactionHistory(String accountNumber);
	
	public List<Transaction> getMiniStatment();
	
	public Double getMinimumBalance(String accountNumber);
	
	public Double getCurrentBalance(String accountNumber);
	
	public Double getIntrestRate(String accountNumber);
	
	public String getTypeOfTransaction();
}
