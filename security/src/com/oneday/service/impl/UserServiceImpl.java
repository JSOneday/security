package com.oneday.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneday.dao.IUserDao;
import com.oneday.entity.User;
import com.oneday.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public User getQueryByname(String uanme) {
		// TODO Auto-generated method stub
		return userDao.getByUname(uanme);
	}

}
