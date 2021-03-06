package com.zhubr.product.service;

import com.zhubr.product.dto.CartDTO;
import com.zhubr.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {
    //    查询所有在架商品列表
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
