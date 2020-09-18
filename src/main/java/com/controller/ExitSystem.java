package com.controller;

import com.enums.SysEnum;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ProjectName: StudentSystem
 * @Package: com.controller
 * @ClassName: ExitSystem
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/17 13:33
 * @Version: 1.0
 */
@WebServlet("/exit")
public class ExitSystem extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("username");
        Cookie username = new Cookie("username", null);
        username.setMaxAge(0);
        Cookie password = new Cookie("password", null);
        password.setMaxAge(0);
        resp.addCookie(username);
        resp.addCookie(password);
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute(SysEnum.COUNT.getValue(),Integer.valueOf(servletContext.getAttribute(SysEnum.COUNT.getValue()).toString())-1);
        resp.sendRedirect("login.jsp");
    }
}
