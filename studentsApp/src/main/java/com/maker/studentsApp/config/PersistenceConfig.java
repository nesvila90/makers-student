package com.maker.studentsApp.config;


import com.maker.studentsApp.domain.enums.core.DeployType;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * The type Persistence config.
 */
@Log4j2
@Configuration
@EnableJpaAuditing
@EnableConfigurationProperties
public class PersistenceConfig {

    /**
     * Datasource properties datasource configuration.
     *
     * @return the datasource configuration
     */
    @Bean
    @ConfigurationProperties(value = "spring.datasource.primary")
    public DatasourceConfiguration datasourceProperties() {
        return new DatasourceConfiguration();
    }


    /**
     * Datasource configuration data source.
     *
     * @return the data source
     */
    @Bean
    @Profile({DeployType.DEVELOP, DeployType.TEST, DeployType.QA, DeployType.PRODUCTION})
    public DataSource datasourceConfiguration() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        if (log.isDebugEnabled())
            log.info("Datasource Connection Properties: {}", datasourceProperties().toString());

        dataSource.setUrl(datasourceProperties().url);
        dataSource.setUsername(datasourceProperties().username);
        dataSource.setPassword(datasourceProperties().password);
        dataSource.setSchema(datasourceProperties().schema);
        return dataSource;
    }


    @Data
    @Getter
    @ToString
    private static class DatasourceConfiguration {
        private String url;
        private String username;
        private String password;
        private String driver;
        private String driverClassName;
        private String maxActive;
        private String maxIdle;
        private String minIdle;
        private String initialSize;
        private String removeAbandoned;
        private String schema;

    }

}
