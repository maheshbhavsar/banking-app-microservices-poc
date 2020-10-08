package com.india.maheshdemo.bankingserver.dto;

import java.util.List;


public class CurrentAccount	extends BankAccount{
	
	public CurrentAccount() {
		super();
	}
	
	public CurrentAccount(String accountNumber, double minimumBalance, double currentBalance, double intrestRate,
			List<Transaction> listOfTransactions, String branchId) {
		super(accountNumber, minimumBalance, currentBalance, intrestRate, listOfTransactions, branchId);
	}

	@Override
	public String getTypeOfAccount() {
		return "CURRENT";
	}

	
	
}
