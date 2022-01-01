package com.github.ivaninkv.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FlightsMetaSubscriberApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightsMetaSubscriberApplication.class, args);
    }

}
