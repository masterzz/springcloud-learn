package com.zhubr.order.service.impl;

import com.zhubr.order.dto.OrderDTO;
import com.zhubr.order.repository.OrderDetailRepository;
import com.zhubr.order.repository.OrderMasterRepository;
import com.zhubr.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
//        TODO 2，查询商品信息（调用商品服务）
//        TODO 3，计算总价
//        TODO 4，扣库存
//         5，订单入库
        return null;
    }
}
