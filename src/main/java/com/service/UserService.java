package com.service;

import com.dao.UserDao;
import com.entity.User;

/**
 * @ProjectName: StudentSystem
 * @Package: com.service
 * @ClassName: UserService
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/16 10:34
 * @Version: 1.0
 */
public class UserService extends UserDao {
    @Override
    public boolean login(User user){
       return super.login(user);
    }

    @Override
    public void add(User user) {
        super.add(user);
    }

    @Override
    public boolean select(String username) {
        return super.select(username);
    }

    @Override
    public boolean selecttype(User user) {
        return super.selecttype(user);
    }
}
