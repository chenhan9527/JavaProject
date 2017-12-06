package com.pms.order.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pms.order.service.OrderService;

@Controller
public class OrderController {

	@Resource
	private OrderService orderService;
}
