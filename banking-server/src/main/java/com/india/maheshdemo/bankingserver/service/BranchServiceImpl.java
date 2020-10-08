package com.india.maheshdemo.bankingserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.india.maheshdemo.bankingserver.dto.BankAccount;
import com.india.maheshdemo.bankingserver.dto.Branch;
import com.india.maheshdemo.bankingserver.dto.CurrentAccount;
import com.india.maheshdemo.bankingserver.dto.Customer;
import com.india.maheshdemo.bankingserver.dto.HeadOffice;
import com.india.maheshdemo.bankingserver.dto.SavingAccount;
import com.india.maheshdemo.bankingserver.dto.Transaction;

@Service
public class BranchServiceImpl implements BranchService{
	
	long tempAccount = 987654321;
	
	@Autowired
	HeadOfficeService headOfficeService;
	
	@Override
	public String createBankAccount(String panNumber, String type, double amount, String branchId) {
		HeadOffice headOffice = headOfficeService.getHeadOffice();
		Optional<Branch> branch = headOffice.getBranchById(branchId);
		Customer cust = branch.get().getCustomers().stream().filter(s -> s.getPan().equals(panNumber)).findAny().get();
		if(cust == null) {
			return "Please Create Customer Profile first";
		}
		if(branch.isPresent()) {
		List<BankAccount> list = branch.get().getListOfBankAccounts();
		BankAccount bankAccount = null;
		if(type.equals("SAVING")) {
			if(amount > 10000) {
				bankAccount = new SavingAccount(++tempAccount+"", 10000, amount, 4.5, new ArrayList<Transaction>(), branchId);
				list.add(bankAccount);
				branch.get().setListOfBankAccounts(list);
				cust.setListOfBankAccounts(list);
				System.out.println(branch);
			}else {
				System.out.println("Minimum Amount of Saving Account should be greater than 10K");
				return "Minimum Amount of Saving Account should be greater than 10K";
			}
		}else if(type.equals("CURRENT")) {
			if(amount > 20000) {
				bankAccount = new CurrentAccount(++tempAccount+"", 20000, amount, 0, new ArrayList<Transaction>(), branchId);
				list.add(bankAccount);
				branch.get().setListOfBankAccounts(list);
				cust.setListOfBankAccounts(list);
			}else {
				System.out.println("Minimum Amount of Current Account should be greater than 20K");
				return "Minimum Amount of Current Account should be greater than 20K";
			}
		}else {
			System.out.println("Account Type is INVALID");
			return "Account Type is INVALID";
		}
		return "Account is Created in Branch "+ branchId +" and of Type "+ type +"";
		}
		return "Branch "+ branchId +" is not present in HeadOffice";
		
	   }

	@Override
	public Customer getCustomerByPanNumber(String panNumber) {
		HeadOffice headOffice = headOfficeService.getHeadOffice();
		List<Branch> list = headOffice.getBranches();
		for (Branch branch : list) {
			List<Customer> customers = branch.getCustomers();
			for (Customer cust : customers) {
				if (cust.getPan().equals(panNumber)) {
					return cust;
				}
			}
		}

		return null;
	}

	@Override
	public BankAccount getAccountByAccountNumber(String accountNumber) {
		HeadOffice headOffice = headOfficeService.getHeadOffice();
		List<Branch> list = headOffice.getBranches();
		for (Branch branch : list) {
			List<BankAccount> bankAccounts = branch.getListOfBankAccounts();
			for (BankAccount account : bankAccounts) {
				if (account.getAccountNumber().equals(accountNumber)) {
					return account;
				}
			}
		}
		return null;
	}


	@Override
	public String createBranch(Branch branch) {
		HeadOffice headOffice = headOfficeService.getHeadOffice();
		if(headOffice == null) {
			return "HeadOffice not Present to create this branch";
		}
		Optional<Branch> existingBranch = headOffice.getBranchById(branch.getBranchId());
		if(!existingBranch.isPresent()){
			headOffice.createBranch(branch);
			return "Branch Created Successfully";
		}
		return "Branch Already Present";
	}


	@Override
	public Branch getBranch(String branchId) {
		HeadOffice headOffice = headOfficeService.getHeadOffice();
		List<Branch> list = headOffice.getBranches();
		for(Branch branch : list) {
		Optional<Branch> existingBranch = headOffice.getBranchById(branchId);
		if(existingBranch.isPresent()){
			return existingBranch.get();
		}
		}
		return null;
	}


	@Override
	public List<BankAccount> getBankAccountsFromBranch(String branchId) {
		HeadOffice headOffice = headOfficeService.getHeadOffice();
		Optional<Branch> branch = headOffice.getBranchById(branchId);
		List<BankAccount> list = null;
		if(branch.isPresent()) {
			list = branch.get().getListOfBankAccounts();
		}
		if(list.size() > 0) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public Customer createCustomer(Customer customer, String branchId) {
		Branch branch = getBranch(branchId);
		List<Customer> listCust = branch.getCustomers();
		if(listCust.size() > 0) {
		for (Customer cust : listCust) {
			if(cust.getPan().equals(customer.getPan())){
				System.out.println("Customer Already Present");
				return cust;
			}
		 }
		}
			listCust.add(customer);
			branch.setCustomers(listCust);
			System.out.println("Customer created and Assinged to branch.");
		return customer;
	}

}
