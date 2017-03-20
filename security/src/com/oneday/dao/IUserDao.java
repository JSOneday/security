package com.oneday.dao;

import com.oneday.entity.User;

public interface IUserDao {
	User getByUname(String uname);
}
