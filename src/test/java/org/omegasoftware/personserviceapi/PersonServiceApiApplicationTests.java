package org.omegasoftware.personserviceapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceApiApplicationTests {

	@Value("${app.environment}")
	private String environment;
	
	@Test
	public void contextLoads() {
		
	}

	@Test
	public void testConfigurationEnvironment() {
		assertEquals("Test", environment);
	}
	
}
