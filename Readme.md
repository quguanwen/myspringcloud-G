SpringBoot2.1.4+SpringCloud(Greenwich.SR1)

api-gateway服务是zuul网关,可以通过网关统一访问微服务
eureka-server服务是服务注册中心,其余全部为eureka-client
conf-server-3001服务是服务配置中心
consumer-2002服务是Ribbon与Feign服务消费者,并添加了Hystrix提供服务降级,服务熔断等功能
provider-2001服务是Provider服务提供者

