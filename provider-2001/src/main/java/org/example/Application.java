package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.streamtest.ISendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;

import javax.annotation.processing.Processor;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(value = {ISendService.class}) //TODO 绑定创建的通道
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
