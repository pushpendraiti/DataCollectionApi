package com.info.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entity.DcIncomeEntity;

public interface DcIncomeRepo extends JpaRepository<DcIncomeEntity, Serializable> {
	
	public DcIncomeEntity findByCaseNum(Long caseNum);

	
}
