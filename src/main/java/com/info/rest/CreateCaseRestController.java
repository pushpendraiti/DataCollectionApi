package com.info.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.info.binding.CreateCaseResponse;
import com.info.service.DcService;

@RestController
public class CreateCaseRestController {
	
	@Autowired
	private DcService service;
	@GetMapping("/case/{appId}")
	public ResponseEntity<CreateCaseResponse> createCase(@PathVariable Integer appId){
		
		Long caseNum=service.loadCaseNum(appId);
		Map<Integer,String> planMaps = service.getPlanNames();
		CreateCaseResponse response=new CreateCaseResponse();
		response.setCaseNum(caseNum);
		response.setPlanNames(planMaps);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
