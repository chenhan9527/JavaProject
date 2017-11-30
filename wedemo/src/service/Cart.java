package service;

import com.pms.entity.Product;
import java.util.HashMap;
import java.util.Map;
import service.CartItem;


public class Cart {
	public Map<Integer,CartItem> shopcart = new HashMap<Integer,CartItem>();
	public Map<Integer, CartItem> getShopcart() {
		return shopcart;
	}
	public void setShopcart(Map<Integer, CartItem> shopcart) {
		this.shopcart = shopcart;
	}
	public void addCart(Product p) {
		if(shopcart.containsKey(p.getId())) {
			CartItem ci = shopcart.get(p.getId());
			ci.setCount(ci.getCount()+1);
			ci.setTotalPrice();
		}else {
			CartItem c = new CartItem();
			c.setCount(1);
			c.setP(p);
			c.setTotalPrice();
			shopcart.put(p.getId(), c);
		}
	}
}
