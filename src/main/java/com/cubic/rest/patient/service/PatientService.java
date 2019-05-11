package com.cubic.rest.patient.service;

public interface PatientService {
	PatientData get(final Long patientId);
	PatientData create(final PatientData patient);
	void modify(final PatientData patient);
	void remove(final Long patientId);
	PatientSearchResult search(final String firstName,final String lastName);
}
