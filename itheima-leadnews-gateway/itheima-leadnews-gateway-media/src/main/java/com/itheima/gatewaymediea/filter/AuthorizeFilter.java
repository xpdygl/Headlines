package com.itheima.gatewaymediea.filter;

import com.itheima.common.constants.SystemConstants;
import com.itheima.common.util.AppJwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //逻辑写到这 判断 是否有足够的权限来访问 如果没有返回错误

        //1.获取当前的request response对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //2.获取当前的请求路径 判断是否符合要求（白名单） 比如 要登录，要去注册 直接放行
        String path = request.getURI().getPath();
        if (path.equals("/media/wmUser/login")) {
            return chain.filter(exchange);
        }

        //3.获取页面传递过来的令牌信息（request header） 判断如果为null 返回错误
        //请求头 头名 ： token
        String token = request.getHeaders().getFirst("token");

        if (StringUtils.isEmpty(token)) {

            response.setStatusCode(HttpStatus.UNAUTHORIZED);

            //响应回去
            return response.setComplete();
        }
        //4.校验令牌 如果没通过 返回错误
        Integer code = AppJwtUtil.verifyToken(token);
        //自动拆箱 只需要一个
        if (code.intValue() != SystemConstants.JWT_OK) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);

            //响应回去
            return response.setComplete();
        }

        //5.还要做额外的事情（解析令牌中的用户的ID 通过代码实现请求头过 传递给下游微服务）
        Claims claimsBody = AppJwtUtil.getClaimsBody(token);
        String userId = claimsBody.get("id").toString();

        //设置请求头传递给下游
        request.mutate()
                .header(SystemConstants.USER_HEADER_NAME, userId);
        //6.如果通过了 放行

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
