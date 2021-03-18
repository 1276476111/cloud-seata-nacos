package com.qsn.order.test;

import com.alibaba.fastjson.JSONObject;
import com.qsn.order.feign.StockFeign;
import com.qsn.order.test.entity.TestEntity;
import com.qsn.order.test.service.TestService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 省了那套吧您内
 *
 * @author qiusn
 * @date 2020 01-0
 */
@Api(tags = "测试接口")
@RestController
@RequestMapping(value = "api/order")
public class OrderTestController {
    @Resource
    private TestService testService;

    @Resource
    private StockFeign stockFeign;



}
