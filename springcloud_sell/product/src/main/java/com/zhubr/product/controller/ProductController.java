package com.zhubr.product.controller;

import com.zhubr.product.VO.ProductInfoVO;
import com.zhubr.product.VO.ProductVO;
import com.zhubr.product.VO.ResultVO;
import com.zhubr.product.dataobject.ProductCategory;
import com.zhubr.product.dataobject.ProductInfo;
import com.zhubr.product.service.CategoryService;
import com.zhubr.product.service.ProductService;
import com.zhubr.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
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
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                通过BeanUtils的copy方法可以拷贝属性
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品列表（给订单服务用的）
     *
     * @param productIdList
     * @return
     */
    @GetMapping("listForOrder")
    public List<ProductInfo> listForOrder(List<String> productIdList) {
        return null;
    }
}
