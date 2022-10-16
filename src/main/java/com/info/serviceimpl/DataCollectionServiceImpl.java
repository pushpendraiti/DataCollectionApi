package com.info.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.binding.Child;
import com.info.binding.DcSummary;
import com.info.binding.Education;
import com.info.binding.Income;
import com.info.binding.PlanSelection;
import com.info.service.DcService;
@Service
public class DataCollectionServiceImpl implements DcService {
	
	@Autowired
	private DcService service;

	@Override
	public Long loadCaseNum(Integer appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long savePlanSelection(PlanSelection planSelection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveIncomeData(Income income) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveEducation(Education education) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveChildrens(List<Child> childs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DcSummary getSummary(Long caseNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
