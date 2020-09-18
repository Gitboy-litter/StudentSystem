package com.controller;

import com.entity.Student;
import com.service.StudentService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ProjectName: StudentSystem
 * @Package: com.controller
 * @ClassName: UpdateStudent
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/16 20:05
 * @Version: 1.0
 */
@WebServlet("/studentupdate")
public class UpdateStudent extends HttpServlet {
    private StudentService studentService = new StudentService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map parameterMap = req.getParameterMap();
        Student student=new Student();
        try {
            BeanUtils.populate(student,parameterMap);
            studentService.update(student);
            req.getRequestDispatcher("/selectstudent").forward(req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
