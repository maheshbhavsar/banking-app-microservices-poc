package com.india.maheshdemo.bankingserver.dto;

public class Transaction {

	private String transactionId;
	private double amount;
	private String typeOfTransaction;
	
	public Transaction() {}
	
	public Transaction(String transactionId, double amount, String typeOfTransaction) {
		this.transactionId = transactionId;
		this.amount = amount;
		this.typeOfTransaction = typeOfTransaction;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", typeOfTransaction="
				+ typeOfTransaction + "]";
	}

	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}
	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}
	
	
}
