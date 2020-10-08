package com.india.maheshdemo.bankingserver.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.india.maheshdemo.bankingserver.dto.BankAccount;
import com.india.maheshdemo.bankingserver.dto.Branch;
import com.india.maheshdemo.bankingserver.dto.Customer;
import com.india.maheshdemo.bankingserver.requestdto.BankAccountRequestDTO;
import com.india.maheshdemo.bankingserver.service.BranchService;

@RestController
@RequestMapping("/banking/branch/v1/")
public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@PostMapping("createBranch")
	public ResponseEntity<Object> createBranch(@RequestBody Branch branch){
		if(branch == null) {
			return new ResponseEntity<Object>(new String("branch should not be null"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(branchService.createBranch(branch), HttpStatus.CREATED);		
	}
	
	@GetMapping("getBranch/{branchId}")
	public ResponseEntity<Object> getBranch(@PathVariable("branchId") String branchId){
		return new ResponseEntity<Object>(branchService.getBranch(branchId), HttpStatus.OK);		
	}
	
	@PostMapping("createBankAccount")
	public ResponseEntity<String> createBankAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
		return new ResponseEntity<String>(branchService.createBankAccount(bankAccountRequestDTO.getPanNumber(), bankAccountRequestDTO.getType(), 
				bankAccountRequestDTO.getAmount(), bankAccountRequestDTO.getBranchId()), HttpStatus.CREATED);
	}
	
	@PostMapping("createCustomer/{branchId}")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer, @PathVariable("branchId") String branchId) {
		return new ResponseEntity<Object>(branchService.createCustomer(customer, branchId), HttpStatus.CREATED);
	}
	
	@GetMapping("getBankAccounts/{branchId}")
	public ResponseEntity<List<BankAccount>> getBankAccountsFromBranch(@PathVariable("branchId") String branchId){
		return new ResponseEntity<List<BankAccount>>(branchService.getBankAccountsFromBranch(branchId), HttpStatus.OK);		
	}
	
	
}
