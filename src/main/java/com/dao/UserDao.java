package com.dao;

import com.dbunit.DbUnit;
import com.entity.Page;
import com.entity.User;

import java.util.List;

/**
 * @ProjectName: Maven_test
 * @Package: com.dao
 * @ClassName: UserDao
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/11 16:25
 * @Version: 1.0
 */
public class UserDao {
    public void add(User user){
            String sql="insert into user (username,password) values (?,?)";
            DbUnit.dml(sql,user.getUsername(),user.getPassword());
    }
    public boolean  login(User user){
        String sql="select username,password from user where username=? and password=? and type=?";
        return DbUnit.select(sql,user.getUsername(),user.getPassword(),user.getType());
    }
    public boolean select(String username){
        String sql="select username from user where username=?";
       return DbUnit.select(sql, username);
    }
    public boolean selecttype(User user){
        String sql="select type from user where username=? and password=?";
        return DbUnit.select(sql,user.getUsername(),user.getPassword(),user.getType());
    }
}
