package com.zhubr.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
    @GetMapping("/getProductMsg")
    public String getProductMsg() {
//        第一种方式
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
        log.info("response={}",response);
    }
}
