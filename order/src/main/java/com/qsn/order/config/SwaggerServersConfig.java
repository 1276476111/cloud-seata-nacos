package com.qsn.order.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 配置描述swagger的描述
 * @Author:
 * @Date: 2020/2/11 11:47
 */
@EnableSwagger2
@Configuration
public class SwaggerServersConfig {

    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 详细定制
                .apiInfo(apiInfo("1.0.0"))
                .select()
                // 指定扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.qsn.order"))
                // 扫描所有
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo(String version) {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("order的接口文档")
                .version(version)
                .build();
    }
}