package com.jpueyodev.unittest;

import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = com.jpueyodev.DatasourceConfig.class)
@TestPropertySource("classpath:db-test.properties")
public class DatasourceTest {

	@Autowired
	DataSource dataSource;
	
	@Value("${db.driverClass}")
	private String expectedDriver;
	@Value("${db.jdbcUrl}")
	private String expectedUrl;
	@Value("${db.user}")
	private String expectedUser;
	@Value("${db.minPoolSize}")
	private int expectedMin;
	@Value("${db.maxPoolSize}")
	private int expectedMax;
	@Value("${db.maxIdleTime}")
	private int expectedIdle;
	
	@Test
	void checkDataSourceCreation() {
		assertNotNull(dataSource,"DataSource null");
	}
	
	@Test
	void datasourceIsComboPooledDataSource() {
		assertInstanceOf(ComboPooledDataSource.class,dataSource, "Esperando ComboPooledDataSource");
	}
	
	@Test
	void checkConfig() {
		var cpds = (ComboPooledDataSource) dataSource;
		
		//basic
		assertEquals(expectedDriver,cpds.getDriverClass(),"driverClass");
		assertEquals(expectedUrl, cpds.getJdbcUrl(),"jdbcUrl");
		assertEquals(expectedUser, cpds.getUser(),"user");
		
		//pool
		assertEquals(expectedMin, cpds.getMinPoolSize(),"minPoolSize");
		assertEquals(expectedMax, cpds.getMaxPoolSize(),"maxPoolSize");
		assertEquals(expectedIdle, cpds.getMaxIdleTime(),"maxIdleTime");
	}
}
