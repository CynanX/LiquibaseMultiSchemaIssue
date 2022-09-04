package uk.co.mark.liquibase.demo;

import java.util.Arrays;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.MultiTenantSpringLiquibase;
import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfiguration {

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:changelog/main-changelog.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

    @Bean
    public MultiTenantSpringLiquibase multiTenantSpringLiquibase(DataSource dataSource) {
        MultiTenantSpringLiquibase multiTenantSpringLiquibase = new MultiTenantSpringLiquibase();
        multiTenantSpringLiquibase.setDataSource(dataSource);

        multiTenantSpringLiquibase.setSchemas(Arrays.asList("demoDbA", "demoDbB"));
        multiTenantSpringLiquibase.setChangeLog("classpath:changelog/main-changelog.xml");
        multiTenantSpringLiquibase.setShouldRun(true);

        return multiTenantSpringLiquibase;
    }

}