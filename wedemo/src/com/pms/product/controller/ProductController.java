package com.pms.product.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.pms.entity.Page;
import com.pms.entity.Product;
import com.pms.product.service.ProductServiceImpl;

@Controller
public class ProductController {
	@Resource
	private ProductServiceImpl productServiceImpl;
	
	@RequestMapping("/deleteallcp")
	public String deleteAllCp(HttpSession session) {
		this.productServiceImpl.deleteAllCp(session);
		return "cart";
	}
	@RequestMapping("/deletecp")
	public String deletcp(@RequestParam("id") int id, HttpSession session){
		this.productServiceImpl.deletecp(id, session);
		return "redirect:http://localhost:8080/wedemo/cart.jsp#myself";
	}
	@RequestMapping("/showcart")
	public String showCart() {
		return "cart";
	}

	@RequestMapping("/addcart")
	public String addCart(@RequestParam("id") int id,HttpSession session,Model model) {
		this.productServiceImpl.createCar(id, session);
		return "redirect:http://localhost:8080/wedemo/product.jsp#myself";
	}
	@RequestMapping("/controdeletepro")
	public String controDeleteProduct(@RequestParam("id") int id) {
		this.productServiceImpl.deleteProduct(id);
		return "redirect:/controp?pageNum=1&controtype=Product";
	}
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public String addProductController(Product p) {
		this.productServiceImpl.save(p);
		return "redirect:/controp?pageNum=1&controtype=Product";
	}
	@RequestMapping(value="/addproduct",method=RequestMethod.GET)
	public String toAddProduct() {
		return "controaddproduct";
	}
	@RequestMapping(value="/modifyproduct",method=RequestMethod.GET)
	public String toModifyProduct(@RequestParam("id") int id, HttpSession session) {
		Product p = this.productServiceImpl.find(id);
		session.setAttribute("product", p);
		return "controupdateproduct";
	}
	@RequestMapping(value="/modifyproduct",method=RequestMethod.POST)
	public String modifyProduct(Product p) {
		System.out.println("controller犯法发"+p.getId()+p.getName()+p.getDescription());
		this.productServiceImpl.updateProduct(p);
		return "redirect:/controp?pageNum=1&controtype=Product";
	}
	
	@RequestMapping("/controp")
	public String findProductByPageControp(@RequestParam("pageNum") int pageNum,@RequestParam("controtype") String controtype,
			HttpSession session){
		Page<?> p = this.productServiceImpl.findByPage(pageNum, 6, controtype);
		session.setAttribute("productpage",p);
		
		return "contro";
	}
	@RequestMapping("/controuser")
	public String findProductByPageControUser(@RequestParam("pageNum") int pageNum,@RequestParam("controtype") String controtype,
			HttpSession session){
		Page<?> p = this.productServiceImpl.findByPage(pageNum, 6, controtype);
		session.setAttribute("userpage",p);
		return "controuser";
	}
	@RequestMapping("/controorder")
	public String findProductByPageControOrder(@RequestParam("pageNum") int pageNum,@RequestParam("controtype") String controtype,
			HttpSession session){
		Page<?> p = this.productServiceImpl.findByPage(pageNum, 6, controtype);
		session.setAttribute("orderpage",p);
		return "controorder";
	}
	@RequestMapping("/controuserorder")
	public String findUserByPageControOrder(@RequestParam("id") String id,@RequestParam("pageNum") int pageNum,@RequestParam("controtype") String controtype,
			HttpSession session){
		System.out.println("订单查询");
		Page<?> p = this.productServiceImpl.findOrderByPage(id,pageNum, 6, controtype);
		session.setAttribute("orderpage",p);
		session.setAttribute("id", id);
		return "controorder";
	}
	@RequestMapping("/list")
	public String findProductByPage(@RequestParam("pageNum") int pageNum,@RequestParam("controtype") String controtype,
			HttpSession session){
//		out.print("<script language=\"javascript\">alert('登录失败！');window.location.href='/你的工程名/login'</script>");
		Page<?> p = this.productServiceImpl.findByPage(pageNum, 6, controtype);
		session.setAttribute("productpage",p);
		return "list";
	}
	
	@RequestMapping("/product")
	public String product(Product pd,Model model,HttpSession session){
		Product p=this.productServiceImpl.find(pd.getId());
		session.setAttribute("p", p);
		return "redirect:http://localhost:8080/wedemo/product.jsp#myself";
	}	
	@RequestMapping(value="/delete/{pid}")
	public String delete(@PathVariable int pid){
		System.out.println("sadf");
		return "";
	}

}
