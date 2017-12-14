package com.pms.order.dao;

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

import com.pms.entity.Address;
import com.pms.entity.Order;
import com.pms.entity.User;
import com.pms.product.dao.ProductDaoImpl;

import service.Cart;
import service.CartItem;


@Repository
public class OrderDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;

	
	public Order findOrderById(int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Order where id=?");
		query.setInteger(0, id);
		
		return (Order) query.uniqueResult();
	}
	public void saveOrder(Order order) {
		this.sessionFactory.getCurrentSession().save(order);
		this.sessionFactory.getCurrentSession().flush();
	}
	public Order findOrderUser(String id,String username) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Order where name=? and user=?");
		query.setString(0, id);
		query.setString(1, username);
		
		return (Order) query.uniqueResult();
	}
	public List findAll(HttpSession session) {
		
		Cart c = (Cart) session.getAttribute("cart");
		HashMap<Integer,CartItem> map = (HashMap) c.shopcart;
		User u = (User) session.getAttribute("user");
		Query qery1 = this.sessionFactory.getCurrentSession().createQuery("from Address where user=?");
		qery1.setString(0, u.getId());
		for (Map.Entry<Integer, CartItem> entry : map.entrySet()) {
				int key = entry.getKey();
//			   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			   
			   Order ord = this.findOrderUser(entry.getValue().getP().getName(),u.getId());
				if(findOrderUser(c.shopcart.get(entry.getKey()).getP().getName(),u.getId()) != null) {
					Order order = this.sessionFactory.getCurrentSession().get(Order.class, ord.getId());
					order.setCount(order.getCount()+c.shopcart.get(key).getCount());
					order.setPrice(c.shopcart.get(key).getP().getPrice()*order.getCount());
					this.sessionFactory.getCurrentSession().update(order);
					this.sessionFactory.getCurrentSession().flush();
				}else {
					Order order = new Order();
					List list = new ArrayList();
					list=qery1.list();
					Iterator it = list.iterator();
					while(it.hasNext()) {
						Address ad = (Address) it.next();
						order.setUseraddress(ad.getProvince()+ad.getCity()+ad.getDistrict()+ad.getDetail());
						break;
					}
					order.setCount(c.shopcart.get(key).getCount());
					order.setPrice(c.shopcart.get(key).getTotalPrice());
					order.setName(c.shopcart.get(key).getP().getName());
					order.setUser(u);
					this.sessionFactory.getCurrentSession().save(order);
					this.sessionFactory.getCurrentSession().flush();
				}
			  }
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Order where user=?");
		query.setString(0, u.getId());
		return query.list();
	}

	
	public void deletOrder(int id) {
		Order order = this.sessionFactory.getCurrentSession().get(Order.class, id);
		this.sessionFactory.getCurrentSession().delete(order);
		this.sessionFactory.getCurrentSession().flush();
	}
}
