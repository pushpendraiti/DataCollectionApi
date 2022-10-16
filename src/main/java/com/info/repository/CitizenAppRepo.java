package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entity.CitizenAppEntity;

public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity, Integer> {

}
