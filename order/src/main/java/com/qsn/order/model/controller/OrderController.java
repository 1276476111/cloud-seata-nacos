package com.qsn.order.model.controller;


import com.alibaba.fastjson.JSONObject;
import com.qsn.order.feign.StockFeign;
import com.qsn.order.model.entity.Order;
import com.qsn.order.model.service.OrderService;
import com.qsn.order.test.entity.TestEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.async.AsyncLoggerContextSelector;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 前端控制器
 *
 * @author qiusn
 * @date 2021-01-08
 */
@Api(tags = "接口所在的类")
@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {


    @Resource
    private OrderService orderService;
    @Resource
    private StockFeign stockFeign;

    @ApiOperation(value = "库存列表", notes = "通过feign调用查询库存列表", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "length", value = "参数1", required = true, paramType = "path"),
            @ApiImplicitParam(name = "size", value = "参数2", required = true, paramType = "query"),
            @ApiImplicitParam(name = "page", value = "参数3", required = true, paramType = "header"),
            @ApiImplicitParam(name = "total", value = "参数4", required = true, paramType = "form"),
            @ApiImplicitParam(name = "start", value = "参数5", dataType = "string", paramType = "body")
    })
    @PostMapping(value = "/list")
    public List<Order> list(@RequestBody TestEntity testEntity) {
        log.debug("debug请求参数为：【{}】", JSONObject.toJSONString(testEntity));
        log.info("info请求参数为：【{}】", JSONObject.toJSONString(testEntity));
        log.error("error请求参数为：【{}】", JSONObject.toJSONString(testEntity));

        log.info("是否为异步日志：{}", AsyncLoggerContextSelector.isSelected());
        // 调用stock查询
//        List<TestEntity> testEntityList = stockFeign.list(new JSONObject());
        // 订单查询
        List<Order> orderList = orderService.listOrder(new Order());

        return orderList;
    }

    @ApiOperation(value = "新增订单与库存", notes = "用于测试seata分布式事务", httpMethod = "POST")
    @PostMapping(value = "/insert")
    public List<TestEntity> insert() {
        orderService.seataInsert();
        return null;
    }

    @PostMapping(value = "/test")
    public JSONObject test(@RequestBody JSONObject jsonObject) {
        TestEntity testEntity = new TestEntity();
        testEntity.setAge(100);
        testEntity.setName("哈哈哈哈哈哈哈哈");
        testEntity.setName("嗯嗯");
        stockFeign.insert();
        return jsonObject;
    }

}
