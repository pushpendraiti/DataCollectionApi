package com.info.service;

import com.info.binding.EducationDetails;

public interface DataCollectionService {

	public String planSelection(Integer caseNum,String planName);
	
	public String educationDetails(EducationDetails eduDetails);
	
}
