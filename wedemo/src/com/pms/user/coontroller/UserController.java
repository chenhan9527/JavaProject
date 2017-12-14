package com.pms.user.coontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pms.entity.Address;
import com.pms.entity.Page;
import com.pms.entity.User;
import com.pms.product.service.ProductServiceImpl;
import com.pms.user.service.UserServiceImpl;



@Controller
public class UserController {
	
	@Resource
	private UserServiceImpl userSeriviceimpl;
	@Resource
	private ProductServiceImpl productServiceImpl;
	
	
	@RequestMapping("/checkuser")
	@ResponseBody
	public String check(@RequestParam("id") String id) {
		User u = this.userSeriviceimpl.findUser(id);
		String msg = "用户名不可用";
		if(u != null) {
			msg = "this name is already uesed";
			return msg;
		}
		return msg;
	}
	@RequestMapping("/checkpassword")
	@ResponseBody
	public String checkPassword(@RequestParam("num1") String num1,@RequestParam("num2") String num2) {
		
		String msg = "yizhi";
		if(!num1.equals(num2)) {
			msg = "buyizhi";
			return msg;
		}
		return msg;
	}
	@RequestMapping("/toaddress")
	public String toAddress() {
		return "address";
	}
	@RequestMapping(value="/addAddress",method=RequestMethod.POST)
	public String addAddress(Address address, HttpSession session) {
		this.userSeriviceimpl.addAddress(address,session);
		return "redirect:list?pageNum=1&controtype=Product";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User u,HttpSession session,HttpServletResponse response) throws IOException {
		User u1 = this.userSeriviceimpl.findUser(u.getId());
		if(u1.getId().equals(u.getId()) && u1.getPassword().equals(u.getPassword())){
			session.setAttribute("user", u1);
			if(u1.getId().equals("111") && u1.getPassword().equals("222")) {
				Page<?> p = this.productServiceImpl.findByPage(1, 6, "User");
				session.setAttribute("userpage",p);
				return "controuser";
			}
			return "redirect:list?pageNum=1&controtype=Product";
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('UserName Wrong!!');"
					+ "window.location.href='list.jsp';</script>");
			return null;
		}
	}
	@RequestMapping("/exituser")
	public String tuixhu(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:list?pageNum=1&controtype=Product";
	}
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String add(User u,HttpSession session){
		this.userSeriviceimpl.add(u);
		session.setAttribute("user", u);
		return "redirect:list?pageNum=1&controtype=Product";	
	}
	
}
