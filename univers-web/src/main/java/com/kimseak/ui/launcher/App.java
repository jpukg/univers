package com.kimseak.ui.launcher;

import org.hibernate.service.spi.InjectService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by kimseak on 5/25/17.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.kimseak"})
@EnableJpaRepositories({"com.kimseak"})
@EntityScan({"com.kimseak"})
public class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
    public void init(){
        System.out.println("This is the spring init");
    }
}
