package com.qsn.order.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qsn.order.test.entity.TestEntity;
import com.qsn.order.test.mapper.TestMapper;
import com.qsn.order.test.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试实现类
 *
 * @author qiusn
 * @date 2020-01-07
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestEntity> implements TestService {



}
