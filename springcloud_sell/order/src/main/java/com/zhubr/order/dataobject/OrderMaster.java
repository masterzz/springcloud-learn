package com.zhubr.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//订单
@Data
@Entity
public class OrderMaster {
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
    private  Integer payStatus;

//    创建时间
    private Date createTime;

//    修改时间
    private Date updateTime;
}
