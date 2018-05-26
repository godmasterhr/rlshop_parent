package cn.rlshop.service;

import java.util.List;
import java.util.Map;

import cn.rlshop.model.Item;
import cn.rlshop.model.OrderInfo;
import cn.rlshop.model.Orders;
import cn.rlshop.model.User;


public interface OrderService {
	
	/**
	 * 添加订单(包括订单项)
	 */
	public void addOrders(Map<Item,Integer> cart,User user);
	
	/**
	 * 根据用户id查询订单
	 * @param userId
	 * @return
	 */
	public List<Orders> findOrderIdByUserId(String userId);
	
	/**
	 * 根据订单id查询所有的订单项
	 * @param orderId
	 * @return
	 */
	public List<OrderInfo> findOrderInfoByOrderId(String orderId);
	
	/**
	 * 去支付
	 * @param orderId
	 */
	public void pay(String orderId);
}
