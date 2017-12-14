package com.pms.product.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pms.entity.Order;
import com.pms.entity.Page;
import com.pms.entity.Product;
import com.pms.entity.User;

import service.Cart;
import service.CartItem;

@Repository
public class ProductDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	public void saveProduct(Product p) {
		this.sessionFactory.getCurrentSession().save(p);
		this.sessionFactory.getCurrentSession().flush();
	}
	public List findProductType() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("select typeid from Product");
		List list = query.list();
		Iterator ot = list.iterator();
		while(ot.hasNext()) {
			
		}
		return list;
	}
	public void deleteAllCp(HttpSession session) {
		Cart c = (Cart) session.getAttribute("cart");
		HashMap<Integer,CartItem> map = (HashMap<Integer, CartItem>) c.shopcart;
		List<Integer> list = new ArrayList<Integer>();
		for (Map.Entry<Integer, CartItem> entry : map.entrySet()) {
				list.add(entry.getKey());
			}
		 for (Iterator<Integer> it = list.iterator(); it.hasNext();) {  
			 c.shopcart.remove(it.next());
		    }  
		session.removeAttribute("cart");
	}
	public void deletecp(int id, HttpSession session) {
		Cart c = (Cart) session.getAttribute("cart");
		c.shopcart.remove(id);
	}
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
	public Product updateProduct(Product p){
		System.out.println("daoppppp犯法"+p.getId());
//		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product where name=?");
//		query.setString(0, p.getName());
//		Product po = (Product) query.uniqueResult();
//		System.out.println("dao犯法"+po.getId());
		Product p1 = this.sessionFactory.getCurrentSession().get(Product.class, p.getId());
		p1.setDescription(p.getDescription());
		p1.setName(p.getName());
		p1.setPrice(p.getPrice());
		p1.setTypeid(p.getTypeid());
		this.sessionFactory.getCurrentSession().update(p1);
		this.sessionFactory.getCurrentSession().flush();
		return p;
	}
	public void deleteProduct(int id) {
		Product p = this.sessionFactory.getCurrentSession().get(Product.class, id);
		this.sessionFactory.getCurrentSession().delete(p);
	}
	public Product findByName(String name){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Order where name = ?");
		query.setString(0, name);
		return (Product) query.uniqueResult();
	}
	public int finTotalCount(String controtype) {
		String hql = "select count(*)  from "+controtype;
	    int count = ((Long) this.sessionFactory.getCurrentSession().createQuery(hql).iterate().next()).intValue();
	    return count;
	}
	public int findOrderTotalCount(String id) {
		String hql = "select count(*)  from Order where user=?";
		Query query= this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
	    int count = ((Long) query.iterate().next()).intValue();
	    return count;
	}
	@SuppressWarnings("unchecked")
	public Page<Product> findByPage(int num,int size,String controtype) {
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from "+controtype+" order by id");
			query.setFirstResult(num*size-size);
			query.setMaxResults(size);
			List<Product> list = query.list();
			Page<Product> p =new Page<Product>(num,size);
			p.setList(list);
			p.setTotalCount(this.finTotalCount(controtype));
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public Page findOrderByPage(String id,int num,int size,String controtype) {
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from "+controtype+" where user=?");
			query.setString(0, id);
			query.setFirstResult(num*size-size);
			query.setMaxResults(size);
			List<Product> list = query.list();
			Page<Product> p =new Page<Product>(num,size);
			p.setList(list);
			p.setTotalCount(this.findOrderTotalCount(id));
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
