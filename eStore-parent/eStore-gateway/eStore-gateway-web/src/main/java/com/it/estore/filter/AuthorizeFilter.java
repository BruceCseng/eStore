package com.it.estore.filter;

import com.it.estore.utils.JwtUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器，实现用户权限鉴别
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    // 令牌的名字
    private static final String AUTHORIZE_TOKEN = "Authorization";

    /**
     * 全局拦截
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 获取用户令牌，有三处地方获取令牌
        // 1.头文件
        String token = request.getHeaders().getFirst(AUTHORIZE_TOKEN);
        // 2.参数中
        if(StringUtils.isEmpty(token)){
            token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        }
        // 3.cookie中
        if(StringUtils.isEmpty(token)){
            HttpCookie httpCookie = request.getCookies().getFirst(AUTHORIZE_TOKEN);
            if(httpCookie!=null){
                token = httpCookie.getValue();
            }
        }
        // 如果没有，则拦截
        if(StringUtils.isEmpty(token)){
            // 设置没有权限的状态码  401
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            // 响应空数据
            return response.setComplete();
        }
        // 如果有令牌，则校验令牌是否有效
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            // 无效拦截
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        // 有效放行
        return chain.filter(exchange);
    }

    /**
     * 排序，越小越先执行
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
