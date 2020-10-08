package com.india.maheshdemo.bankingserver.dto;

import java.util.List;

import org.springframework.stereotype.Component;


public class SavingAccount extends BankAccount {
	
	public SavingAccount() {
		super();
	}

	public SavingAccount(String accountNumber, double minimumBalance, double currentBalance, double intrestRate,
			List<Transaction> listOfTransactions, String branchId) {
		super(accountNumber, minimumBalance, currentBalance, intrestRate, listOfTransactions, branchId);
	}

	@Override
	public String getTypeOfAccount() {
		return "SAVING";
	}

}
