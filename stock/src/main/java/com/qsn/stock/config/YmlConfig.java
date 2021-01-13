package com.qsn.stock.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取配置文件信息
 *
 * @author qiusn
 * @date 2020-12-31
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties("qsn")
public class YmlConfig {

    private String name;
    private Integer age;


}
