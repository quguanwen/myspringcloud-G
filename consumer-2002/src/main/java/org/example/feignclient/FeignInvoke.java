package org.example.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//TODO 指定这个类针对的服务提供者
@FeignClient("provider-2001")
public interface FeignInvoke {

    //TODO 指定远程服务的某个接口本地化
    @GetMapping("/dc")
    String feignMethod();

}
