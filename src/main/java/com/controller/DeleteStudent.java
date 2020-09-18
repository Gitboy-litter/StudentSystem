package com.controller;

import com.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: StudentSystem
 * @Package: com.controller
 * @ClassName: DeleteStudent
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/16 13:27
 * @Version: 1.0
 */
@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {
    private StudentService studentService=new StudentService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = req.getParameter("sno");
        studentService.delete(sno);
        req.getRequestDispatcher("/selectstudent").forward(req,resp);
    }
}
