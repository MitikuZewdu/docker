package com.cubic.rest.resources.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import com.cubic.rest.patient.exception.PatientNotFoundException;
import com.cubic.rest.patient.service.ErrorInfo;

@Service
@Provider
public class PatientNotFoundProvider implements ExceptionMapper<PatientNotFoundException> {

	@Override
	public Response toResponse(final PatientNotFoundException exception) {
		final ErrorInfo entity = ErrorInfo.builder().errorCode("ERR-215").errorDesc(exception.getMessage()).build();
		return Response.status(512).entity(entity).build();
	}

}
