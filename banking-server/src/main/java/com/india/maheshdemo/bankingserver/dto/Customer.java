package com.india.maheshdemo.bankingserver.dto;

import java.util.List;

import org.springframework.stereotype.Component;

public class Customer {
	
	private String pan;
	private List<BankAccount> listOfBankAccounts;
	
	public Customer() {}
	
	public Customer(String pan, List<BankAccount> listOfBankAccounts) {
		super();
		this.pan = pan;
		this.listOfBankAccounts = listOfBankAccounts;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	@Override
	public String toString() {
		return "Customer [pan=" + pan + ", listOfBankAccounts=" + listOfBankAccounts + "]";
	}

	public List<BankAccount> getListOfBankAccounts() {
		return listOfBankAccounts;
	}
	public void setListOfBankAccounts(List<BankAccount> listOfBankAccounts) {
		this.listOfBankAccounts = listOfBankAccounts;
	}

}
