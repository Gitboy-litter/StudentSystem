package com.controller;

import com.dao.UserDao;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: StudentSystem
 * @Package: com.controller
 * @ClassName: SelectUsername
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/15 17:30
 * @Version: 1.0
 */
@WebServlet("/SelectUsername")
public class SelectUsername extends HttpServlet {
    private UserService userService=new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String json=null;
            String username=req.getParameter("username");
            boolean select = userService.select(username);
            if (select){
                json="{\"falg\":true,\"msg\":\"用户名已经存在\"}";
            }else {
                json="{\"falg\":true,\"msg\":\"可以使用\"}";
            }
            resp.getWriter().write(json);
    }
}
