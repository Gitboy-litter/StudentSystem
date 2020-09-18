package com.service;

import com.dao.StudentDao;
import com.entity.Page;
import com.entity.Student;

import java.util.List;

/**
 * @ProjectName: StudentSystem
 * @Package: com.service
 * @ClassName: StudentService
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/16 10:40
 * @Version: 1.0
 */
public class StudentService extends StudentDao {
    @Override
    public List selectStudentAll() {
        return super.selectStudentAll();
    }

    @Override
    public List likeSelectStudent(String name) {
        return super.likeSelectStudent(name);
    }

    @Override
    public void delete(String sno) {
        super.delete(sno);
    }

    @Override
    public Integer count(String name) {
        return super.count(name);
    }

    @Override
    public void add(Student student) {
        super.add(student);
    }

    @Override
    public List limitStudent(String name, Page page) {
        return super.limitStudent(name, page);
    }

    @Override
    public void update(Student student) {
        super.update(student);
    }
}
