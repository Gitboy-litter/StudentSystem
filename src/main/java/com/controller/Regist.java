package com.controller;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: Maven_test
 * @Package: com.controller
 * @ClassName: Login
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/11 16:21
 * @Version: 1.0
 */
@WebServlet("/register")
public class Regist extends HttpServlet {
    private UserService userService=new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        User user=new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        userService.add(user);
        req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
}

