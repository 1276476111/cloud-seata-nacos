package com.qsn.gateway.conf.limiting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;


/**
 * 网关限流配置： 使用 SpEL 按名称引用 bean （待测试）
 *
 * 限流算法：
 * （1）固定窗口算法（Fixed Window）
 * （2）滑动窗口算法
 * （3）漏桶算法
 * （4）令牌桶算法
 *
 * @author qiusn
 * @date 2021-03-10
 */
@Configuration
public class AppConfig {

    @Value("")
    /**
     * 必须有一个主键方法
     * 根据ip进行限流
     * @return
     */
    @Primary
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    /**
     * 根据用户限流
     * 根据参数中的userId值进行限流
     * @return
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }

    /**
     * 根据api限流
     * 根据请求path进行限流
     * @return
     */
    @Bean
    KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

    /**
     * 根据自定义key限流
     * @return
     */
    @Bean
    public KeyResolver otherKeyResolver() {
        return exchange -> Mono.just(getOtherKey(exchange));
    }

    /**
     * 自定义限流key，根据需要生产key
     * @param exchange
     * @return
     */
    private String getOtherKey(ServerWebExchange exchange){
        String key;
        String userId = exchange.getRequest().getQueryParams().getFirst("uid");
        Map aa = exchange.getAttributes();
        key = userId + aa.get("group");
        return key;
    }

}