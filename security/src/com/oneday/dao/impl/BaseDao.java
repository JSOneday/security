package com.oneday.dao.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.oneday.dao.IBaseDao;
import com.oneday.entity.BaseObject;

@Component("baseDao")
public class BaseDao implements IBaseDao {
	
	@Autowired
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public <T extends BaseObject> T getObject(Class<T> clazz, Serializable id) {
		return template.get(clazz, id);
	}

}
