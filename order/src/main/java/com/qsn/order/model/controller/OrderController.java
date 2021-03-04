package com.qsn.order.model.controller;


import com.alibaba.fastjson.JSONObject;
import com.qsn.order.feign.TestFeign;
import com.qsn.order.model.service.OrderService;
import com.qsn.order.test.entity.TestEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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

//    /**
//     * 分页
//     *
//     * @param pageForm 分页参数及查询条件
//     * @return 分页信息
//     */
//    @PostMapping("/order/listPage")
//    public JSONObject listPageOrder(@RequestBody PageForm<Order> pageForm){
//        PageData<Order> page = orderService.listPageOrder(pageForm);
//        return Result.success(page);
//    }
//
//    /**
//     * 列表
//     *
//     * @param order 查询条件
//     * @return 列表信息
//     */
//    @PostMapping("/order/list")
//    public Result listOrder(@RequestBody Order order) {
//        List<Order> list = orderService.listOrder(order);
//        return Result.success(list);
//    }
//
//    /**
//     * 新增
//     *
//     * @param order 新增信息
//     * @return 成功或失败
//     */
//    @PostMapping("/order/insert")
//    public Result insertOrder(@RequestBody Order order) {
//        return orderService.insertOrder(order) ? Result.success() : Result.error("新增信息失败");
//    }
//
//    /**
//     * 修改
//     *
//     * @param order 根据主键修改信息
//     * @return 成功或失败
//     */
//    @PostMapping("/order/updateById")
//    public Result updateOrderById(@RequestBody Order order) {
//        return orderService.updateOrderById(order) ? Result.success() : Result.error("修改信息失败");
//    }
//
//    /**
//     * 详情
//     *
//     * @param order 根据主键获取详情
//     * @return 详情
//     */
//    @PostMapping("/order/getById")
//    public Result getOrderById(@RequestBody Order order) {
//        Order detail = orderService.getOrderById(order);
//        return Result.success(detail);
//    }
//

    @Resource
    private OrderService orderService;
    @Resource
    private TestFeign testFeign;

    @ApiOperation(value = "接口名", notes = "接口描述", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "length", value = "参数1", required = true, paramType = "path"),
            @ApiImplicitParam(name = "size", value = "参数2", required = true, paramType = "query"),
            @ApiImplicitParam(name = "page", value = "参数3", required = true, paramType = "header"),
            @ApiImplicitParam(name = "total", value = "参数4", required = true, paramType = "form"),
            @ApiImplicitParam(name = "start", value = "参数5", dataType = "string", paramType = "body")
    })
    @PostMapping(value = "/list")
    public List<TestEntity> list(@RequestBody TestEntity testEntity) {
        return testFeign.list(new JSONObject());
    }

    @PostMapping(value = "/insert")
    public List<TestEntity> insert() {
        orderService.seataInsert();
        return null;
    }

}
