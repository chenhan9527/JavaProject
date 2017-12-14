package com.pms.user.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.entity.Address;
import com.pms.entity.User;
import com.pms.user.dao.UserDaoImpl;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl {

	@Resource
	private UserDaoImpl dao;
	
	public void addAddress(Address address, HttpSession session) {
		this.dao.addAddress(address,session);
	}
	public void add(User u) {
		this.dao.add(u);
	}
	
	public User findUser(String string) {
		return this.dao.findUser(string);
	}
	public List<User> findUsers() {
		return this.dao.findUsers();
	}
}
