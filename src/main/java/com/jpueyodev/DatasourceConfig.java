package com.jpueyodev;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DatasourceConfig {

	@Value("${db.driverClass}")
	private String driverClass;
	@Value("${db.jdbcUrl}")
	private String jdbcUrl;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	@Value("${db.minPoolSize}")
	private int minPoolSize;
	@Value("${db.maxPoolSize}")
	private int maxPoolSize;
	@Value("${db.maxIdleTime}")
	private int maxIdleTime;
	
	//DataSource and poll configuration.
		@Bean(destroyMethod="close")
		public DataSource myDataSource() {
			var datasource = new ComboPooledDataSource();
			try {
				datasource.setDriverClass(driverClass);
			}catch(Exception e) {
				throw new RuntimeException("No se pudo cargar el driver JDBC de MySQL",e);
			}
			
			datasource.setJdbcUrl(jdbcUrl);
			datasource.setUser(user);
			datasource.setPassword(password);
			
			//pool
			datasource.setMinPoolSize(minPoolSize);
			datasource.setMaxPoolSize(maxPoolSize);
			datasource.setMaxIdleTime(maxIdleTime);
			
			return datasource;
		}
	
}
