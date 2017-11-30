package service;

import com.pms.entity.Product;

public class CartItem {
	private Product p;
	private int count;
	private int totalPrice;
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice() {
		this.totalPrice = p.getPrice() * count;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
