package com.service;

import com.dao.TeacherDao;
import com.entity.Page;
import com.entity.Student;
import com.entity.Teacher;

import java.util.List;

/**
 * @ProjectName: StudentSystem
 * @Package: com.service
 * @ClassName: TeacherService
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/17 16:40
 * @Version: 1.0
 */
public class TeacherService extends TeacherDao {
//    @Override
//    public List selectTeacherAll() {
//        return super.selectTeacherAll();
//    }

    @Override
    public List likeSelectTeacher(String name) {
        return super.likeSelectTeacher(name);
    }

    @Override
    public void delete(String tno) {
        super.delete(tno);
    }

    @Override
    public Integer count(String name) {
        return super.count(name);
    }

    @Override
    public void add(Teacher teacher) {
        super.add(teacher);
    }

    @Override
    public List limitTeacher(String name, Page page) {
        return super.limitTeacher(name, page);
    }

    @Override
    public void update(Teacher teacher) {
        super.update(teacher);
    }
}
