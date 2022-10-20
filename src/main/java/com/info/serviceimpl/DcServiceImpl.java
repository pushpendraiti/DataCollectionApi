package com.info.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.binding.Child;
import com.info.binding.DcSummary;
import com.info.binding.Education;
import com.info.binding.Income;
import com.info.binding.PlanSelection;
import com.info.entity.CitizenAppEntity;
import com.info.entity.DcCaseEntity;
import com.info.entity.DcChildrenEntity;
import com.info.entity.DcEducationEntity;
import com.info.entity.DcIncomeEntity;
import com.info.entity.PlanEntity;
import com.info.repository.CitizenAppRepo;
import com.info.repository.DcCaseRepo;
import com.info.repository.DcChildrenRepo;
import com.info.repository.DcEducationRepo;
import com.info.repository.DcIncomeRepo;
import com.info.repository.PlanRepo;
import com.info.service.DcService;
@Service
public class DcServiceImpl implements DcService {
	
	@Autowired
	private DcCaseRepo dcCaseRepo;
	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private DcIncomeRepo dcIncomeRepo;
	@Autowired
	private DcEducationRepo eduRepo;
	@Autowired
	private DcChildrenRepo childRepo;
	@Autowired
	private CitizenAppRepo appRepo;

	@Override
	public Long loadCaseNum(Integer appId) {
		
		Optional<CitizenAppEntity> app = appRepo.findById(appId);
		if(app.isPresent()) {
			DcCaseEntity entity = new DcCaseEntity();
			entity.setAppId(appId);
			entity = dcCaseRepo.save(entity);
			
			return entity.getCaseNum();
		}
		return 0l;
	}

	@Override
	public List<String> getPlanNames() {
		List<PlanEntity> findAll = planRepo.findAll();
		List<String> plans=new ArrayList<>();
		for(PlanEntity entity:findAll) {			
			plans.add(entity.getPlanName());
		}
		return plans;
	}

	@Override
	public Long savePlanSelection(PlanSelection planSelection) {
		
	Optional<DcCaseEntity> findById = dcCaseRepo.findById(planSelection.getCaseNum());
	    if(findById.isPresent()) {
	    	DcCaseEntity dcCaseEntity = findById.get();
	    	dcCaseEntity.setPlanId(planSelection.getPlanId());
	    	dcCaseRepo.save(dcCaseEntity);
	    	return planSelection.getCaseNum();
	    }
		
		return null;
	}

	@Override
	public Long saveIncomeData(Income income) {
		DcIncomeEntity entity = new DcIncomeEntity();
		BeanUtils.copyProperties(income, entity);
		dcIncomeRepo.save(entity);
		
		return income.getCaseNum();
	}

	@Override
	public Long saveEducation(Education education) {
		DcEducationEntity entity = new DcEducationEntity();
		BeanUtils.copyProperties(education, entity);
		eduRepo.save(entity);
		return education.getCaseNum();
	}

	@Override
	public Long saveChildrens(List<Child> childs) {
		
		for(Child c:childs) {
			DcChildrenEntity entity = new DcChildrenEntity();
			BeanUtils.copyProperties(childs, entity);
			childRepo.save(entity);
		}
		return childs.get(0).getCaseNum();
	}

	@Override
	public DcSummary getSummary(Long caseNumber) {
		String planName="";
		DcIncomeEntity incomeEntity = dcIncomeRepo.findByCaseNum(caseNumber);
		DcEducationEntity educationEntity = eduRepo.findByCaseNum(caseNumber);
		List<DcChildrenEntity> childsEntity = childRepo.findByCaseNum(caseNumber);
		Optional<DcCaseEntity> dcCase = dcCaseRepo.findById(caseNumber);
		if(dcCase.isPresent()) {
			Integer planId = dcCase.get().getPlanId();
			Optional<PlanEntity> plan =	planRepo.findById(planId);
			if(plan.isPresent()) {
				planName=plan.get().getPlanName();
			}
		}
		// set the data to summary obj
		DcSummary summary= new DcSummary();
		summary.setPlanName(planName);
		
		Income income = new Income();
		BeanUtils.copyProperties(incomeEntity, income);
		summary.setIncome(income);
		
		Education edu = new Education();
		BeanUtils.copyProperties(educationEntity, edu);
		summary.setEducation(edu);
		
		List<Child> childs = new ArrayList<>();
		for(DcChildrenEntity c:childsEntity) {
			Child ch = new Child();
			BeanUtils.copyProperties(c, ch);
			childs.add(ch);
		}
		summary.setChilds(childs);
		return summary;
	}	

}
