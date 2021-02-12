package com.varun.socialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EntityScan("com.varun.socialmedia.domain")
@EnableJpaRepositories("com.varun.socialmedia.repository")
@SpringBootApplication
public class SocialmediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialmediaApplication.class, args);
    }

}
