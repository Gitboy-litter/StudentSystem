package com.controller;

import com.entity.User;
import com.enums.SysEnum;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
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
//@WebFilter(urlPatterns = {"/index.jsp","/selectstudent.jsp","/include.jsp"})
@WebFilter("/*")
public class Filefiter extends HttpServlet implements Filter {
    private ServletContext servletContext=null;
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//      getServletContext().setAttribute(SysEnum.COUNT.getValue(), 0);
//    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String username="";
        String uri = req.getRequestURI() ;
        HttpSession session = req.getSession();

        if ( uri.contains("login")|| "/register.jsp".equals(uri)||"/".equals(uri)){
            int index=0;
            Cookie[] cookies = req.getCookies();
            if (cookies!=null){
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())){
                        username=cookie.getValue();
                        index++;
                    }
                    if ("password".equals(cookie.getName())){
                        index++;
                    }
                }
                if (index==2){
                    session.setAttribute("username",username);
                    if (servletContext.getAttribute(SysEnum.COUNT.getValue()) == null||Integer.valueOf(servletContext.getAttribute(SysEnum.COUNT.getValue()).toString()) == 0) {
                        servletContext.setAttribute(SysEnum.COUNT.getValue(), 1);
                    } else {
                        servletContext.setAttribute(SysEnum.COUNT.getValue(), Integer.valueOf(servletContext.getAttribute(SysEnum.COUNT.getValue()).toString()) + 1);
                    }
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    return;
                }
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        servletResponse.setContentType("text/html;charset=utf-8");
        if (session.getAttribute("username")==null){
            req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req,resp);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        // /放行
    }

    @Override
    public void destroy() {
    }
}
