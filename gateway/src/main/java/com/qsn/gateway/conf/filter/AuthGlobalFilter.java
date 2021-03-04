package com.qsn.gateway.conf.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 有参考价值的方法
 * 全局过滤器
 *
 * @Author qiusn
 * @Date 2021/03/03
 **/
//@Component
//@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return null;
    }

//    @Autowired
//    private IgnoreUrlsConfig ignoreUrlsConfig;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    private String tokenHeader = "";
//    //    private String tokenHeader = Constants.JWT_TOKEN_HEADER;
//    @Value("${redis.database}")
//    private String REDIS_DATABASE;
//    @Value("${redis.key.token}")
//    private String REDIS_KEY_TOKEN;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        //防止 OPTIONS 请求直接放行
//        if (request.getMethod().equals(HttpMethod.OPTIONS)) {
//            return chain.filter(exchange);
//        }
//        //白名单请求直接放行
//        PathMatcher pathMatcher = new AntPathMatcher();
//        Console.log("ignoreUrlsConfig.getUrls():{}", ignoreUrlsConfig.getUrls());
//        Console.log("request.getPath():{}", request.getPath().toString());
//        for (String path : ignoreUrlsConfig.getUrls()) {
//            if (pathMatcher.match("/**" + path, request.getPath().toString())) {
//                return chain.filter(exchange);
//            }
//        }
//        // token 验证
//        String token = request.getHeaders().getFirst(tokenHeader);
//        if (StringUtils.isBlank(token)) {
//            log.error("token = {}", token);
//            throw new ApiException(ResultCode.UNAUTHORIZED);
//        }
////        String username = jwtTokenUtil.getUserNameFromToken(token);;
//        String username = "";
//        // 待抽离
//        String key = REDIS_DATABASE + ":" + REDIS_KEY_TOKEN + ":" + username;
//        String resultToken = stringRedisTemplate.opsForValue().get(key);
//        if (StringUtils.isBlank(resultToken)) {
//            log.error("resultToken = {}", resultToken);
//            throw new ApiException(ResultCode.UNAUTHORIZED);
//        }
//        log.error("resultToken = {}", resultToken);
//        return chain.filter(exchange);
//    }


}
