package com.cubic.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cubic.rest.patient.service.HeaderData;
import com.cubic.rest.patient.service.PatientData;
import com.cubic.rest.patient.service.PatientSearchResult;
import com.cubic.rest.patient.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Path("/patient")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class PatientResource {

	@Autowired
	@Qualifier("jpaPs")
	private PatientService ps;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "Patient Services Healthy";
	}

	@GET
	@Path("/{patientId}")
	public Response get(@PathParam("patientId") Long patientId) {
		final PatientData entity = ps.get(patientId);
		return Response.ok().entity(entity).build();
	}

	@DELETE
	@Path("/{patientId}")
	public Response remove(@PathParam("patientId") Long patientId) {
		ps.remove(patientId);
		return Response.noContent().build();
	}

	@GET
	@Path("/search")
	public Response search(@QueryParam("fName") final String firstName, @QueryParam("lName") final String lastName) {
		final PatientSearchResult entity = ps.search(firstName, lastName);
		return Response.ok().entity(entity).build();
	}

	@GET
	@Path("/matrix")
	public Response searchByMatrix(@MatrixParam("fName") final String firstName,
			@MatrixParam("lName") final String lastName) {
		final PatientSearchResult entity = ps.search(firstName, lastName);
		return Response.ok().entity(entity).build();
	}

	@GET
	@Path("/header")
	public Response headerInfo(@HeaderParam("Content-Type") final String contentType,
			@HeaderParam("auth-key") final String authKey, @HeaderParam("app-name") final String appName,
			@HeaderParam("version") final String version) {
		final HeaderData entity = HeaderData.builder().appName(appName).authKey(authKey).contentType(contentType)
				.version(version).build();
		return Response.ok().entity(entity).build();
	}

	@GET
	@Path("/hdrContext")
	public Response headerInfo(@Context HttpHeaders httpHeaders) {
		final String contentType = httpHeaders.getHeaderString("Content-Type");
		final String authKey = httpHeaders.getHeaderString("auth-key");
		final String appName = httpHeaders.getHeaderString("app-name");
		final String version = httpHeaders.getHeaderString("version");
		final HeaderData entity = HeaderData.builder().appName(appName).authKey(authKey).contentType(contentType)
				.version(version).build();
		return Response.ok().entity(entity).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Response create(final PatientData patient) {
		log.info("Input Patient Data = {}", patient);
		final PatientData entity = ps.create(patient);
		log.info("Response Patient Data = {}", entity);
		return Response.ok().entity(entity).build();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response modify(final PatientData patient) {
		ps.modify(patient);
		return Response.noContent().build();
	}

}
