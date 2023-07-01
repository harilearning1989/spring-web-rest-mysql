package com.web.demo.config.ds;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "libraryEntityManagerFactory",
        transactionManagerRef = "libraryTransactionManager",
        basePackages = { "com.web.demo.batch.repos","com.web.demo.file.repos" })
public class BatchDbConfig {

    @Primary
    @Bean(name="libraryProps")
    @ConfigurationProperties("library.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name="libraryDatasource")
    public DataSource libraryDatasource(@Qualifier("libraryProps") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name="libraryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("libraryDatasource") DataSource dataSource){
        return builder.dataSource(dataSource)
                .packages("com.web.demo.batch.models",
                        "com.web.demo.file.models")
                .build();
    }

    @Primary
    @Bean(name = "libraryTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager libraryTransactionManager(
            @Qualifier("libraryEntityManagerFactory") EntityManagerFactory libraryEntityManagerFactory) {
        return new JpaTransactionManager(libraryEntityManagerFactory);
    }
}
