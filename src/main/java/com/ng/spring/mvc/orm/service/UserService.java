package com.ng.spring.mvc.orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ng.spring.mvc.orm.dao.UserDao;
import com.ng.spring.mvc.orm.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public int save(User user) {

		return userDao.save(user);
	}
}
