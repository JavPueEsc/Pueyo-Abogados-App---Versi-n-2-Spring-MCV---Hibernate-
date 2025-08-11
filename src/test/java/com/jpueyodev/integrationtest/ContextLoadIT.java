package com.jpueyodev.integrationtest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.jpueyodev.AppConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class ContextLoadIT {

	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Test
	void contextLoads() {
		assertNotNull(webApplicationContext);
	}
	
	@Test
    void viewResolverBeanExists() {
        assertTrue(webApplicationContext.containsBean("viewResolver"));
    }
}


