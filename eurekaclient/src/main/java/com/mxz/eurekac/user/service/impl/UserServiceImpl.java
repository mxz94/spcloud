package com.mxz.eurekac.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxz.eurekac.user.dao.UserDao;
import com.mxz.eurekac.user.model.User;
import com.mxz.eurekac.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserDao userDao;
	
	public void addUser(User user) {
		userDao.save(user);
	}
}