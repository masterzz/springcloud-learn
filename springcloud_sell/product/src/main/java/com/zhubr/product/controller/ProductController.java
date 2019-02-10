package com.zhubr.product.controller;

import com.zhubr.product.VO.ProductVO;
import com.zhubr.product.VO.ResultVO;
import com.zhubr.product.dataobject.ProductCategory;
import com.zhubr.product.dataobject.ProductInfo;
import com.zhubr.product.service.CategoryService;
import com.zhubr.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1，查询所有在架商品
     * 2，获取类目type列表
     * 3，查询类目
     * 4，构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
//        1，查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
//        2，获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream().
                map(ProductInfo::getCategoryType).collect(Collectors.toList());
//        3，从数据库中查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
//        4，构造数据
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        for(ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
        }
        return null;
    }
}
