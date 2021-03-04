package com.qsn.order.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
//@EnableKnife4j
public class Swagger2Config1 {
    
	/**
     * 创建RestApi 并包扫描controller
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                // 对所有api进行监控
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
            	 //不显示错误的接口地址
                //错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

	/**
     * 创建Swagger页面 信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("用户微服")
                .description("用户微服")
                .version("1.0.0-SNAPSHOT")
                .build();
    }
}