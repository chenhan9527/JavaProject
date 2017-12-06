package com.pms.order.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pms.entity.Order;

@Repository
public class OrderDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;

	public void saveOrder(Order order) {
		this.sessionFactory.getCurrentSession().save(order);
		this.sessionFactory.getCurrentSession().flush();
	}
}
