package com.india.maheshdemo.bankingserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.india.maheshdemo.bankingserver.dto.HeadOffice;
import com.india.maheshdemo.bankingserver.service.HeadOfficeService;

@RestController
@RequestMapping("/banking/headoffice/v1/")
public class HeadOfficeController {
	
	@Autowired
	HeadOfficeService headOfficeService;
	
	@PostMapping("createHeadOffice")
	public ResponseEntity<Object> createHeadOffice(@RequestBody HeadOffice headOffice) {
		if(headOffice == null) {
			return new ResponseEntity<Object>(new String("Request Body "+headOffice+" is Null"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(headOfficeService.createHeadOffice(headOffice), HttpStatus.CREATED);
	}
	
	@GetMapping("getHeadoffice")
	public ResponseEntity<Object> getHeadOffice() {
		return new ResponseEntity<Object>(headOfficeService.getHeadOffice(), HttpStatus.OK);
	}

}
