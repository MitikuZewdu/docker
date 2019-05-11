package com.cubic.rest.patient.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cubic.rest.patient.entity.PatientEntity;
import com.cubic.rest.patient.exception.InvalidDataException;
import com.cubic.rest.patient.exception.PatientNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service("jpaPs")
@Transactional
@Slf4j
public class PatientServiceJpaImpl implements PatientService {

	@Autowired
	private EntityManager em;

	@Autowired
	private PatientMapper mapper;

	@Override
	public PatientData get(Long patientId) {
		if (patientId == null)
			throw new IllegalArgumentException("Patient ID is null");
		final PatientEntity entity = em.find(PatientEntity.class, patientId);
		if (entity == null)
			throw new PatientNotFoundException("Patient not in our system");
		return mapper.mapTo(entity);
	}

	@Override
	public PatientData create(PatientData patient) {
		validatePatient(patient);
		log.debug("Entering PatientServiceJpaImpl.create");
		final PatientEntity entity = mapper.mapTo(patient);
		log.debug("Patient Entity = {}", entity);
		em.persist(entity);
		log.debug("Patient Created sucessfully. ID = {}", entity.getId());
		patient.setId(entity.getId());
		log.debug("Exiting PatientServiceJpaImpl.create");
		return patient;
	}

	@Override
	public void modify(PatientData data) {
		PatientEntity entity = getPatientEntity(data.getId());
		entity = mapper.mapTo(data, entity);
		em.persist(entity);
	}

	private PatientEntity getPatientEntity(Long id) {
		PatientEntity entity = em.find(PatientEntity.class, id);
		if (entity == null)
			throw new PatientNotFoundException("Patient not in our system");
		return entity;
	}

	@Override
	public void remove(Long patientId) {
		PatientEntity entity = getPatientEntity(patientId);
		em.remove(entity);
	}

	@Override
	public PatientSearchResult search(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	private void validatePatient(final PatientData patient) {
		if (patient == null || StringUtils.isEmpty(patient.getFirstName()) || StringUtils.isEmpty(patient.getLastName())
				|| patient.getAge() == null || patient.getAge() < 1 || patient.getGender() == null) {
			throw new InvalidDataException("Invalid Data to save patient");
		}
	}

}
