package com.cubic.rest.resources.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import com.cubic.rest.patient.exception.InvalidDataException;
import com.cubic.rest.patient.service.ErrorInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Provider
@Slf4j
public class InvalidDataProvider implements ExceptionMapper<InvalidDataException> {

	@Override
	public Response toResponse(final InvalidDataException exception) {
		log.error("Exception occurred.Invalid data", exception);
		final ErrorInfo entity = ErrorInfo.builder().errorCode("ERR-100")
				.errorDesc("Invalid data to handle the request").build();
		return Response.status(505).entity(entity).build();
	}

}
