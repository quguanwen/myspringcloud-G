package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Slf4j

@SpringBootApplication
@EnableDiscoveryClient
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
