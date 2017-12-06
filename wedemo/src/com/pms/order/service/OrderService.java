package com.pms.order.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.order.dao.OrderDaoImpl;

@Service
@Transactional(readOnly=true)
public class OrderService {
	
	@Resource
	private OrderDaoImpl orderDao;

}
