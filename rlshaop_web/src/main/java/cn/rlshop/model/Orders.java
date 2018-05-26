package cn.rlshop.model;

import java.util.Date;
import java.util.Map;

public class Orders {
	
	private String orderId;
	private String userId;
	private String name;
	private String address;
	private Double sumPrice;
	private Date orderTime;
	private String payMode;
	private Map<Item,Integer> itemMap;
	
	
	
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Map<Item, Integer> getItemMap() {
		return itemMap;
	}
	public void setItemMap(Map<Item, Integer> itemMap) {
		this.itemMap = itemMap;
	}
	public Double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
