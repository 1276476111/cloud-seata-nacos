package com.qsn.stock.test;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.qsn.stock.config.YmlConfig;
import com.qsn.stock.test.entity.TestEntity;
import com.qsn.stock.test.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试类
 *
 * @author qiusn
 * @data 21020-01-04
 */
@RestController
@RequestMapping(value = "api/stock")
public class StockTestController {
    @Resource
    private YmlConfig ymlConfig;
    @Resource
    private TestService testService;

    @PostMapping(value = "/test")
    public JSONObject test(@RequestBody JSONObject jsonObject) {
        jsonObject.put("name", ymlConfig.getName());
        jsonObject.put("age", ymlConfig.getAge());
        return jsonObject;
    }


    @PostMapping(value = "/list")
    public List<TestEntity> list(@RequestBody JSONObject jsonObject) {
        jsonObject.put("name", ymlConfig.getName());
        jsonObject.put("age", ymlConfig.getAge());
        List<TestEntity> testEntities = testService.list();
        return testEntities;
    }


    @PostMapping(value = "/insert")
    public List<TestEntity> insert() {
//        if(true){
//            throw new ApiException("异常奥");
//        }
        TestEntity testEntity = new TestEntity();
        testEntity.setName("南哥111");
        testEntity.setAge(18);
        testService.save(testEntity);
        return null;
    }
}
