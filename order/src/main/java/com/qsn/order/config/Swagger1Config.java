package com.qsn.order.config;


import com.qsn.common.base.SwaggerProperties;
import com.qsn.common.config.BaseSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API相关配置
 *
 * @Author wy
 * @Date 2020/7/27 10:51
 **/
//@Configuration
//@EnableSwagger2
public class Swagger1Config extends BaseSwaggerConfig {

//    @Override
//    public SwaggerProperties swaggerProperties() {
//        String title = "核心后台管理服务";
//
//        return SwaggerProperties.builder()
//                .apiBasePackage("com.qsn.order")
//                .title(title)
//                .description(title + "API文档")
//                .contactName("wong")
//                .version("1.0")
//                .enableSecurity(true)
//                .build();
//    }
}
