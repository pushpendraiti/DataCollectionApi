package com.info.service;

import java.util.Map;

import com.info.binding.ChildRequest;
import com.info.binding.DcSummary;
import com.info.binding.Education;
import com.info.binding.Income;
import com.info.binding.PlanSelection;

public interface DcService {
	
	public Long loadCaseNum(Integer appId);
	public Map<Integer,String> getPlanNames();

	public Long savePlanSelection(PlanSelection planSelection);
	
	public Long saveIncomeData(Income income);
	public Long saveEducation(Education education);
	public Long saveChildrens(ChildRequest childs);
	public DcSummary getSummary(Long caseNumber);
	
}
