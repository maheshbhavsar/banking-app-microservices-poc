package com.india.maheshdemo.bankingserver.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

public class HeadOffice {

	private List<Branch> branches = new ArrayList<Branch>();
	
	public HeadOffice() {}
	
	public HeadOffice(List<Branch> branches) {
		this.branches = branches;
	}

	public void createBranch(Branch branch) {
		branches.add(branch);
	}

	public Optional<Branch> getBranchById(String branchId) {		
		for(Branch branch : branches) {
			if(branch.getBranchId().equals(branchId))
				return Optional.of(branch);
		}
		return Optional.empty();
	}

	public List<Branch> getBranches() {
		return branches;
	}
	
	@Override
	public String toString() {
		return "HeadOffice [branches=" + branches + "]";
	}


}
