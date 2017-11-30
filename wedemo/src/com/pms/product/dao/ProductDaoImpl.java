package com.pms.product.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pms.entity.Page;
import com.pms.entity.Product;

import service.Cart;

@Repository
public class ProductDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public void createCar(int id,HttpSession session){
		Product p =this.find(id);
		Cart c = (Cart) session.getAttribute("cart");
		if(c == null) {
			c = new Cart();
		}
		c.addCart(p);
		session.setAttribute("cart", c);
		session.setAttribute("p", p);
	}
	@SuppressWarnings("unchecked")
	public List<Product> findAll(){
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from Product");
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public Product find(int id){
		Product p = (Product) this.sessionFactory.getCurrentSession().get(Product.class,id );
		return p;
	}
	public int finTotalCount() {
		System.out.println("findTotaCount Dao");
		String hql = "select count(*)  from Product";
	    int count = ((Long) this.sessionFactory.getCurrentSession().createQuery(hql).iterate().next()).intValue();
	    return count;
	}
	@SuppressWarnings("unchecked")
	public Page<Product> findByPage(int num,int size) {
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from Product order by id");
			query.setFirstResult(num*size-size);
			query.setMaxResults(size);
			List<Product> list = query.list();
			Page<Product> p =new Page<Product>(num,size);
			p.setList(list);
			p.setTotalCount(this.finTotalCount());
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}
