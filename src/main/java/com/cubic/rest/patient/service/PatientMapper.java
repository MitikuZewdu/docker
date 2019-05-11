package com.cubic.rest.patient.service;

import org.springframework.stereotype.Component;

import com.cubic.rest.patient.entity.PatientEntity;

@Component
public class PatientMapper {

	public PatientData mapTo(final PatientEntity entity) {
		return PatientData.builder().age(entity.getAge()).firstName(entity.getFirstName()).gender(entity.getGender())
				.id(entity.getId()).lastName(entity.getLastName()).build();
	}

	public PatientEntity mapTo(final PatientData data, final PatientEntity entity) {
		entity.setAge(data.getAge());
		entity.setFirstName(data.getFirstName());
		entity.setGender(data.getGender());
		entity.setLastName(data.getLastName());
		return entity;
	}

	public PatientEntity mapTo(final PatientData data) {
		return mapTo(data, new PatientEntity());
	}

}
