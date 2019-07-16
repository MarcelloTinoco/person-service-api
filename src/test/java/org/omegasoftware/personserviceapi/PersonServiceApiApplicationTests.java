package org.omegasoftware.personserviceapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omegasoftware.personserviceapi.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceApiApplicationTests {

	@Autowired
	private Configuration config;
	
	@Test
	public void contextLoads() {
		
	}

	@Test
	public void testConfigurationEnvironment() {
		assertEquals("Test", config.getEnvironment());
	}
	
}
