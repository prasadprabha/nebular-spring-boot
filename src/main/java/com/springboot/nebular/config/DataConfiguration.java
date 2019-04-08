package com.springboot.nebular.config;

import java.sql.SQLException;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springboot.nebular.repository.data.CustomRepositoryImpl;

@Configuration
@EnableJpaRepositories(basePackages = {"com.springboot.nebular.repository.data"}, repositoryBaseClass = CustomRepositoryImpl.class)
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.springboot.nebular.model.db" })
@EntityScan("com.springboot.nebular.model.db")   
@PropertySource("classpath:/application.yml")
public class DataConfiguration {
	
	   @Value("${spring.datasource.url}")
	    private String url;

	    @Value("${spring.datasource.username}")
	    private String username;
	    
	    @Value("${spring.datasource.driverClassName}")
	    private String driverClassName;

	    @Value("${spring.datasource.password}")
	    private String password;

	    @Value("${spring.datasource.initialSize:1}")
	    private int initialSize;

	   @Value("${spring.datasource.maxActive:3}")
	    private int maxActive;

	   @Value("${spring.datasource.validationQuery:SELECT 1}")
	    private String validationQuery;

	   
	    @Value("${spring.datasource.testWhileIdle:true}")
	    private boolean testWhileIdle;

	    
	    @Value("${spring.datasource.testOnBorrow:true}")
	    private boolean testOnBorrow;

	    
	    @Value("${spring.datasource.timeBetweenEvictionRunsMillis:10000}")
	    private int timeBetweenEvictionRunsMillis;

	    
	    @Value("${spring.datasource.defaultTransactionIsolation:2}")
	    private int defaultTransactionIsolation;

	    
	    @Value("${spring.datasource.minEvictableIdleTimeMillis:600000}")
	    private int minEvictableIdleTimeMillis;

	    
	    @Value("${spring.datasource.defaultReadOnly:false}")
	    private boolean defaultReadOnly;

	    
	    @Value("${spring.datasource.maxIdle:1}")
	    private int maxIdle;

	    
	    @Value("${jpa.hbm2ddl.auto:none}")
	    private String hbm2ddlAuto;

	    
	    @Value("${jpa.show_sql:true}")
	    private boolean showSql;

	    
	    @Value("${jpa.format_sql:true}")
	    private boolean formatSql;

	    @Bean
	    DataSource dataSource() throws SQLException {
	    	BasicDataSource dataSource = new BasicDataSource();
	    	dataSource.setDriverClassName(driverClassName);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	        dataSource.setUrl(url);
	        return dataSource;
	    }
	    
	    @Bean
		@Qualifier("mysqlJdbcTemplate")
		JdbcTemplate jdbcTemplate() throws SQLException {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
			return jdbcTemplate;

		}
	   
	    @Bean(name = "entityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
	            EntityManagerFactoryBuilder builder,
	            @Qualifier("dataSource") DataSource mysqlDataSource) {
	        return builder
	                .dataSource(mysqlDataSource)
	                .packages("com.springboot.nebular.model.db")
	                .persistenceUnit("db")
	                .build();
	    }

	    @Bean
	    public JpaTransactionManager transactionManager(
	            LocalContainerEntityManagerFactoryBean entityManagerFactory) {
	        JpaTransactionManager txnManager = new JpaTransactionManager();
	        txnManager.setEntityManagerFactory(entityManagerFactory.getObject());
	   
	        return txnManager;
	    }
	
}
