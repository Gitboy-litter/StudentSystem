package com.dao;

import com.dbunit.DbUnit;
import com.entity.Page;
import com.entity.Student;
import com.entity.Teacher;

import java.util.List;

/**
 * @ProjectName: StudentSystem
 * @Package: com.dao
 * @ClassName: TeacherDao
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/17 16:36
 * @Version: 1.0
 */
public class TeacherDao {
//    public List selectTeacherAll(){
//        String sql="select * from teacher";
//        return DbUnit.selectALL(sql);
//    }
    public List likeSelectTeacher(String name){
        String sql="select * from teacher where tname like ?";
        return  DbUnit.likeSelect(sql, name);
    }
    public void delete(String tno){
        String sql="delete from teacher where tno=?";
        DbUnit.dml(sql,tno);
    }
    public Integer count(String name){
        String sql="select count(*) count from  teacher where tname like ? ";
        Integer count = DbUnit.count(sql,name);
        return count;
    }

    public void add(Teacher teacher){
        String sql="insert into teacher value(?,?,?,?,?,?,?,?,?)";
        DbUnit.dml(sql,teacher.getTno(),teacher.getTname(),teacher.getTsex(),teacher.getTage(),teacher.getTeb(),teacher.getTpt(),teacher.getCno1(),teacher.getCno2(),teacher.getCno3());
    }
    public List limitTeacher(String name, Page page){
        String sql="select * from teacher where tname like ? limit ?,?";
        return DbUnit.limitTeacher(sql,name,page);
    }
    public void update(Teacher teacher){
        String sql="update teacher set tname=?,tsex=?,tage=?,teb=?,tpt=?,cno1=?,cno2=?,cno3=? where tno=?";
        DbUnit.dml(sql,teacher.getTname(),teacher.getTsex(),teacher.getTage(),teacher.getTeb(),teacher.getTpt(),teacher.getCno1(),teacher.getCno2(),teacher.getCno3(),teacher.getTno());
    }
}
