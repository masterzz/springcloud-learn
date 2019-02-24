package com.zhubr.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTests {

    @Test
    public void contextLoads() {
        int i = 5;
        switch (i) {
            case 6:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println("default");
//                如果不写break，后面的代码照样会运行，也就是说都是入口
                break;
            case 3:
                System.out.println(5);
                break;
        }
    }

}

