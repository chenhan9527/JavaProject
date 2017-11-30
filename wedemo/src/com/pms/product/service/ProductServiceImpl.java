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
	
	public void createCar(int id,HttpSession session){
		this.dao.createCar(id, session);
	}
	public Product find(int id) {
		Product p = this.dao.find(id);
		if(p!=null) {
			return p;
		}else {
			return null;
		}
	}
	
	public int findTotalCount() {
		System.out.println("findTotalCount Service");
		return this.dao.finTotalCount();
	}
	public Page<?> findByPage(int num,int size) {
		System.out.println("findByPage Service");
		return this.dao.findByPage(num, size);
	}
	
	public List<Product> listProducts(){
		List<Product> list = this.dao.findAll();
		return list;
	}
	
	
}
