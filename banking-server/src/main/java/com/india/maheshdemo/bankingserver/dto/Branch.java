package com.india.maheshdemo.bankingserver.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

public class Branch {

	private String branchId;
	private List<Customer> customers;
	private List<BankAccount> listOfBankAccounts;
	
	public Branch() {
		this.customers = new ArrayList<Customer>();
		this.listOfBankAccounts = new ArrayList<BankAccount>();

	}
	
	public Branch(String branchId, List<Customer> customers, List<BankAccount> listOfBankAccounts) {
		this.branchId = branchId;
		this.customers = customers;
		this.listOfBankAccounts = listOfBankAccounts;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<BankAccount> getListOfBankAccounts() {
		return listOfBankAccounts;
	}

	public void setListOfBankAccounts(List<BankAccount> listOfBankAccounts) {
		this.listOfBankAccounts = listOfBankAccounts;
	}
	
	
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", customers=" + customers + ", listOfBankAccounts="
				+ listOfBankAccounts + "]";
	}
}

