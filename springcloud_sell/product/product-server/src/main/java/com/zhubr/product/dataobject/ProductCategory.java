package com.zhubr.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer  categoryId;

//    类目名字
    private String categoryName;

//    类目编号
    private Integer categoryType;

//    创建时间
    private Date createTime;

//    修改时间
    private Date update_time;
}

