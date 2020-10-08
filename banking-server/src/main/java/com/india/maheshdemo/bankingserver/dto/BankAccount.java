package com.india.maheshdemo.bankingserver.dto;

import java.util.List;

import org.springframework.stereotype.Component;


public abstract class BankAccount {
	private String accountNumber;
	private double minimumBalance;
	private double currentBalance;
	private double intrestRate;
	private List<Transaction> listOfTransactions;
	private String branchId;
	
	public BankAccount() {	}
	public BankAccount(String accountNumber, double minimumBalance, double currentBalance, double intrestRate,
			List<Transaction> listOfTransactions, String branchId) {
		super();
		this.accountNumber = accountNumber;
		this.minimumBalance = minimumBalance;
		this.currentBalance = currentBalance;
		this.intrestRate = intrestRate;
		this.listOfTransactions = listOfTransactions;
		this.branchId = branchId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}




	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public double getIntrestRate() {
		return intrestRate;
	}



	public void setIntrestRate(double intrestRate) {
		this.intrestRate = intrestRate;
	}



	public List<Transaction> getListOfTransactions() {
		return listOfTransactions;
	}



	public void setListOfTransactions(List<Transaction> listOfTransactions) {
		this.listOfTransactions = listOfTransactions;
	}



	public String getBranchId() {
		return branchId;
	}



	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}



	public abstract String getTypeOfAccount();
	
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", minimumBalance=" + minimumBalance
				+ ", CurrentBalance=" + currentBalance + ", intrestRate=" + intrestRate + ", listOfTransactions="
				+ listOfTransactions + ", branchId=" + branchId + "]";
	}

	
	
}
