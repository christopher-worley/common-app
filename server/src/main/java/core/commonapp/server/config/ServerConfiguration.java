package core.commonapp.server.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import core.commonapp.client.config.ClientConfiguration;
import core.data.config.DataModelConfiguration;
import core.service.config.ServiceConfiguration;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "core.commonapp.server.service", "core.commonapp.server.dao", "core.commonapp.server.cache" })
@PropertySource({"classpath:/commonapp/commonapp-${RUNTIME:dev}.properties"})
@Import({ServiceConfiguration.class, DataModelConfiguration.class, ClientConfiguration.class})
public class ServerConfiguration {

	/**  logger for this class */
	private static final Logger logger = LoggerFactory.getLogger(ServerConfiguration.class);
	
	/** properties for runtime environment */
	@Autowired
	private Environment env;
	
	
	public ServerConfiguration() {
		super();
	}

	@Bean
	public DataSource datasource() {
		logger.info("Using: " + env.getProperty("description"));

		String choice = env.getProperty("database.choice");
				
		if ("postgres".equals(choice)) {
			return postgresDatasource();
		} else if ("hsql".equals(choice)) {
			return embeddedDatasource();
		}
		throw new IllegalArgumentException("Invalid database choice: " + choice);
	}
	
	public DataSource embeddedDatasource() {
		EmbeddedDatabaseFactoryBean bean = new EmbeddedDatabaseFactoryBean();
		bean.afterPropertiesSet(); 
		return bean.getObject();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(datasource());
		entityManagerFactory.setPackagesToScan(new String[] { "core.data.model.jpa" });
		entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
		
		// build dialect property key with choice value
		String dialect = env.getProperty("database." + env.getProperty("database.choice") + ".dialect");
		
		Properties props = new Properties();
		props.put("hibernate.dialect", dialect);
		props.put("hibernate.hbm2ddl.auto", "create");
		entityManagerFactory.setJpaProperties(props);
		
		entityManagerFactory.afterPropertiesSet();
		return entityManagerFactory.getObject();
	}
	
	public DriverManagerDataSource postgresDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("database.postgres.driver"));
		dataSource.setUrl(env.getProperty("database.postgres.url"));
		dataSource.setUsername(env.getProperty("database.postgres.username"));
		dataSource.setPassword(env.getProperty("database.postgres.password"));
		
		return dataSource;
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
