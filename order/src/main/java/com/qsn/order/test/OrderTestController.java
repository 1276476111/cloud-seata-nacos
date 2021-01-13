package com.qsn.order.test;

import com.alibaba.fastjson.JSONObject;
import com.qsn.order.feign.TestFeign;
import com.qsn.order.test.entity.TestEntity;
import com.qsn.order.test.service.TestService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 省了那套吧您内
 *
 * @author qiusn
 *
 * @date 2020 01-0
 */
@RestController
@RequestMapping(value = "api/order/test")
public class OrderTestController {
    @Resource
    private TestService testService;

    @Resource
    private TestFeign testFeign;

    @PostMapping(value = "/test")
    public JSONObject test(@RequestBody JSONObject jsonObject) {
        TestEntity testEntity = new TestEntity();
        testEntity.setAge(100);
        testEntity.setName("哈哈哈哈哈哈哈哈");
        testEntity.setName("嗯嗯");
        testFeign.insert();

        return jsonObject;
    }




}
