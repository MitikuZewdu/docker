package com.cubic.rest.patient.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cubic.rest.patient.exception.InvalidDataException;
import com.cubic.rest.patient.exception.PatientNotFoundException;

@Service("inMemoryPs")
public class PatientServiceInMemoryImpl implements PatientService {

	final Map<Long, PatientData> patients = new HashMap<Long, PatientData>();

	@Override
	public PatientData get(Long patientId) {
		if (patients.containsKey(patientId)) {
			return patients.get(patientId);
		} else {
			throw new PatientNotFoundException("The patient is not found");
		}
	}

	@Override
	public PatientData create(final PatientData patient) {
		validatePatient(patient);
		patient.setId(System.currentTimeMillis());
		patients.put(patient.getId(), patient);
		return patient;

	}

	private void validatePatient(final PatientData patient) {
		if (patient == null || StringUtils.isEmpty(patient.getFirstName()) || StringUtils.isEmpty(patient.getLastName())
				|| patient.getAge() == null || patient.getAge() < 1 || patient.getGender() == null) {
			throw new InvalidDataException("Invalid Data to save patient");
		}
	}

	@Override
	public void modify(PatientData patient) {
		validatePatient(patient);

		if (patient.getId() == null)
			throw new InvalidDataException("ID cannot be null for modify");

		if (patients.containsKey(patient.getId())) {
			patients.put(patient.getId(), patient);
		} else {
			throw new PatientNotFoundException("The patient is not found");
		}
	}

	@Override
	public void remove(Long patientId) {
		if (patients.containsKey(patientId)) {
			patients.remove(patientId);
		} else {
			throw new PatientNotFoundException("The patient is not found");
		}
	}

	@Override
	public PatientSearchResult search(String firstName, String lastName) {
		final PatientSearchResult result = PatientSearchResult.builder().build();
		for (PatientData patient : patients.values()) {
			if ((firstName != null && patient.getFirstName().toUpperCase().startsWith(firstName.toUpperCase()))
					|| (lastName != null && patient.getLastName().toUpperCase().startsWith(lastName.toUpperCase()))) {
				result.getPatients().add(patient);
			}
		}
		return result;
	}

}
