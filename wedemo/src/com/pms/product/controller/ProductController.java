package com.pms.product.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pms.entity.Page;
import com.pms.entity.Product;
import com.pms.product.service.ProductServiceImpl;

@Controller
public class ProductController {
	@Resource
	private ProductServiceImpl productServiceImpl;
	@Resource
	private SessionFactory sessionFactory;
	
	@RequestMapping("/showcart")
	public String showCart() {
		return "cart";
	}
	@RequestMapping("/addcart")
	public String addCart(@RequestParam("id") int id,HttpSession session,Model model) {
		this.productServiceImpl.createCar(id, session);
//		Iterator i = c.shopcart.values().iterator();
//		while(i.hasNext()) {
//			CartItem ci =(CartItem) i.next();
//			System.out.println(ci.getP().getName() + ci.getCount());
//		}
		return "product";
	}
	@RequestMapping("/list")
	public String findProductByPage(@RequestParam("pageNum") int pageNum,Model model){
//		out.print("<script language=\"javascript\">alert('登录失败！');window.location.href='/你的工程名/login'</script>");
		Page<?> p = this.productServiceImpl.findByPage(pageNum, 6);
		model.addAttribute("page",p);
		return "list";
	}
	
	@RequestMapping("/product")
	public String product(Product pd,Model model,HttpServletRequest request){
		Product p=this.productServiceImpl.find(pd.getId());
		model.addAttribute("p", p);
		return "product";
	}	
	@RequestMapping(value="/delete/{pid}")
	public String delete(@PathVariable int pid){
		System.out.println("sadf");
		return "";
	}

}
