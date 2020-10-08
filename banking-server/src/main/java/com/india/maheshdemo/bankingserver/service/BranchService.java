package com.india.maheshdemo.bankingserver.service;

import java.util.List;

import com.india.maheshdemo.bankingserver.dto.BankAccount;
import com.india.maheshdemo.bankingserver.dto.Branch;
import com.india.maheshdemo.bankingserver.dto.Customer;

public interface BranchService {
	
	public String createBankAccount(String panNumber, String type, double amount, String branchId);
	
	public Customer getCustomerByPanNumber(String panNumber);
	
	public BankAccount getAccountByAccountNumber(String accountNumber);
	
	public String createBranch(Branch branch);
	
	public Branch getBranch(String branchId);
	
	public List<BankAccount> getBankAccountsFromBranch(String branchId);
	
	public Customer createCustomer(Customer customer, String branchId);
		

}
