package com.cubic.rest.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cubic.rest.patient.service.Gender;

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
@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "patientSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "patientSeq", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "AGE")
	private Integer age;
	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender;

}
