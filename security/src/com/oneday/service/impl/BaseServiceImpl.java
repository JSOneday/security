package com.oneday.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneday.dao.IBaseDao;
import com.oneday.entity.BaseObject;
import com.oneday.service.BaseService;
@Service("baseService")
public class BaseServiceImpl implements BaseService {

	@Autowired
	private IBaseDao baseDao;
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
	public <T extends BaseObject> T getObject(Class<T> clazz, Serializable id) {
		return baseDao.getObject(clazz, id);
	}

}
