package com.cn.lyp.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.lyp.dao.IUserDao;
import com.cn.lyp.pojo.User;
import com.cn.lyp.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;
	
	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);		
	}
  
}
