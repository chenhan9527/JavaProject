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

import com.pms.entity.User;
import com.pms.user.service.UserServiceImpl;



@Controller
public class UserController {
	
	@Resource
	private UserServiceImpl userSeriviceimpl;
	
	
	@RequestMapping("/check")
	@ResponseBody
	public String check(@RequestParam("id") String id) {
		User u = this.userSeriviceimpl.findUser(id);
		String msg = " ";
		if(u != null) {
			msg = "this name is already uesed";
			return msg;
		}
		return msg;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User u,HttpSession session,HttpServletResponse response) throws IOException {
		User u1 = this.userSeriviceimpl.findUser(u.getId());
		if(u1.getId().equals(u.getId()) && u1.getPassword().equals(u.getPassword())){
			session.setAttribute("user", u1);
			return "redirect:list?pageNum=1";
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('UserName Wrong!!');"
					+ "window.location.href='list.jsp';</script>");
			return null;
		}
	}

	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String add(User u,HttpSession session){
		this.userSeriviceimpl.add(u);
		System.out.println("addUser ok");
		session.setAttribute("user", u);
		return "redirect:list?pageNum=1";	
	}
	
}
