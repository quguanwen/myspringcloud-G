package org.example.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "注册中心列表服务(降级服务):" + discoveryClient.getServices();
        log.info(services);
        return services;
    }

    @GetMapping("/dcTimeout")
    public String dcTimeout() throws InterruptedException {
        Thread.sleep(5000L);
        String services = "注册中心列表服务:" + discoveryClient.getServices();
        log.info(services);
        return services;
    }
}
