package org.example.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Slf4j
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${test.myname}")
    String myname;


    @GetMapping("/dc")
    public String dc() {
        String services = "注册中心列表服务(降级服务):" + discoveryClient.getServices();
        log.info(services);
        log.info(myname);
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
