package com.controller;

import com.dao.UserDao;
import com.entity.User;
import com.enums.SysEnum;
import com.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

//import javax.servlet.annotation.WebFilter;

/**
 * @ProjectName: Maven_test
 * @Package: com.controller
 * @ClassName: Login
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/11 16:21
 * @Version: 1.0
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        User user = new User();
        String type = req.getParameter("type");
        String remember = req.getParameter("remember");
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        HttpSession session = req.getSession();
        user.setType(type);
        if (!userService.login(user)) {
            req.setAttribute("msg", "账号密码不正确,或者管理员没审批");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            if ("7".equals(remember)) {
                Cookie username = new Cookie("username", user.getUsername());
                Cookie password = new Cookie("password", user.getPassword());
                username.setMaxAge(60 * 60 * 24 * 7);
                password.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(username);
                resp.addCookie(password);
                session.setAttribute("username", user.getUsername());
            } else {
//                    Cookie username=new Cookie("username",user.getUsername());
                session.setAttribute("username", user.getUsername());
//                    resp.addCookie(username);
            }
            if (servletContext.getAttribute(SysEnum.COUNT.getValue()) == null) {
                servletContext.setAttribute(SysEnum.COUNT.getValue(), 1);
            } else {
                servletContext.setAttribute(SysEnum.COUNT.getValue(), Integer.valueOf(servletContext.getAttribute(SysEnum.COUNT.getValue()).toString()) + 1);
            }
            resp.sendRedirect("index.jsp");
        }
    }
}
