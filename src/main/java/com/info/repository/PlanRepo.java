package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entity.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Integer> {

}
