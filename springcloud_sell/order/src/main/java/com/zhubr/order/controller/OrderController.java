package com.zhubr.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class OrderController {
    /**
     * 1,参数校验
     * 2，查询商品信息（调用商品服务）
     * 3，计算总价
     * 4，扣库存
     * 5，订单入库
     */

    public void create() {

    }
}
