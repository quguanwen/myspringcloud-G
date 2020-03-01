package org.example.controller;

import org.example.feignclient.FeignInvoke;
import org.example.hystrixdemo.DcService;
import org.example.streamtest.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.http.RestTemplateTransportClientFactories;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    RestTemplate restTemplate;

    //TODO 这里的ribbon客户端远程调用
    @GetMapping("/ribbon")
    public String dcR() {
        //ribbon可以完成远程调用
        return restTemplate.getForObject("http://provider-2001/dc", String.class);
    }

    //TODO 这里的Feign客户端实现远程调用
    @Autowired
    FeignInvoke feignInvoke;

    @GetMapping("/feign")
    public String dcF() {
        //feign本地接口完成远程调用
        return feignInvoke.feignMethod();
    }

    //TODO 测试一下Hystrix带来的服务降级功能
    @Autowired
    DcService dcService;

    @GetMapping("/hystrix")
    public String dcH(){
        return dcService.masterInvoke();
    }



}
