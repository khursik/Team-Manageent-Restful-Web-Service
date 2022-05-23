package ru.sbt.restfulwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestfulWebServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestfulWebServiceApplication.class, args);
    }

}
