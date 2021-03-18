package com.qsn.gateway.conf.filter;

import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 全局过滤器
 * <p>
 * 所有请求都会执行
 * 可拦截get、post等请求做逻辑处理
 *
 * @author qiusn
 * @date 2021--03-09
 */
@Slf4j
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 执行逻辑
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        String oldUrl = serverHttpRequest.getURI().toString();
        log.info("请求的路径为:【{}】", oldUrl);
        String method = serverHttpRequest.getMethodValue();
        if ("POST".equals(method)) {
            //TODO 得到Post请求的请求参数后，做你想做的事
            log.info("------------------------------------------POST请求------------------------------------------");

//            //从请求里获取Post请求体
//            String bodyStr = resolveBodyFromRequest(serverHttpRequest);
//            //下面的将请求体再次封装写回到request里，传到下一级，否则，由于请求体已被消费，后续的服务将取不到值
//            URI newUrl = serverHttpRequest.getURI();
//            ServerHttpRequest request = serverHttpRequest.mutate().uri(newUrl).build();
//            DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
//            Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);
//
//            request = new ServerHttpRequestDecorator(request) {
//                @Override
//                public Flux<DataBuffer> getBody() {
//                    return bodyFlux;
//                }
//            };
//            //封装request，传给下一级
//            return chain.filter(exchange.mutate().request(request).build());
            return chain.filter(exchange);
        } else if ("GET".equals(method)) {
            Map requestQueryParams = serverHttpRequest.getQueryParams();
            //TODO 得到Get请求的请求参数后，做你想做的事
            log.info("------------------------------------------GET请求哦------------------------------------------");

            return chain.filter(exchange);
        }
        return chain.filter(exchange);
    }


    /**
     * 从Flux<DataBuffer>中获取字符串的方法
     *
     * @return 请求体
     */
    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
        //获取请求体
        Flux<DataBuffer> body = serverHttpRequest.getBody();

        AtomicReference<String> bodyRef = new AtomicReference<>();
        body.subscribe(buffer -> {
            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
            DataBufferUtils.release(buffer);
            bodyRef.set(charBuffer.toString());
        });
        //获取request body
        return bodyRef.get();
    }

    private DataBuffer stringBuffer(String value) {
        if(StringUtils.isBlank(value)){
            throw new RuntimeException("HTTP请求体值为空");
        }
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
        buffer.write(bytes);
        return buffer;
    }

    /**
     * 执行顺序
     */
    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * 过滤器执行顺序示例
     * 业务执行前执行时， @Order(-1) 的参数越小，优先级越高
     * 业务执行后执行时， @Order(-1) 的参数越小，优先级越低
     *
     * @return
     */
    @Bean
    @Order(-1)
    public GlobalFilter a() {
        return (exchange, chain) -> {
            log.info("在业务执行前执行： 第一个执行");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("在业务执行后执行： 第三个执行");
            }));
        };
    }

    @Bean
    @Order(0)
    public GlobalFilter b() {
        return (exchange, chain) -> {
            log.info("在业务执行前执行： 第二个执行");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("在业务执行后执行： 第二个执行");
            }));
        };
    }

    @Bean
    @Order(1)
    public GlobalFilter c() {
        return (exchange, chain) -> {
            log.info("在业务执行前执行： 第三个执行");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("在业务执行后执行： 第一个执行");
            }));
        };
    }
}