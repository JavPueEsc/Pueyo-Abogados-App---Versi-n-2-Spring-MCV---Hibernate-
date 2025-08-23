package com.jpueyodev;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class HibernateConfig {

	//Configuración de Hibernate para mapear clases
		
		@Bean
		public LocalSessionFactoryBean sessionFactory(DataSource datasource) {
			var sessionFactory = new LocalSessionFactoryBean();
			sessionFactory.setDataSource(datasource);
			sessionFactory.setPackagesToScan("com.jpueyodev");
			
			var hibernateProps = new Properties();
			hibernateProps.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			hibernateProps.setProperty("hibernate.show_sql", "true");
			hibernateProps.setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
			
			sessionFactory.setHibernateProperties(hibernateProps);
			return sessionFactory;
		}
		
		@Bean
		public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
			var txManager = new HibernateTransactionManager();
			txManager.setSessionFactory(sessionFactory);
			return txManager;
		}
}

