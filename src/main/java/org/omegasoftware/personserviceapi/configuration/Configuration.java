package org.omegasoftware.personserviceapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Configuration {

	@Value("${app.environment}")
	public String environment;
	
	@Value("${app.max-results-per-page}")
	public int maxResultsPerPage;
	
	
}
