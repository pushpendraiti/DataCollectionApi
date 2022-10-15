package com.info.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="DC_EDUCATION")
public class DataCollectionEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eduId;
	private Integer caseNum;
	private String highestQualification;
	private Integer gradutionYear;
}
