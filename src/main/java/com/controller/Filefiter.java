package com.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ProjectName: Maven_test
 * @Package: com.controller
 * @ClassName: Filefiter
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/15 15:19
 * @Version: 1.0
 */
@WebFilter("/*")
public class Filefiter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //chain也是一个接口，用于将请求和响应向后面传递
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
        // /放行
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
