package com.cubic.rest.patient.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaderData {
	
	private String contentType;
	private String authKey;
	private String appName;
	private String version;
	
}
