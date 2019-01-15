package com.chang.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LogFilter", urlPatterns = "/*")
public class LogFilter implements Filter {

    private FilterConfig config;

    public void destroy() {
        this.config = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 获取ServletContext对象，用于记录日志
        ServletContext context = this.config.getServletContext();
        System.out.println("开始过滤");
        // 将请求转换成HttpServletRequest请求
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("Filter已经拦截到用户的请求地址" + request.getServletPath());
        chain.doFilter(req, resp);
        System.out.println("过滤结束");
        System.out.println("请求被定位到" + request.getRequestURI());
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
