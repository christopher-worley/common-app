package core.commonapp.server.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import core.service.config.ServiceConfiguration;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "core.commonapp.server.service", "core.commonapp.server.dao", "core.commonapp.cache" })
public class ServerConfiguration extends ServiceConfiguration, DataModelConfiguration, ClientConfiguration {

	@Bean
	public DataSource datasource() {
		EmbeddedDatabaseFactoryBean bean = new EmbeddedDatabaseFactoryBean();
		bean.afterPropertiesSet(); 
		return bean.getObject();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(datasource());
		entityManagerFactory.setPackagesToScan(new String[] { "core.data.hibernate" });
		entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
		
		Properties props = new Properties();
		//props.put("hibernate.dialect", " org.hibernate.dialect.H2Dialect");
		props.put("hibernate.hbm2ddl.auto", "create");
		entityManagerFactory.setJpaProperties(props);
		
		entityManagerFactory.afterPropertiesSet();
		return entityManagerFactory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager(
				entityManagerFactory());
		transactionManager.setDataSource(datasource());
		transactionManager.setJpaDialect(new HibernateJpaDialect());
		return transactionManager;
	}

	
}
