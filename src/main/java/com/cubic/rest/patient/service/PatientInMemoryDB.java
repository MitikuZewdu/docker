package com.cubic.rest.patient.service;

import java.util.HashMap;
import java.util.Map;

public class PatientInMemoryDB {
	final Map<Long, PatientData> patients = new HashMap<Long, PatientData>();

	public PatientData get(final Long id) {
		return patients.get(id);
	}

	public Long create(final PatientData data) {
		data.setId(System.currentTimeMillis());
		patients.put(data.getId(), data);
		return data.getId();
	}

	public void modify(final PatientData data) {
		patients.put(data.getId(), data);
	}

	public Boolean containsKey(Long id) {
		return patients.containsKey(id);
	}
}
