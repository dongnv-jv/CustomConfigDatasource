package com.example.customconfigdatasource.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "postgrestEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager",
        basePackages = {"com.example.customconfigdatasource.repository.postgres"})
@EnableTransactionManagement
public class DataSourcePostGresConfig {

    @Bean(name="postGresDataSource")
    public DataSource dataSource(){
        HikariConfig hikariConfig= new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/datasource1");
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("root");
        HikariDataSource hikariDataSource= new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }


    @Bean(name="postgrestEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("postGresDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.example.customconfigdatasource.model.postgres");
//        entityManagerFactoryBean.setPersistenceUnitName("BookPojo");
        Properties jpaProperties = new Properties();

        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        jpaProperties.put("spring.jpa.hibernate.ddl-auto","create");

        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
        jpaProperties.put("spring.jpa.hibernate.ejb.naming_strategy","org.hibernate.cfg.ImprovedNamingStrategy");


        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put("spring.jpa.hibernate.show_sql","true");


        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        jpaProperties.put("spring.jpa.hibernate.format_sql","hibernate.format_sql");


        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean(name="postgresTransactionManager")
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
