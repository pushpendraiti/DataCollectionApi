package com.info.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.info.binding.Income;
import com.info.service.DcService;

@RestController
public class IncomeRestControlller {

	@Autowired
	private DcService service;
	@PostMapping("/income")
	public ResponseEntity<Long> saveIncome(@RequestBody Income income){
		Long caseNum = service.saveIncomeData(income);
		return new ResponseEntity<>(caseNum,HttpStatus.CREATED);
	}
}
