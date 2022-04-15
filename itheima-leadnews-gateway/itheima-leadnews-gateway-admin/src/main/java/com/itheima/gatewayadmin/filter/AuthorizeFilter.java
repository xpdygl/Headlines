package com.itheima.gatewayadmin.filter;

import com.itheima.common.constants.SystemConstants;
import com.itheima.common.pojo.Result;
import com.itheima.common.util.AppJwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //判断是否有足够的权限访问，如果没有就错误返回
        ServerHttpResponse response = exchange.getResponse();
        ServerHttpRequest request = exchange.getRequest();

        //获取当前请求路径，判断是否为白名单，如登录注册直接放行，其他的拦截
        String path = request.getURI().getPath();
        if (path.equals("/admin/admin/login")) {
            return chain.filter(exchange);
        }


        //获取页面传递的令牌信息，判断如果为null，返回错误
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst("token");
        if (StringUtils.isEmpty(token)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //检验令牌。如果错误就返回

        Integer code = AppJwtUtil.verifyToken(token);
        if (code.intValue()!= SystemConstants.JWT_OK){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        //如果通过就放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -99;
    }
}
