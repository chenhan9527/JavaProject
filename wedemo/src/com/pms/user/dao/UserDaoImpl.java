package com.pms.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pms.entity.User;

@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public void add(User u) {
		this.sessionFactory.getCurrentSession().save(u);
		this.sessionFactory.getCurrentSession().flush();
	}
	
	public User findUser(String idNum) {
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from User u where u.id="+idNum);
//			Order order = new Order();
//			order.setCount(5);
//			this.sessionFactory.getCurrentSession().save(order);
//			this.sessionFactory.getCurrentSession().flush();
			return (User) query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public List<User> findUsers() {
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from User");
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
