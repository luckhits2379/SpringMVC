package com.ng.spring.mvc.orm.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ng.spring.mvc.orm.model.User;

@Repository
public class UserDao {

	@Autowired
	HibernateTemplate template;

	@Transactional
	public int save(User user) {

		int res = (int) template.save(user);

		return res;
	}
}
