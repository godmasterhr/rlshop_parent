package cn.rlshop.model;

import java.util.Map;

public class OrderInfo {
	
	private String orderId;
	private String itemId;
	private String itemTitle;
	private Double price;
	private Integer num;
	private String itemUrl;
	
	
	
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemUrl() {
		return itemUrl;
	}
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
}	
