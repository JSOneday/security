package com.oneday.service;

import java.io.Serializable;

import com.oneday.entity.BaseObject;

public interface BaseService {
	<T extends BaseObject> T getObject(Class<T> clazz, Serializable id);
}
