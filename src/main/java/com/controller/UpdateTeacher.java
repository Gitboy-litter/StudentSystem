package com.controller;

import com.entity.Student;
import com.entity.Teacher;
import com.service.StudentService;
import com.service.TeacherService;
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
 * @ClassName: UpdateTeacher
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/17 18:06
 * @Version: 1.0
 */
@WebServlet("/teacherupdate")
public class UpdateTeacher extends HttpServlet {
    private TeacherService teacherService = new TeacherService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map parameterMap = req.getParameterMap();
        Teacher teacher=new Teacher();
        try {
            BeanUtils.populate(teacher,parameterMap);
            teacherService.update(teacher);
            req.getRequestDispatcher("/selectteacher").forward(req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
