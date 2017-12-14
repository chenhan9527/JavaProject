package com.pms.order.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.entity.Order;
import com.pms.order.dao.OrderDaoImpl;

@Service
@Transactional(readOnly=true)
public class OrderService {
	
	@Resource
	private OrderDaoImpl orderDao;

	public List findAll(HttpSession session) {
		return this.orderDao.findAll(session);
	}
	
	public Order findOrderById(int id) {
		return this.orderDao.findOrderById(id);
	}
	public void deleteOrder(int id) {
		this.orderDao.deletOrder(id);
	}
}
