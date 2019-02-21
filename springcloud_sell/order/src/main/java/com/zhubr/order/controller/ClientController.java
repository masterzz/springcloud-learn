package com.zhubr.order.controller;

import com.zhubr.order.ProductClient;
import com.zhubr.order.dataobject.ProductInfo;
import com.zhubr.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {
//    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Autowired
    private ProductClient productClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
//        1，第一种方式（直接使用restTemplate，url写死）
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//        log.info("response={}",response);
//        2，第二种方式（利用loadBalancerClient通过应用名获取url，然后再使用restTemplate）
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        serviceInstance.getHost();
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);

//        3，第三种方式（利用@LoadBalancerClient，可在restTemplate里使用应用名字）
//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
//        log.info("response={}",response);
        return response;
    }

//    Feign方式
    @GetMapping("/getProductMsg1")
    public String getProductMsg1() {
        String response = productClient.productMsg();
        log.info("response={}",response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfos = productClient.listForOrder(Arrays.asList("164103465734242707"));
        log.info("response={}",productInfos);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707",3)));
        return "ok";
    }
}
