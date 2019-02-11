package com.zhubr.order.dto;

import com.zhubr.order.dataobject.OrderDetail;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {
    //    订单ID
    @Id
    private String orderId;

    //    买家的名字
    private String buyerName;

    //    买家手机号
    private String buyerPhone;

    //    买家地址
    private String buyerAddress;

    //    买家微信openid
    private String buyerOpenid;

    //    订单总金额
    private BigDecimal orderAmount;

    //    订单状态, 默认为新下单（0）
    private Integer orderStatus;

    //    支付状态, 默认未支付（0）
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
