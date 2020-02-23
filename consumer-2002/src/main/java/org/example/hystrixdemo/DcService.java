package org.example.hystrixdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.feignclient.FeignInvoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DcService {

    @Autowired
    RestTemplate restTemplate;

    //TODO 主调用逻辑(用ribbon调用超时接口)
    @HystrixCommand(fallbackMethod = "slaveInvoke")
    public String masterInvoke() {
        return restTemplate.getForObject("http://provider-2001/dcTimeout", String.class);
    }


    @Autowired
    FeignInvoke feignInvoke;

    //TODO 降级逻辑(用feign调用正常的接口)
    public String slaveInvoke() {
        return feignInvoke.feignMethod();
    }

}
