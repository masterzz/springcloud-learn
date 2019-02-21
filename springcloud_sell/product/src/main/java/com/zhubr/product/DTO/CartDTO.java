package com.zhubr.product.DTO;

import lombok.Data;

@Data
public class CartDTO {
    //商品id
    private String productId;

    //商品数量
    private Integer productQuantiry;

    public CartDTO(String productId, Integer productQuantiry) {
        this.productId = productId;
        this.productQuantiry = productQuantiry;
    }
}
