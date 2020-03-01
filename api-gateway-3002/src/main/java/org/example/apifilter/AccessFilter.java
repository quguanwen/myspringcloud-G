package org.example.apifilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Slf4j
public class AccessFilter extends ZuulFilter {

    //TODO 表示请求到达过滤
    @Override
    public String filterType() {
        return "pre";
    }

    //TODO 表示过滤器执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //TODO 过滤器是否执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的过滤逻辑:
     * 当request中没有对应token就拦截请求
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURI().toString());

        Object accessToken = request.getHeader("accessToken");
        if (accessToken == null){
            log.warn("token is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }

        log.info("access token ok");
        return null;
    }
}
