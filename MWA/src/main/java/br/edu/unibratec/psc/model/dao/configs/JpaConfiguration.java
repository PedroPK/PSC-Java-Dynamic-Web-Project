package br.edu.unibratec.psc.model.dao.configs;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.edu.unibratec.psc.model.dao")
public class JpaConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		JpaVendorAdapter	jpaVendorAdapter	=	new HibernateJpaVendorAdapter();
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(			getDataSource());
		emf.setPackagesToScan(		"br.edu.unibratec.psc.model.entity");
		emf.setJpaVendorAdapter(	jpaVendorAdapter);
		emf.setJpaProperties(		getAdditionalProperties());
		
		return emf;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		
		/*
		 * To avoid the problem of Table Not Found on SQL Statement
		 *  - Use this URL:
		 *   -=- jdbc:h2:mem:SpringData;DB_CLOSE_DELAY=-1
		 *   
		 * javax.persistence.PersistenceException 
		 * org.hibernate.exception.SQLGrammarException 
		 * org.h2.jdbc.JdbcSQLException 
		 * 
		 * https://stackoverflow.com/questions/5763747/h2-in-memory-database-table-not-found
		 */
		dataSource.setUrl("jdbc:h2:mem:SpringData;DB_CLOSE_DELAY=-1");
		
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	public PlatformTransactionManager getTransactionManager( EntityManagerFactory pEMF ) {
		JpaTransactionManager	jpaTM	=	new JpaTransactionManager();
		jpaTM.setEntityManagerFactory(pEMF);
		
		return jpaTM;
	}
	
	public Properties getAdditionalProperties() {
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.hbm2ddl.auto",	"create	"							);
		properties.setProperty("hibernate.dialect",			"org.hibernate.dialect.H2Dialect"	);
		properties.setProperty("hibernate.show_sql",		"true"								);
		properties.setProperty("hibernate.format_sql",		"true"								);
		
		return properties;
	}
	
}