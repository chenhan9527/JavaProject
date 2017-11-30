package com.pms.user.coontroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pms.entity.User;
import com.pms.user.service.UserServiceImpl;



@Controller
public class UserController {
	
	@Resource
	private UserServiceImpl userSeriviceimpl;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,HttpSession session) {
		User u1 = this.userSeriviceimpl.findUser(id);
		if(u1 != null){
			System.out.println(u1.getName()+"controller");
			session.setAttribute("user", u1);
			return "redirect:list?pageNum=1";
		}else {
			return "redirect:list?pageNum=1";
		}
	}

	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String add(User u,HttpSession session){
		this.userSeriviceimpl.add(u);
		session.setAttribute("user", u);
		return "redirect:list?pageNum=1";	
	}
	
}
