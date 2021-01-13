package com.qsn.stock;

import com.qsn.stock.config.YmlConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockApplicationTests {

    @Resource
    private YmlConfig ymlConfig;

    @Test
    public void test1() {
        System.out.println("--------------姓名：" + ymlConfig.getName());
        System.out.println("--------------年龄：" + ymlConfig.getAge());

    }

}
