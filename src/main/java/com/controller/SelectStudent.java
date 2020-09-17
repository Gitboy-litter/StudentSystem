package com.controller;

import com.dao.StudentDao;
import com.dao.UserDao;
import com.entity.Page;
import com.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: StudentSystem
 * @Package: com.controller
 * @ClassName: SelectStudent
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/15 20:08
 * @Version: 1.0
 */
@WebServlet("/selectstudent")
public class SelectStudent extends HttpServlet {
    private StudentService studentService=new StudentService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page page=new Page();
        String name = req.getParameter("name");
        if (name==null){
            name="";
        }
        Integer count = studentService.count(name);
        page.setCount(count);
        Integer pageTotal = count % page.getPageSize() == 0 ? count / page.getPageSize() : count /page.getPageSize() + 1;
        page.setPageTotal(pageTotal);
        String pageCurrent = req.getParameter("pageCurrent");
        if (pageCurrent!=null&&pageCurrent!=""){
           page.setPageCurren(Integer.valueOf(pageCurrent));
        }
        if (page.getPageCurren()<=0){
            page.setPageCurren(1);
        }else if (page.getPageCurren()>=page.getPageTotal()){
            page.setPageCurren(page.getPageTotal());
        }
        List limitlist = studentService.limitStudent(name,page);
        req.setAttribute("list",limitlist);
        req.setAttribute("name",name);
        req.setAttribute("page",page);
        req.getRequestDispatcher("selectstudent.jsp").forward(req,resp);
    }
}
