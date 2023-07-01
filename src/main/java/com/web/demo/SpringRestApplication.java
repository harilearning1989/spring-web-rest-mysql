package com.web.demo;

import com.web.demo.aop.aspect.LogExecutionTime;
import com.web.demo.ldap.services.PersonService;
import com.web.demo.property.YamlPropertySourceFactory;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@PropertySources({
        @PropertySource(value = "classpath:spring-web.yaml", factory = YamlPropertySourceFactory.class),
        @PropertySource(value = "classpath:ldap-conf.yaml", factory = YamlPropertySourceFactory.class),
        @PropertySource(value = "classpath:kafka-config.yaml", factory = YamlPropertySourceFactory.class),
}
)
public class SpringRestApplication {

    //https://www.javaguides.net/2021/06/configure-jwt-with-spring-boot-and-swagger.html

    private static Logger log = LoggerFactory.getLogger(SpringRestApplication.class);

    public static void main(String[] args) {
        //SpringApplication.run(SpringRestApplication.class, args);
        SpringApplication app = new SpringApplication(SpringRestApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    private PersonService personService;

    @Autowired
    public SpringRestApplication setPersonService(PersonService personService) {
        this.personService = personService;
        return this;
    }

    @PostConstruct
    public void setup() {
        log.info("Spring LDAP + Spring Boot Configuration Example");

        List<String> names = personService.getAllPersonNames();
        log.info("names: " + names);

        //System.exit(-1);
    }

    @Bean
    @LogExecutionTime
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            //Thread.sleep(100);
            TimeUnit.SECONDS.sleep(5);
        };
    }

}
