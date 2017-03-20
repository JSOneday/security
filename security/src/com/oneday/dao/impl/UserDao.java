package com.oneday.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.oneday.dao.IUserDao;
import com.oneday.entity.User;
@Component("userDao")
public class UserDao implements IUserDao {
	
	@Autowired
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public User getByUname(String uname) {
		DetachedCriteria query = DetachedCriteria.forClass(User.class);
		query.add(Restrictions.eq("uname", uname));
		List<?> uList = template.findByCriteria(query);
		if(uList.size()==1){
			User u=(User) uList.get(0);
			return u;
		}
		return null;
	}

}
