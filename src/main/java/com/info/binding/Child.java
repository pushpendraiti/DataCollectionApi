package com.info.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Child {
	
	private Integer childId;
	private Long caseNum;
	private LocalDate childDob;
	private Long childSsn;
}
