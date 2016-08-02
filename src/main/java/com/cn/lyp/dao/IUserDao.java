package com.cn.lyp.dao;

import com.cn.lyp.pojo.User;

public interface IUserDao {
    int insert(User user);
    User selectByPrimaryKey(int userId);
    void updateByPrimaryKeySelective(User user);
}
