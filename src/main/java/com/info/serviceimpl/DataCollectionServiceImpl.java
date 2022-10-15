package com.info.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.binding.ChildrenDetails;
import com.info.binding.EducationDetails;
import com.info.service.DataCollectionService;
@Service
public class DataCollectionServiceImpl implements DataCollectionService {
	
	@Autowired
	private DataCollectionService service;
	
	public String planSelection(Integer caseNum, String planName) {
	
		return null;
	}

	public String educationDetails(EducationDetails eduDetails) {
	
		return null;
	}
	public String childrensDetails(ChildrenDetails childrenDetails) {
		
		return null;
	}

}
