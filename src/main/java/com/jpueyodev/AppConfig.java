package com.jpueyodev;

import javax.sql.DataSource;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.jpueyodev")
public class AppConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		var resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**")
	            .addResourceLocations("/resources/");
	}
	
	//DataSource and poll configuration.
	@Bean(destroyMethod="close")
	public DataSource myDataSource() {
		var datasource = new ComboPooledDataSource();
		try {
			datasource.setDriverClass("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			throw new RuntimeException("No se pudo cargar el driver JDBC de MySQL",e);
		}
		
		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/pueyoabogados_db?sslMode=DISABLED&allowPublicKeyRetrieval=true&serverTimezone=UTC");
		datasource.setUser("themis");
		datasource.setPassword("...AndJusticeforAll1988");
		
		//pool
		datasource.setMinPoolSize(5);
		datasource.setMaxPoolSize(20);
		datasource.setMaxIdleTime(300);
		
		return datasource;
	}
	
	
}

