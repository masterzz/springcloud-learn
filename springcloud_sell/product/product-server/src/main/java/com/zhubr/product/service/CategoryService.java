package com.zhubr.product.service;

import com.zhubr.product.dataobject.ProductCategory;

import java.util.List;

//类目
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
