package com.zhubr.product.repository;

import com.zhubr.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void testFind() throws Exception {
        List<ProductInfo> list =  productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(list.size() > 0);

    }
}