package com.india.maheshdemo.bankingserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.india.maheshdemo.bankingserver.dto.BankAccount;
import com.india.maheshdemo.bankingserver.dto.Transaction;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	long transactionId = 1111111;

	@Autowired
	BranchServiceImpl branchService;

	public Double withdraw(double amount, String accountNumber) {
		BankAccount bankAccount = branchService.getAccountByAccountNumber(accountNumber);
		if (bankAccount == null) {
			return 0.0;
		}
		double balance = bankAccount.getCurrentBalance() - amount;
		List<Transaction> transaction = bankAccount.getListOfTransactions();
		if (bankAccount.getTypeOfAccount().equals("SAVING") && balance > 10000) {
			bankAccount.setCurrentBalance(balance);
			transaction.add(new Transaction(++transactionId + "", amount, "withdraw"));
			bankAccount.setListOfTransactions(transaction);
			System.out.println(bankAccount);
		} else if (bankAccount.getTypeOfAccount().equals("CURRENT") && balance > 20000) {
			bankAccount.setCurrentBalance(balance);
			transaction.add(new Transaction(++transactionId + "", amount, "withdraw"));
			bankAccount.setListOfTransactions(transaction);
		} else {
			System.out.println("ERROR - Minimum Balance should be maintained");
			return amount;
		}
		return balance;

	}

	public Double deposit(double amount, String accountNumber) {
		BankAccount bankAccount = branchService.getAccountByAccountNumber(accountNumber);
		List<Transaction> transaction = bankAccount.getListOfTransactions();
		double balance = bankAccount.getCurrentBalance() + amount;
		bankAccount.setCurrentBalance(balance);
		transaction.add(new Transaction(++transactionId + "", amount, "deposit"));
		bankAccount.setListOfTransactions(transaction);
		System.out.println(bankAccount);
		System.out.println(transaction);
		return balance;

	}

	public List<Transaction> getTransactionHistory(String accountNumber) {
		BankAccount bankAccount = branchService.getAccountByAccountNumber(accountNumber);
		return bankAccount.getListOfTransactions();
	}

	public List<Transaction> getMiniStatment() {
		return null;
	} // Mark for check - Mini Statment is same as transaction History

	public Double getMinimumBalance(String accountNumber) {
		BankAccount bankAccount = branchService.getAccountByAccountNumber(accountNumber);
		return bankAccount.getMinimumBalance();
	}

	public Double getCurrentBalance(String accountNumber) {
		BankAccount bankAccount = branchService.getAccountByAccountNumber(accountNumber);
		return bankAccount.getCurrentBalance();
	}

	public Double getIntrestRate(String accountNumber) {
		BankAccount bankAccount = branchService.getAccountByAccountNumber(accountNumber);
		return bankAccount.getIntrestRate();
	}

	public String getTypeOfTransaction() {
		return null; // based on what we need to show transaction tpye here ? so not implemented
	}

}
