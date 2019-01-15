package com.chang.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "CharsetEncodingFilter", urlPatterns = "/*", initParams = {@WebInitParam(name = "CharsetEncoding", value = "UTF-8")})
public class CharsetEncodingFilter implements Filter {

    private static String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

        encoding = config.getInitParameter("CharsetEncoding");
    }

}
