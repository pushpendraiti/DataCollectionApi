package com.info.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="DC_CASES")
public class DataCollectionCase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseId;
	private Integer caseNum;
	private Integer appId;
	private Integer planId;
	
}
