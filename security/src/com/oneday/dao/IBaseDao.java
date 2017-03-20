package com.oneday.dao;

import java.io.Serializable;
import com.oneday.entity.BaseObject;

public interface IBaseDao {
	<T extends BaseObject> T getObject(Class<T> clazz, Serializable id);
}
