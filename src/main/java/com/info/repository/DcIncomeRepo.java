package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entity.DcIncomeEntity;

public interface DcIncomeRepo extends JpaRepository<DcIncomeEntity, Integer> {

}
