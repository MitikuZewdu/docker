package com.cubic.rest.resources.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import com.cubic.rest.patient.service.ErrorInfo;

@Service
@Provider
public class GenericProvider implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(final Exception exception) {
		exception.printStackTrace();
		final ErrorInfo entity = ErrorInfo.builder().errorCode("ERR-001").errorDesc("Error occurred on the server. Please contact admin").build();
		return Response.serverError().entity(entity).build();
	}

}
