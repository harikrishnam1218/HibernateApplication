package com.hari.hibernate.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	@Primary
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean loFactoryBean=new LocalSessionFactoryBean();
		loFactoryBean.setDataSource(dataSource);
		loFactoryBean.setPackagesToScan("com.hari.hibernate.model");
		loFactoryBean.setHibernateProperties(hibernateProperties());
		return loFactoryBean;
	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show-sql","true");
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hibernateTransactionManager;
		
	}
	
	
	  @Bean public EntityManagerFactory entityManagerFactory() {
	  LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=new
	  LocalContainerEntityManagerFactoryBean();
	  entityManagerFactoryBean.setDataSource(dataSource);
	  entityManagerFactoryBean.setPackagesToScan("com.hari.hibernate.model");
	  HibernateJpaVendorAdapter hjva=new HibernateJpaVendorAdapter();
	  entityManagerFactoryBean.setJpaVendorAdapter(hjva);
	  entityManagerFactoryBean.setJpaProperties(hibernateProperties()); return
	  entityManagerFactoryBean.getObject();
	  
	  }
	 
	
}
