package com.zhubr.product.service;

import com.zhubr.product.ProductApplicationTests;
import com.zhubr.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceTest extends ProductApplicationTests {
    @Autowired
    ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertTrue(upAll.size() > 0);
    }

    @Test
    public void findList() throws Exception {
        List<ProductInfo> upAll = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(upAll.size() > 0);
    }
}