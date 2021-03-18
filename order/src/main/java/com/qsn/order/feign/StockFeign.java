package com.qsn.order.feign;

import com.alibaba.fastjson.JSONObject;
import com.qsn.order.test.entity.TestEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 调用库存模块
 *
 * @author iqusn
 * @date 2021-03-09
 */
@FeignClient("stock-service")
@RequestMapping(value = "api/stock")
public interface StockFeign {

    /**
     * 新增数据， 用于测试事务
     */
    @PostMapping(value = "/insert")
    void insert();

    /**
     * 查询集合
     *
     * @param jsonObject
     * @return
     */
    @PostMapping(value = "/list")
    List<TestEntity> list(@RequestBody JSONObject jsonObject);
}
