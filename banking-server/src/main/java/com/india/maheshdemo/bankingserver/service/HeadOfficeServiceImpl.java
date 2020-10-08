package com.india.maheshdemo.bankingserver.service;

import org.springframework.stereotype.Service;

import com.india.maheshdemo.bankingserver.dto.HeadOffice;

@Service
public class HeadOfficeServiceImpl implements HeadOfficeService{

	HeadOffice mainHeadOffice = null;
	
	@Override
	public HeadOffice createHeadOffice(HeadOffice headOffice) {
		if(headOffice.getBranches().size() > 0)
			mainHeadOffice = new HeadOffice(headOffice.getBranches());
		else
			mainHeadOffice = new HeadOffice();
		System.out.println(" -------------- HEAD OFFICE CREATED -----------");
		return mainHeadOffice;
	}

	@Override
	public HeadOffice getHeadOffice() {
		return mainHeadOffice;
	}

}
