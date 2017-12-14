package com.pms.order.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pms.entity.Order;
import com.pms.entity.Page;
import com.pms.order.service.OrderService;
import com.pms.product.service.ProductServiceImpl;

@Controller
public class OrderController {

	@Resource
	private OrderService orderService;
	@Resource
	private ProductServiceImpl productServiceImpl;
	
	@RequestMapping("/orders")
	public String findAll(HttpSession session) {
		List list = this.orderService.findAll(session);
		session.setAttribute("anorder", list);
		return "order";
	}
	
	@RequestMapping("/controorderbyid")
	public String findOrderById(@RequestParam("id") int id,HttpSession session) {
		Order order = this.orderService.findOrderById(id);
		session.setAttribute("idorder",order);
		return "controorderbyid";
	}
//	@RequestMapping(value="/controorderbyid",method=RequestMethod.POST)
//	public String findControOrderById(int id,HttpSession session) {
//		Order order = this.orderService.findOrderById(id);
//		session.setAttribute("idorder",order);
//		return "controorderbyid";
//	}
	@RequestMapping("/controorderdelete")
	public String deleteControOrder(@RequestParam("id") int id,HttpSession session) {
		this.orderService.deleteOrder(id);
		Page<?> p = this.productServiceImpl.findByPage(1, 6, "Order");
		session.setAttribute("orderpage",p);
		return "controorder";
	}
	@RequestMapping("/deleteorder")
	public String deleteOrder(@RequestParam("id") int id,HttpSession session) {
		this.orderService.deleteOrder(id);
		List list = this.orderService.findAll(session);
		session.setAttribute("anorder", list);
		return "redirect:http://localhost:8080/wedemo/order.jsp#myself";
	}
	
}
