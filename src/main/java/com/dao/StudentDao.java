package com.dao;

import com.dbunit.DbUnit;
import com.entity.Page;
import com.entity.Student;

import java.util.List;

/**
 * @ProjectName: StudentSystem
 * @Package: com.dao
 * @ClassName: StudentDao
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/16 10:02
 * @Version: 1.0
 */
public class StudentDao {
    public List selectStudentAll(){
        String sql="select * from student";
        return DbUnit.selectALL(sql);
    }
    public List likeSelectStudent(String name){
        String sql="select * from student where sname like ?";
        return  DbUnit.likeSelect(sql, name);
    }
    public void delete(String sno){
        String sql="delete from student where sno=?";
        DbUnit.dml(sql,sno);
    }
    public Integer count(String name){
        String sql="select count(*) count from  student where sname like ? ";
        Integer count = DbUnit.count(sql,name);
        return count;
    }
    public void add(Student student){
        String sql="insert into student value(?,?,?,?,?)";
        DbUnit.dml(sql,student.getSno(),student.getSname(),student.getSsex(),student.getSage(),student.getSdept());
    }
    public List limitStudent(String name,Page page){
        String sql="select * from student where sname like ? limit ?,?";
        return DbUnit.limitStudent(sql,name,page);
    }
    public void update(Student student){
        String sql="update student set sname=?,ssex=?,sage=?,sdept=? where sno=?";
        DbUnit.dml(sql,student.getSname(),student.getSsex(),student.getSage(),student.getSdept(),student.getSno());
    }
}
