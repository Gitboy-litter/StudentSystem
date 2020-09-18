package com.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ProjectName: StudentSystem
 * @Package: com.controller
 * @ClassName: CookieFiter
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/17 15:11
 * @Version: 1.0
 */
//@WebFilter("/login.jsp")
public class CookieFiter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
