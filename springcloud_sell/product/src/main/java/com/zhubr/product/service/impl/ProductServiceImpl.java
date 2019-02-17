package com.zhubr.product.service.impl;

import com.zhubr.product.DTO.CartDTO;
import com.zhubr.product.dataobject.ProductInfo;
import com.zhubr.product.enums.ProductStatusEnum;
import com.zhubr.product.repository.ProductInfoRepository;
import com.zhubr.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return  productInfoRepository.findByProductIdIn(productIdList);

    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = productInfoRepository.findById(cartDTO.getProductId());
            if(!productInfo.isPresent()) {

            }
        }
    }
}
