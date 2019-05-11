package com.cubic.rest.patient.service;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class PatientData {
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Gender gender;
}
