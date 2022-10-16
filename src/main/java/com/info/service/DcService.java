package com.info.service;

import java.util.List;

import com.info.binding.Child;
import com.info.binding.DcSummary;
import com.info.binding.Education;
import com.info.binding.Income;
import com.info.binding.PlanSelection;

public interface DcService {
	
	public Long loadCaseNum(Integer appId);
	public List<String> getPlanNames();

	public Long savePlanSelection(PlanSelection planSelection);
	
	public Long saveIncomeData(Income income);
	public Long saveEducation(Education education);
	public Long saveChildrens(List<Child> childs);
	public DcSummary getSummary(Long caseNumber);
	
}
