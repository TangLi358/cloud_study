package com.atgugu.springcloud.controller;

import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //直接调用
//    public static  final String PAYMENT_URL = "http://localhost:8001";

    //需要开启RestTemplate的负载均衡能力 把指定的服务地址 换成微服务的名称
    @LoadBalanced
    public static final String PAYMENT_URL = "http://CLOUD_PAYMENT_SERVICE";

    @Resource
    private RestTemplate restTemplate;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        System.out.println("test");
        CommonResult<Payment> result = restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        return result;
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult test(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        return result;
    }

}
