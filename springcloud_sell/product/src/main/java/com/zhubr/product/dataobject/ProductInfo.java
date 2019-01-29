package com.zhubr.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//有了lombok之后，不用getter、setter，只要有个@Data就可以生成getter、setter
@Data
//@Table(name = "T_xxx")
@Entity
public class ProductInfo {
    @Id
    /* id*/
    private String productId;

    //    商品名称
    private String productName;

    //    单价
    private BigDecimal productPrice;

    //    库存
    private Integer productStock;

    //    描述
    private String productDescription;

    //    小图
    private String productIcon;

    //    商品状态
    private Integer productStatus;

    //    类目编号
    private Integer categoryType;

    //    创建时间
    private Date createTime;

    //    修改时间
    private Date updateTime;
}
