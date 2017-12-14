package com.pms.product.service;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.entity.Page;
import com.pms.entity.Product;
import com.pms.product.dao.ProductDaoImpl;

@Service
@Transactional(readOnly=true)
public class ProductServiceImpl {

	@Resource
	private ProductDaoImpl dao;
	
	public void save(Product p) {
		this.dao.saveProduct(p);
	}
	public List findTypeId() {
		return this.dao.findProductType();
	}
	public void deleteAllCp(HttpSession session) {
		this.dao.deleteAllCp(session);
	}
	public void deletecp(int id, HttpSession session) {
		this.dao.deletecp(id, session);
	}
	public void createCar(int id,HttpSession session){
		this.dao.createCar(id, session);
	}
	public void updateProduct(Product p) {
		this.dao.updateProduct(p);
	}
	public void deleteProduct(int id) {
		this.dao.deleteProduct(id);
	}
	public Product find(int id) {
		Product p = this.dao.find(id);
		if(p!=null) {
			return p;
		}else {
			return null;
		}
	}
	public Product findByName(String name) {
		return this.dao.findByName(name);
	}
	public Page<?> findByPage(int num,int size,String controtype) {
		return this.dao.findByPage(num, size,controtype);
	}
//	public Page<?> findOrderByPage(String id,int num,int size,String controtype) {
//		return this.dao.findOrderByPage(id, num, size,controtype);
//	}
	public Page findOrderByPage(String id, int num, int size, String controtype) {
		return this.dao.findOrderByPage(id, num, size, controtype);
	}
	
	public List<Product> listProducts(){
		List<Product> list = this.dao.findAll();
		return list;
	}
	
	
}
