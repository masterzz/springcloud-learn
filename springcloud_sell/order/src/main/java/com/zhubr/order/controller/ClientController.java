package com.zhubr.order.controller;

import com.zhubr.order.ProductClient;
import com.zhubr.order.dataobject.ProductInfo;
import com.zhubr.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
//        1，第一种方式
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//        log.info("response={}",response);

//       2，第二种方式
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);
//        log.info("response={}",response);
//        3，第三种方式
        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);

        return response;
    }

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
