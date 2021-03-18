package com.qsn.gateway.conf.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 普通过滤器示例
 *
 * @author qiusn
 * @date 2021--03-09
 */
@Slf4j
public class MyGatewayFilter implements GatewayFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		String uri = request.getPath().toString();
		String method = request.getMethod().name();
		log.info("url :{}  method: {} ", uri, method);
		String accessToken = request.getHeaders().getFirst("AccessToken");
		if (StringUtils.isBlank(accessToken)) {
			// 请求拒绝
			exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
			return exchange.getResponse().setComplete();
		}

		return chain.filter(exchange);
	}
}