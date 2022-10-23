package com.info.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.info.binding.ChildRequest;
import com.info.binding.DcSummary;
import com.info.service.DcService;

@RestController
public class ChildRestController {

	@Autowired
	private DcService service;

	@PostMapping("/childrens")
	public ResponseEntity<DcSummary> saveChild(@RequestBody ChildRequest req) {
		
		Long caseNum = service.saveChildrens(req);
		
		DcSummary summary = service.getSummary(caseNum);
		
		return new ResponseEntity<>(summary, HttpStatus.OK);
	}
}
