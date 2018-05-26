package cn.rlshop.mapper;

import java.util.List;

import cn.rlshop.model.OrderInfo;
import cn.rlshop.model.Orders;


public interface OrderMapper {
	

	/**
	 * 添加订单
	 * @param o
	 */
	public void addOrders(Orders order);
	
	/**
	 * 添加订单项
	 * @param o
	 */
	public void addOrderInfo(OrderInfo oi);
	
	
	
	/**
	 * 根据用户id查询订单id
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
