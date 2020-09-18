package com.controller;

import com.entity.Page;
import com.service.StudentService;
import com.service.TeacherService;

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
 * @ClassName: SelectTeacher
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/17 16:35
 * @Version: 1.0
 */
@WebServlet("/selectteacher")
public class SelectTeacher extends HttpServlet {
    private TeacherService teacherService=new TeacherService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page page=new Page();
        String name = req.getParameter("name");
        if (name==null){
            name="";
        }
        Integer count = teacherService.count(name);
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
            if (page.getPageTotal()==0){
                page.setPageCurren(1);
            }else {
                page.setPageCurren(page.getPageTotal());
            }
        }
        List limitlist = teacherService.limitTeacher(name,page);
        req.setAttribute("list",limitlist);
        req.setAttribute("name",name);
        req.setAttribute("page",page);
        String id = req.getParameter("id");
        if ("2".equals(id)){
            req.getRequestDispatcher("teachermsg.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("selectteacher.jsp").forward(req,resp);
        }
    }
}
