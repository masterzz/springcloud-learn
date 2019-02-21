package com.zhubr.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product")   //name 这里表示要访问哪个应用的接口
public interface ProductClient {
    @GetMapping("/msg")
    String productMsg();
}
