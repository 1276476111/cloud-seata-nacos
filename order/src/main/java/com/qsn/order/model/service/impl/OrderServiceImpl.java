package com.qsn.order.model.service.impl;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.qsn.order.feign.StockFeign;
import com.qsn.order.model.entity.Order;
import com.qsn.order.model.mapper.OrderMapper;
import com.qsn.order.model.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 服务实现类
 *
 * @author qiusn
 * @date 2021-01-08
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;


    @Override
    public List<Order> listOrder(Order order) {
        return orderMapper.listOrder(order);
    }

    @Override
    public boolean insertOrder(Order order) {
        int insertNum = orderMapper.insertOrder(order);
        return insertNum == 1 ? true : false;
    }

    @Override
    public boolean updateOrderById(Order order) {
        int updateNum = orderMapper.updateOrderById(order);
        return updateNum == 1 ? true : false;
    }

    @Override
    public Order getOrderById(Order order) {
        return orderMapper.getOrderById(order);
    }

    @Resource
    private StockFeign stockFeign;

    @Override
    @GlobalTransactional
    public void seataInsert() {

        // 创建订单
        Order order = new Order();
        order.setMoney(200);
        order.setCount(2);
        order.setCommodityCode("呵呵呵呵呵呵");
        insertOrder(order);

        // 创建用户
        try {
            stockFeign.insert();
        }catch (Exception e){
            throw new ApiException("库存服务调用异常");
        }

    }


}
