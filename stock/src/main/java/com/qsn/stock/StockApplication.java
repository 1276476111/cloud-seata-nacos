package com.qsn.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication(scanBasePackages = {"com.qsn.stock"}, exclude = DataSourceAutoConfiguration.class)
//@EnableDiscoveryClient
//// 开启 Feign 客户端
//@EnableFeignClients

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan("com.qsn.stock.test.mapper")
//@EnableFeignClients
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

}
