package com.controller;

import com.service.StudentService;
import com.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: StudentSystem
 * @Package: com.controller
 * @ClassName: DeleteTeacher
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/17 17:20
 * @Version: 1.0
 */
@WebServlet("/deleteteacher")
public class DeleteTeacher extends HttpServlet {
        private TeacherService teacherService=new TeacherService();
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String tno = req.getParameter("tno");
            teacherService.delete(tno);
            req.getRequestDispatcher("/selectteacher").forward(req,resp);
        }
}
