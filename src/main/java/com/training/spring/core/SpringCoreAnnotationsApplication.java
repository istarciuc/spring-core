package com.training.spring.core;

import com.training.spring.core.dependencyinjection.componentscan.ComponentDAO;
import com.training.spring.core.dependencyinjection.componentscan.ComponentJdbcConnection;
import com.training.spring.core.dependencyinjection.componentscan.LombokComponentJdbcConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.training.spring.core.dependencyinjection.componentscan")
public class SpringCoreAnnotationsApplication {

    @Bean
    public ComponentJdbcConnection jdbcConnection() {
        ComponentJdbcConnection jdbcConnection = new ComponentJdbcConnection("URL", "USER", "PASSWD");
        return jdbcConnection;
    }

    @Bean
    public LombokComponentJdbcConnection lombokComponentJdbcConnection() {
        LombokComponentJdbcConnection lombokComponentJdbcConnection = new LombokComponentJdbcConnection("URL",
                "USER", "PASSWD");
        return lombokComponentJdbcConnection;
    }


    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringCoreAnnotationsApplication.class);
        ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);

        System.out.println(componentDAO);
        System.out.println(componentDAO.getJdbcConnection());
        System.out.println(componentDAO.getLombokComponentJdbcConnection());
    }
}
