package com.cubic.rest.patient.service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PatientSearchResult {
	
	@Builder.Default
	private List<PatientData> patients = new ArrayList<PatientData>();

}
