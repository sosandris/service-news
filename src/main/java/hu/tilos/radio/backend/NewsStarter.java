package hu.tilos.radio.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableScheduling
public class NewsStarter {

    private static final Logger LOG = LoggerFactory.getLogger(NewsStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(NewsStarter.class, args);

    }

}
